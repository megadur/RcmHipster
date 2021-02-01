package com.dtit.tm.adapter.rdq.queueing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.xml.bind.DatatypeConverter;

import com.dtit.tm.domain.GuidConverter;
import com.dtit.tm.repository.IpAccessRepository;
import com.ibm.jms.JMSBytesMessage;
import com.ibm.jms.JMSMessage;
import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.constants.MQConstants;
import com.ibm.msg.client.wmq.WMQConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class JmsAdapter {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JmsAdapter.class);

    /** The rdq request jms template. */
    private final JmsTemplate rdqRequestJmsTemplate;

    /** The rdq response jms template. */
    private final JmsTemplate rdqResponseJmsTemplate;

    /** The new tx template. */
    private final TransactionTemplate newTxTemplate;

    /** The guid locker. */
    private final GuidLocker guidLocker;

    /** The rdq request queue name. */
    @Value("${rdq.request.queuename}")
    private String rdqRequestQueueName;

    /** The rdq response queue name. */
    @Value("${rdq.response.queuename}")
    private String rdqResponseQueueName;

    /**
     * The rdq timb support. : einfach per String umgesetzt, kann man spaeter mal
     * als bool machen, wenn mans überhaupt braucht
     */
    @Value("${rdq.timb.support}")
    private String rdqTimbSupport;

    /**
     * Instantiates a new rdq request sender.
     *
     * @param rdqRequestJmsTemplate  .
     * @param rdqResponseJmsTemplate .
     * @param newTxTemplate          .
     * @param orderService           .
     * @param guidLocker             .
     * @param fluentdLogger          the fluentd logger
     */

    @Autowired
    public JmsAdapter(@Qualifier("rdqRequestJmsTemplate") JmsTemplate rdqRequestJmsTemplate,
            @Qualifier("rdqResponseJmsTemplate") JmsTemplate rdqResponseJmsTemplate,
            @Qualifier("newTxTemplate") TransactionTemplate newTxTemplate, IpAccessRepository orderService,
            GuidLocker guidLocker) {

        this.rdqRequestJmsTemplate = rdqRequestJmsTemplate;
        this.rdqResponseJmsTemplate = rdqResponseJmsTemplate;
        this.newTxTemplate = newTxTemplate;
        this.guidLocker = guidLocker;
    }

    /**
     * Schickt den Request an Radius und wartet auf die Antwort. Das Verhalten ist
     * ähnlich zu Radius GW: der Thread wird solange blockiert bis eine Antwort
     * ankommt.
     *
     * @param msgId          the msg id
     * @param requestPayload Request
     * @return Response oder null wenn nicht gefunden
     */
    public String sendAndReceive(String auftragId, String msgId, String toNr, String requestPayload) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("enter #sendAndReceive Sende Nachricht:  auftragId :[{}], msgId :[{}], payload.lenght :[{}]",
                    auftragId, msgId, (requestPayload != null ? requestPayload.length() : "null"));
        }
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("#sendAndReceive Sende Nachricht: payload :[{}]", requestPayload);
        }

        //
        String result = null;
        try {

            // messages & timestamps
            Message m = new Message();
            m.setRequestTime(LocalDateTime.now());
            m.setRequestMessage(requestPayload);
            m.setRequestUrl(rdqRequestQueueName);
            m.setMsgId(msgId);

            //
            result = newTxTemplate.execute( new TransactionCallback<String>() {
                @Override
                public String doInTransaction(TransactionStatus status) {

                    //
                    final String guid = GuidConverter.convert(toNr);
                    if (guid == null) {
                        LOGGER.warn("GUID is null. Source ToNr :[{}]", toNr);
                    } else {
                        guidLocker.setLock(guid);
                    }

                    doSend(auftragId, msgId, requestPayload);
                    // warte auf die Antwort
                    String ret = null;
                    try {
                        ret = doReceive(m, msgId);
                    } catch (JMSException e) {
                        try {
                            throw WorkflowException.create(WorkflowError.JMS_RECEIVE_ERROR, null, null, auftragId, e);
                        } catch (Exception e1) {
                             e1.printStackTrace();
                        }
                    }
                    return ret;
                }
            });

        } finally {
            guidLocker.clearUnlocked();
        }
        //
        LOGGER.debug("leave #sendAndReceive result :[{}]", result);
        return result;
    }

    private void doSend(String auftragId, String msgId, String requestPayload) {
        rdqRequestJmsTemplate.send(rdqRequestQueueName, session -> {
            TextMessage textMessage = session.createTextMessage(requestPayload);
            textMessage.setJMSCorrelationID(msgId);
            textMessage.setJMSMessageID(msgId);

            /*
             * ?? evt spaeter mal klaeren warum nicht diese Konstanten
             * JmsConstants.JMS_IBM_MSGTYPE JmsConstants.JMS_IBM_MQMD_REPLYTOQ
             * JmsConstants.JMS_IBM_MQMD_MSGID
             */

            // DIGIHUB-79265 Props setzen wenn wenn rdq.timb.support=true , also ueber TIMB
            // Anm: ueber rdq.cf.sslciphersuite= kann man dennoch ssl canceln
            if (Boolean.TRUE.toString().equalsIgnoreCase(rdqTimbSupport)) {

                // JMS_IBM_MQMD_MsgType : Message type : Integer
                // per TIMB Docu : "MQMT_REQUEST"
                LOGGER.debug("MessageType key :[{}] value :[{}]", WMQConstants.JMS_IBM_MSGTYPE,
                        MQConstants.MQMT_REQUEST);
                textMessage.setIntProperty(WMQConstants.JMS_IBM_MSGTYPE, MQConstants.MQMT_REQUEST);

                // JMS_IBM_MQMD_ReplyToQ : Name of reply queue : String
                LOGGER.debug("ReplyToQ key :[{}] value :[{}]", WMQConstants.JMS_IBM_MQMD_REPLYTOQ,
                        rdqResponseQueueName);
                textMessage.setStringProperty(WMQConstants.JMS_IBM_MQMD_REPLYTOQ, rdqResponseQueueName);

            }

            try {

                // JMS_IBM_MQMD_MsgId : Message identifier : Object (byte[])
                LOGGER.debug("MSGID key :[{}] value :[{}]", WMQConstants.JMS_IBM_MQMD_MSGID, msgId);
                textMessage.setObjectProperty(WMQConstants.JMS_IBM_MQMD_MSGID,
                        msgId.getBytes(StandardCharsets.UTF_8.name()));

            } catch (UnsupportedEncodingException e) {
                try {
                    throw WorkflowException.create(WorkflowError.JMS_SET_PROPERTY_FAILED, null, null, auftragId, e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            return textMessage;
        });

    }

    /**
     * Do receive.
     *
     * @param protokollMessage .
     * @param msgId            .
     * @return the string
     * @throws JMSException the JMS exception
     */
    private String doReceive(Message protokollMessage, String msgId) throws JMSException {

        String strSelector = String.format("JMSCorrelationID = 'ID:%s'",
                DatatypeConverter.printHexBinary(msgId.getBytes(StandardCharsets.UTF_8)));
        LOGGER.debug("Radius Response Message Selector: :[{}]", strSelector);

        JMSMessage message = (JMSMessage) rdqResponseJmsTemplate.receiveSelected(rdqResponseQueueName, strSelector);
        if (message == null) {
            LOGGER.warn("Radius Response fuer Request ID :[{}] NICHT gefunden", msgId);
            return null;
        }

        String text;
        if (message instanceof JMSTextMessage) {
            text = ((JMSTextMessage) message).getText();
        } else if (message instanceof JMSBytesMessage) {
            byte[] byteData = null;
            JMSBytesMessage byteMessage = (JMSBytesMessage) message;
            byteData = new byte[(int) byteMessage.getBodyLength()];
            byteMessage.readBytes(byteData);
            byteMessage.reset();
            text = new String(byteData, StandardCharsets.ISO_8859_1); // todo iso ?!
        } else {
            LOGGER.warn("Nachricht Payload Type nicht unterstützt :[{}]", message.getClass().getCanonicalName());
            text = null;
        }

        if (text == null) {
            LOGGER.warn("Radius Response fuer Request ID :[{}] NULL", msgId);
            return null;
        } else {
            LOGGER.debug("Radius Response fuer Request ID :[{}] wurde gefunden", msgId);

            protokollMessage.setResponseTime(LocalDateTime.now());
            protokollMessage.setResponseMessage(text);
            return text;
        }

    }
}
