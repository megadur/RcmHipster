package com.dtit.tm.adapter.rdq.queueing;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * Generiert messageId für die Websphere MQ Schnittstelle von Radius.
 */

@Component
public class RdqMessageIdGenerator {

    /** The Constant UID_LENGTH. */
    private static final int UID_LENGTH = 24;

    /** The Constant UID_CHARSET. */
    private static final String UID_CHARSET = "0123456789abcdef";

    /**
     * Generiert messageId für die Websphere MQ Schnittstelle von Radius.
     *
     * @return messageID
     */

    public String generateMessageId() {
        return RandomStringUtils.random(UID_LENGTH, UID_CHARSET);
    }
}
