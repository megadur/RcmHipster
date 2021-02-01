package com.dtit.tm.adapter.rdq.queueing.db;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

import javax.annotation.PreDestroy;

/**
 * The Class QueueTableListenerContainer.
 */
// TODO: Refactoring : diese ganze Klasse muss überarbeitet werden
public class QueueTableListenerContainer {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueTableListenerContainer.class);

    /** The executor service. */
    private ExecutorService executorService;

    /** The timer. */
    private Timer timer;

    /** The new tx template. */
    private final TransactionTemplate newTxTemplate;

    /** The jdbc template. */
    private final JdbcTemplate jdbcTemplate;

    /** The table name. */
    private final String tableName;

    /** The pool size. */
    private final int poolSize;

    /** The polling rate. */
    private final long pollingRate;

    /** The map service function. */
    private final Map<String, BiFunction<String, String, Boolean>> mapServiceFunction;

    /**
     * Instantiates a new queue table listener container.
     *
     * @param newTxTemplate the new tx template
     * @param jdbcTemplate the jdbc template
     * @param tableName the table name
     * @param poolSize the pool size
     * @param pollingRate the polling rate
     * @param serviceFunction the service function
     * @param startOnCreate the start on create
     */
    public QueueTableListenerContainer(TransactionTemplate newTxTemplate, JdbcTemplate jdbcTemplate, String tableName, int poolSize, long pollingRate,
                                       BiFunction<String, String, Boolean> serviceFunction, Boolean startOnCreate) {
        this(newTxTemplate, jdbcTemplate, tableName, poolSize, pollingRate,
				// FIXME: Refactoring : was hier gemacht wird, ist ein "anonclass extends
				// HashMap" und sehr sehr 'unschön'.
				new HashMap<String, BiFunction<String, String, Boolean>>() {
					{
						put("", serviceFunction);
					}
				},
        		startOnCreate);
    }

    /**
     * Instantiates a new queue table listener container.
     *
     * @param newTxTemplate the new tx template
     * @param jdbcTemplate the jdbc template
     * @param tableName the table name
     * @param poolSize the pool size
     * @param pollingRate the polling rate
     * @param mapServiceFunction the map service function
     * @param startOnCreate the start on create
     */
    public QueueTableListenerContainer(TransactionTemplate newTxTemplate, JdbcTemplate jdbcTemplate, String tableName, int poolSize, long pollingRate,
                                       Map<String, BiFunction<String, String, Boolean>> mapServiceFunction, Boolean startOnCreate) {

        executorService = new ThreadPoolExecutor(poolSize, poolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        this.newTxTemplate = newTxTemplate;
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = tableName;
        this.poolSize = poolSize;
        this.pollingRate = pollingRate;
        this.mapServiceFunction = mapServiceFunction;

		if (Boolean.TRUE.equals(startOnCreate)) {
			start();
		}
    }

	/**
	 * stop<br>
	 *
	 * Wird mit QuickFix RCM-491 nun beim Shutdown er Applikation aufgerufen.
	 * TODO : spaeter diesen QucikFix rechecken
	 * <br>
	 * see {@link PreDestroy}<br>
	 * <br>
	 *
	 * TODO : Rework der Klasse notwendig das das alles ordentlich im Container funktioniert !
	 *
	 * @return true, if successful
	 */
	@PreDestroy
	public boolean stop() {
		LOGGER.debug("enter #stop");
		boolean result = false;
		if (timer != null) {
			timer.cancel();
			timer = null;
			result = true;
		}
		LOGGER.debug("leave #stop result :[{}]", result);
		return result;
	}

    /**
     * Execute poll.
     */
    public void executePoll() {
        executorService.execute(new PollerTask(newTxTemplate, jdbcTemplate, getPollerQueryString(tableName), mapServiceFunction));
    }

	/**
	 * Start.
	 *
	 * @return true, if successful
	 */
	public boolean start() {
		LOGGER.debug("enter #start");
		boolean result = false;
		if (!isRunning()) {
			timer = new Timer();              // TODO : check deamon flag
			timer.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					executePoll();
				}
			}, 0, pollingRate);
			result = true;
		}
		LOGGER.debug("leave #start result :[{}]", result);
		return result;
	}

    /**
     * Checks if is running.
     *
     * @return true, if is running
     */
    public boolean isRunning() {
    	LOGGER.debug("enter #isRunning");
        boolean result = (timer != null);
        LOGGER.debug("leave #isRunning result :[{}]", result);
        return result;
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        // TODO wtf
        return isEmpty(null);
    }

    /**
     * Checks if is empty.
     *
     * @param dispatchKey the dispatch key
     * @return true, if is empty
     */
    public boolean isEmpty(String dispatchKey) {
        // TODO if TRUE is true ? lol   simple return xxx
        return BooleanUtils.isTrue(newTxTemplate.execute(status -> {
            List<Long> lstCount;
            if (dispatchKey != null) {
                lstCount = jdbcTemplate.query("SELECT count(id) from " + tableName + " where dispatch_key=?",
                        new RowMapperResultSetExtractor<>((rs, rowNum) -> rs.getLong(1), 1), dispatchKey);
            } else {
                lstCount = jdbcTemplate.query("SELECT count(id) from " + tableName,
                        new RowMapperResultSetExtractor<>((rs, rowNum) -> rs.getLong(1), 1));
            }

            if (lstCount.isEmpty()) {
                //darf nicht passieren
                return true;
            } else {
                Long count = DataAccessUtils.nullableSingleResult(lstCount);
                return count == 0;
            }
        }));
    }

    /**
     * Gets the poller query string.
     *
     * @param tableName the table name
     * @return the poller query string
     */
    protected String getPollerQueryString(String tableName) {
        String queryStr = "DELETE FROM %s WHERE id=" +
                "(SELECT id FROM %s ORDER BY id FOR UPDATE SKIP LOCKED LIMIT 1)" +
                " RETURNING dispatch_key, context, payload;";

        return String.format(queryStr, tableName, tableName);
    }

    /**
     * The Class PollerTask.
     */
    private static class PollerTask implements Runnable {

        /** The new tx template. */
        private TransactionTemplate newTxTemplate;

        /** The jdbc template. */
        private JdbcTemplate jdbcTemplate;

        /** The poller query string. */
        private String pollerQueryString;

        /** The map service function. */
        private Map<String, BiFunction<String, String, Boolean>> mapServiceFunction;

        /**
         * Instantiates a new poller task.
         *
         * @param newTxTemplate the new tx template
         * @param jdbcTemplate the jdbc template
         * @param pollerQueryString the poller query string
         * @param mapServiceFunction the map service function
         */
        public PollerTask(TransactionTemplate newTxTemplate, JdbcTemplate jdbcTemplate, String pollerQueryString,
                          Map<String, BiFunction<String, String, Boolean>> mapServiceFunction) {

            this.newTxTemplate = newTxTemplate;
            this.jdbcTemplate = jdbcTemplate;
            this.pollerQueryString = pollerQueryString;
            this.mapServiceFunction = mapServiceFunction;
        }

        /**
         * Run.
         */
        @Override
        public void run() {

            class Message {
                private String dispatchKey;
                private String context;
                private String payload;

                public Message(String dispatchKey, String context, String payload) {
                    this.dispatchKey = dispatchKey;
                    this.context = context;
                    this.payload = payload;
                }

                public String getDispatchKey() {
                    return dispatchKey;
                }

                public String getContext() {
                    return context;
                }

                public String getPayload() {
                    return payload;
                }
            }

            newTxTemplate.execute(new TransactionCallbackWithoutResult() {

                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {

                    List<Message> lstMessage = jdbcTemplate.query(pollerQueryString,
                            new RowMapperResultSetExtractor<>((rs, rowNum) -> new Message(rs.getString(1), rs.getString(2), rs.getString(3)), 1));

                    if (!lstMessage.isEmpty()) {
                        Message message = DataAccessUtils.nullableSingleResult(lstMessage);
                        try {
                            LOGGER.debug("Service wird ausgeführt, dispatchKey: {}", message.getDispatchKey());
                            if (!mapServiceFunction.get(message.getDispatchKey()).apply(message.getContext(), message.getPayload())) {
                                LOGGER.debug("Rueckgabewert FALSE, Queue-Transaktion wird zurueckgerollt");
                                status.setRollbackOnly();
                            } else {
                                LOGGER.debug("Rueckgabewert TRUE, Nachricht wird dequeued");
                            }
                        } catch (Throwable t) {
                            LOGGER.debug("Exception, Queue-Transaktion wird zurueckgerollt", t);
                            status.setRollbackOnly();
                        }
                    }

                }

            });
        }
    }
}
