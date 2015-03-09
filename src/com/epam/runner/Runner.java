package com.epam.runner;

import java.util.logging.Level;

import com.epam.exception.ViewException;
import com.epam.logger.LoggerApp;
import com.epam.view.View;

public class Runner {

	public static void main(String[] args) {
		View vw = new View();		
		try{
			vw.run();		
		}catch(ViewException e){
			LoggerApp logger = new LoggerApp();
			logger.getHandler();
			logger.getLogger().log(Level.SEVERE, "Exception", e);
			System.out.println("Programm error");
		}
	}
}