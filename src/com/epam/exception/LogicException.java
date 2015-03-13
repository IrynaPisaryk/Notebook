package com.epam.exception;

public class LogicException extends Exception {

	private static final long serialVersionUID = 1L;

	public LogicException(String message) {
		super(message);
		super.printStackTrace();
	}

	public LogicException() {
		super.printStackTrace();
	}

}
