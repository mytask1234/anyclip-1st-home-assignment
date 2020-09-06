package com.anyclip.exception;

public class PayloadException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4223095394191338480L;

	public PayloadException() {

	}

	public PayloadException(String message) {
		super(message);
	}

	public PayloadException(Throwable cause) {
		super(cause);
	}

	public PayloadException(String message, Throwable cause) {
		super(message, cause);
	}

	public PayloadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
