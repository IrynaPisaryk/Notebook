package com.epam.resource;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProvider {

	private static final Locale locale = Locale.ENGLISH;
	
	private static File file = new File(System.getProperty("user.dir"));
	private static URL[] urls = {file.toURI().toURL()};
	private static ClassLoader loader = new URLClassLoader(urls);
	private static ResourceBundle resources = ResourceBundle.getBundle("ProgramResource", locale, loader);
	private static String dataKeeper = null;
	private static String loggerKeeper = null;
	private static String filePathKeeper = null;
	private static String fileTempPathKeeper = null;
	
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
}
