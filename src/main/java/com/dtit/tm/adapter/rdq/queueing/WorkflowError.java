package com.dtit.tm.adapter.rdq.queueing;

public class WorkflowError {

    private WorkflowError() {
        throw new IllegalStateException("Utility class");
      }

	public static final String JMS_SET_PROPERTY_FAILED = null;
	protected static final String JMS_RECEIVE_ERROR = null;

}
