package com.dtit.tm.adapter.rdq.queueing;

public class WorkflowException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private WorkflowException() {
        throw new IllegalStateException("Utility class");
      }
	public static Exception create(String jmsReceiveError, Object object, Object object2, String auftragId,
			Throwable e) {
		return new Exception(jmsReceiveError);
	}

}
