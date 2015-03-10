package com.epam.exception;

public class NoteException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoteException(String message){
		super(message);
		super.printStackTrace();
	}
	
}

