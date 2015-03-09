package com.epam.exception;

public class DAOException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DAOException(String message){
		super(message);
		super.printStackTrace();
	}
}
