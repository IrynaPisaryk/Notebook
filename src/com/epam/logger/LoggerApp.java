package com.epam.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggerApp {
	
	private static final LoggerApp instance = new LoggerApp();
	private Logger logger = Logger.getLogger(LoggerApp.class.getName());
	private FileHandler fh = null;

	{
		try {
			fh = new FileHandler("C:\\Users\\Irina_Pisarik\\Desktop\\LogApp");
			logger.addHandler(fh);			
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "Can't get log because secure error occured", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Can't get log because i/o error occured",	e);
		}
	}
	
	public static LoggerApp getInstance() {
		return instance;
	}

	public Logger getLogger() {
		return logger;
	}
	
	
		/*logger.log(Level.INFO, "info log");
		logger.log(Level.WARNING,"warning log");
		logger.log(Level.SEVERE, "severe log");*/
	
}
