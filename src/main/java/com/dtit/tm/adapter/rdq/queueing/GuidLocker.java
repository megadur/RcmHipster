package com.dtit.tm.adapter.rdq.queueing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * The Class GuidLocker.
 */
@Component
public class GuidLocker {

    /** The jdbc template. */
    private JdbcTemplate jdbcTemplate;

    /** The new tx template. */
    private TransactionTemplate newTxTemplate;

    /** The lock timeout. */
    private Integer lockTimeout;


    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GuidLocker.class);

    /**
     * Instantiates a new guid locker.
     *
     * @param jdbcTemplate .
     * @param newTxTemplate .
     * @param lockTimeout .
     */
    @Autowired
    public GuidLocker(JdbcTemplate jdbcTemplate,
                      @Qualifier("newTxTemplate") TransactionTemplate newTxTemplate,
                      @Value("${rdq.guid.lock.timeout:0}") Integer lockTimeout) {

        this.jdbcTemplate = jdbcTemplate;
        this.newTxTemplate = newTxTemplate;
        this.lockTimeout = lockTimeout;
    }

    /**
     * Sets the lock.
     *
     * @param guid .
     */
    public void setLock(final String guid) {

        if (guid == null) return;

        if (lockTimeout == 0) {
            LOGGER.info("GUID Lock ist nicht aktiviert");
            return;
        }

        LOGGER.debug("GUID Lock fuer {} wird gesetzt", guid);

        String sqlLock = String.format("set local lock_timeout to '%ds';", lockTimeout);
        jdbcTemplate.update(sqlLock);

        //UPSERT GUID
        newTxTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                jdbcTemplate.update("INSERT INTO GUID_LOCK(GUID) VALUES(?) ON CONFLICT DO NOTHING;", guid);
            }
        });

        List<String> lstLocked = jdbcTemplate.query("SELECT GUID FROM GUID_LOCK WHERE GUID = ? FOR UPDATE;",
                (rs, rownum) -> new String(rs.getString("GUID")), guid);

        if (!lstLocked.isEmpty()) {
            LOGGER.debug("GUID Lock fuer {} wurde gesetzt", guid);
        } else {
            LOGGER.error("GUID Lock fuer {} konnte nicht gesetzt werden", guid);
        }
    }

    /**
     * Clear unlocked.
     */
    public void clearUnlocked() {

        if (lockTimeout == 0) return;

        LOGGER.debug("Unlocked GUIDs werden geloescht");
        newTxTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                jdbcTemplate.update("DELETE FROM GUID_LOCK WHERE GUID IN (SELECT GUID FROM GUID_LOCK FOR UPDATE SKIP LOCKED);");
            }
        });
        LOGGER.debug("Unlocked GUIDs wurden geloescht");

    }
}
