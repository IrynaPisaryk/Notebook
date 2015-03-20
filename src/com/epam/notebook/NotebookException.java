package com.epam.notebook;

public class NotebookException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotebookException(String message, IndexOutOfBoundsException e) {
		super(message);
	}

}
