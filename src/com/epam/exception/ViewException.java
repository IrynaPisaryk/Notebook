package com.epam.exception;

public class ViewException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ViewException(String message){
		super(message);
		super.printStackTrace();
	}
	
	public ViewException(){
		super.printStackTrace();
	}
}