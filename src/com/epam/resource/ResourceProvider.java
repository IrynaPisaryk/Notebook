package com.epam.resource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceProvider {

	private static final Locale locale = Locale.ENGLISH;
	
	private static String path = System.getProperty("user.dir");
	private static File file = new File(path);
	private static URL[] urls = new URL[1];
	
	private static ClassLoader loader;
	private static ResourceBundle resources;
	
	private static String dataKeeper = null;
	private static String loggerKeeper = null;
	private static String filePathKeeper = null;
	private static String fileTempPathKeeper = null;
	
	static {
		try {
			urls[0] = file.toURI().toURL();
		} catch (MalformedURLException e) {
			System.out.println("Can not path to resourse file");
			e.printStackTrace();
		}
		loader = new URLClassLoader(urls);
		try{
			resources = ResourceBundle.getBundle("ProgramResource", locale, loader);
		} catch(MissingResourceException e){
			System.out.println("Missing resource file");
			e.printStackTrace();
		}
	}
	
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
