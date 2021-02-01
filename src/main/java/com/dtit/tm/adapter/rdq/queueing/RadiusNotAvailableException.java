package com.dtit.tm.adapter.rdq.queueing;

/**
 * The Class RadiusNotAvailableException.
 */
public class RadiusNotAvailableException extends RuntimeException {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Instantiates a new radius not available exception.
     */
    public RadiusNotAvailableException() {
        super();
    }

    /**
     * Instantiates a new radius not available exception.
     *
     * @param message the message
     */
    public RadiusNotAvailableException(String message) {
        super(message);
    }

    /**
     * Instantiates a new radius not available exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public RadiusNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new radius not available exception.
     *
     * @param cause the cause
     */
    public RadiusNotAvailableException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new radius not available exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected RadiusNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
