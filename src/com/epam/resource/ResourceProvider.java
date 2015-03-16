package com.epam.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProvider {

	private static final Locale locale = Locale.ENGLISH;
	private static ResourceBundle resources = ResourceBundle.getBundle("com.epam.resource.ProgramResource", locale);
	private static String dataKeeper = null;
	private static String loggerKeeper = null;
	private static String filePathKeeper = null;
	private static String fileTempPathKeeper = null;
	private static String fileTestPathKeeper = null;
	private static String fileTest1PathKeeper = null;
	private static String fileTest2PathKeeper = null;

	public static String getDataKeeper() {
		dataKeeper = resources.getString("DataKeeper");
		return dataKeeper;
	}

	public static String getLoggerKeeper() {
		loggerKeeper = resources.getString("LoggerKeeper");
		return loggerKeeper;
	}

	public static String getFilePathKeeper() {
		filePathKeeper = resources.getString("FilePathKeeper");
		return filePathKeeper;
	}

	public static String getFileTempPathKeeper() {
		fileTempPathKeeper = resources.getString("FilePathTempKeeper");
		return fileTempPathKeeper;
	}

	public static String getFileTestPathKeeper() {
		fileTestPathKeeper = resources.getString("FileTestPathKeeper");
		return fileTestPathKeeper;
	}
	
	public static String getFileTest1PathKeeper() {
		fileTest1PathKeeper = resources.getString("FileTest1PathKeeper");
		return fileTest1PathKeeper;
	}
	
	public static String getFileTest2PathKeeper() {
		fileTest2PathKeeper = resources.getString("FileTest2PathKeeper");
		return fileTest2PathKeeper;
	}
}
