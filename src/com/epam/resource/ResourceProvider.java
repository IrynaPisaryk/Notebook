package com.epam.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProvider {

	private static final Locale locale = Locale.ENGLISH;
	private static ResourceBundle resources = ResourceBundle.getBundle(
			"com.epam.resource.ProgramResource", locale);
	private static String dataKeeper = null;
	private static String loggerKeeper = null;
	private static String filePathKeeper = null;
	private static String fileTempPathKeeper = null;
	private static String fileTestPathKeeper = null;
	private static String fileTempTestPathKeeper = null;
	private static String fileNoTempTestPathKeeper = null;
	private static String fileFTempTestPathKeeper = null;

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

	public static String getFileTempTestPathKeeper() {
		fileTempTestPathKeeper = resources.getString("FileTempTestPathKeeper");
		return fileTempTestPathKeeper;
	}

	public static String getFileNoTempTestPathKeeper() {
		fileNoTempTestPathKeeper = resources
				.getString("FileNoTempTestPathKeeper");
		return fileNoTempTestPathKeeper;
	}

	public static String getFileFTempTestPathKeeper() {
		fileFTempTestPathKeeper = resources
				.getString("FileFTempTestPathKeeper");
		return fileFTempTestPathKeeper;
	}
}
