package com.epam.logic;

public class LogicException extends Exception {

	private static final long serialVersionUID = 1L;

	public LogicException(Exception e) {
		e.printStackTrace();
	}
}
