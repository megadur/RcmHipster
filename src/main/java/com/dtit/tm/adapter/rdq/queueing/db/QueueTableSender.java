package com.dtit.tm.adapter.rdq.queueing.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * The Class QueueTableSender.
 */
public class QueueTableSender {

    /** The new tx template. */
    private final TransactionTemplate newTxTemplate;

    /** The jdbc template. */
    private final JdbcTemplate jdbcTemplate;

    /** The table name. */
    private final String tableName;

    /**
     * Instantiates a new queue table sender.
     *
     * @param newTxTemplate the new tx template
     * @param jdbcTemplate the jdbc template
     * @param tableName the table name
     */
    public QueueTableSender(TransactionTemplate newTxTemplate, JdbcTemplate jdbcTemplate, String tableName) {
        this.newTxTemplate = newTxTemplate;
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = tableName;
    }

    /**
     * Send.
     *
     * @param context the context
     * @param payload the payload
     */
    public void send(String context, String payload) {

        send("", context, payload);
    }

    /**
     * Send.
     *
     * @param dispatchKey the dispatch key
     * @param context the context
     * @param payload the payload
     */
    public void send(String dispatchKey, String context, String payload) {

        newTxTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                String queryStr = "INSERT INTO %s(dispatch_key, context, payload) VALUES (?, ?, ?)";

                jdbcTemplate.update(String.format(queryStr, tableName), dispatchKey, context, payload);
            }

            ;

        });

    }

}
