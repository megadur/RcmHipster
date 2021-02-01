package com.dtit.tm.adapter.rdq.queueing;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;

import javax.net.ssl.SSLContext;

/**
 * The Class UserCredentialsMQConnectionFactoryAdapter.
 */
public class UserCredentialsMQConnectionFactoryAdapter extends UserCredentialsConnectionFactoryAdapter {

    /** The mq queue connection factory. */
    private MQQueueConnectionFactory mqQueueConnectionFactory;

    /**
     * Instantiates a new user credentials MQ connection factory adapter.
     *
     * @param mqQueueConnectionFactory .
     */
    public UserCredentialsMQConnectionFactoryAdapter(MQQueueConnectionFactory mqQueueConnectionFactory) {

        this.mqQueueConnectionFactory = mqQueueConnectionFactory;
        this.setTargetConnectionFactory(mqQueueConnectionFactory);
    }

    /**
     * Sets the SSL cipher suite.
     *
     * @param cipherSuite .
     */
    public void setSSLCipherSuite(String cipherSuite) {
        mqQueueConnectionFactory.setSSLCipherSuite(cipherSuite);
    }

    /**
     * Sets the SSL context.
     *
     * @param sslContext .
     */
    public void setSSLContext(SSLContext sslContext) {
        if (sslContext != null)
            mqQueueConnectionFactory.setSSLSocketFactory(sslContext.getSocketFactory());
    }

}
