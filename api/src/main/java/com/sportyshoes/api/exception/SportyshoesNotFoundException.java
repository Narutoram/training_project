package com.sportyshoes.api.exception;

public class SportyshoesNotFoundException extends RuntimeException {
	public SportyshoesNotFoundException() {
	}

	public SportyshoesNotFoundException(String message) {
		super(message);

	}

	public SportyshoesNotFoundException(Throwable cause) {
		super(cause);
	}

	public SportyshoesNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public SportyshoesNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
