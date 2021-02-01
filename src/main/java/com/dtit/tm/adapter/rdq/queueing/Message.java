package com.dtit.tm.adapter.rdq.queueing;


import java.time.LocalDateTime;

/**
 * The Class Message.
 */
public class Message {

    /** The request time. */
    private LocalDateTime requestTime;

    /** The request message. */
    private String requestMessage;

    /** The response time. */
    private LocalDateTime responseTime;

    /** The response message. */
    private String responseMessage;

    /** The request url. */
    private String requestUrl;

    /** The response status. */
    private String responseStatus;

	/** msgId der Nachricht (momentan nur bei Queue Kommunikation befuellt). */
	private String msgId;

    /**
     * Prozess TraceId. <br>
     */
    private String traceId;

    /**
     * Prozess SpanId. <br>
     */
    private String spanId;

	/**
	 * Instantiates a new message : no-arg.
	 */
	public Message() {
		super();
	}

	/**
	 * Instantiates a new message.
     *
     * @param requestTime the request time
     * @param requestMessage the request message
     * @param responseTime the response time
	 * @param responseMessage the response message
     * @param requestUrl the request url
     * @param responseStatus the response status
     * @param msgId the msg id
     * @param traceId the trace id
     * @param spanId the span id
	 */
	public Message(LocalDateTime requestTime, String requestMessage, LocalDateTime responseTime, String responseMessage,
                   String requestUrl, String responseStatus, String msgId, String traceId, String spanId) {
		super();
		this.requestTime = requestTime;
		this.requestMessage = requestMessage;
		this.responseTime = responseTime;
		this.responseMessage = responseMessage;
		this.requestUrl = requestUrl;
		this.responseStatus = responseStatus;
		this.msgId = msgId;
        this.traceId = traceId;
        this.spanId = spanId;
	}

	/**
	 * Gets the request time.
	 *
	 * @return the request time
	 */
	public LocalDateTime getRequestTime() {
        return requestTime;
    }

    /**
     * Sets the request time.
     *
     * @param requestTime the new request time
     */
    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * Gets the request message.
     *
     * @return the request message
     */
    public String getRequestMessage() {
        return requestMessage;
    }

    /**
     * Sets the request message.
     *
     * @param requestMessage the new request message
     */
    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    /**
     * Gets the response time.
     *
     * @return the response time
     */
    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the response time.
     *
     * @param responseTime the new response time
     */
    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Gets the response message.
     *
     * @return the response message
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets the response message.
     *
     * @param responseMessage the new response message
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     * Gets the request url.
     *
     * @return the request url
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * Sets the request url.
     *
     * @param requestUrl the new request url
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    /**
     * Gets the response status.
     *
     * @return the response status
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the response status.
     *
     * @param responseStatus the new response status
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
	}

	/**
	 * Gets the msg id.
	 *
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * Sets the msg id.
	 *
	 * @param msgId the msgId to set
	 */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * Gets the trace id.
     *
     * @return the traceId
     */
    public String getTraceId() {
        return traceId;
    }

    /**
     * Sets the trace id.
     *
     * @param traceId the traceId to set
     */
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    /**
     * Gets the span id.
     *
     * @return the spanId
     */
    public String getSpanId() {
        return spanId;
    }

    /**
     * Sets the span id.
     *
     * @param spanId the spanId to set
     */
    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
    public String toString() {
        return "Message [requestTime=" + requestTime + ", requestMessage=" + requestMessage + ", responseTime="
                + responseTime + ", responseMessage=" + responseMessage + ", requestUrl=" + requestUrl
                + ", responseStatus=" + responseStatus + ", msgId=" + msgId + ", traceId=" + traceId + ", spanId="
				+ spanId + "]";
	}

}
