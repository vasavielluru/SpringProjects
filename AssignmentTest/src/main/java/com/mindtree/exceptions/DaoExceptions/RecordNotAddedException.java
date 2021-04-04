package com.mindtree.exceptions.DaoExceptions;

import com.mindtree.exceptions.ServiceExcptions.TransportServiceException;

public class RecordNotAddedException extends TransportServiceException {

	public RecordNotAddedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RecordNotAddedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RecordNotAddedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RecordNotAddedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
