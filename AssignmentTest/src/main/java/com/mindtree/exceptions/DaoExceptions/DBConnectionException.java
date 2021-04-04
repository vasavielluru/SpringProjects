package com.mindtree.exceptions.DaoExceptions;

import com.mindtree.exceptions.ServiceExcptions.TransportServiceException;

public class DBConnectionException extends TransportServiceException {

	public DBConnectionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBConnectionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DBConnectionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DBConnectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DBConnectionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
