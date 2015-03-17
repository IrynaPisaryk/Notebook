package com.epam.property;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestProvider {
	
	private static final Locale locale = Locale.ENGLISH;
	private static ResourceBundle resources = ResourceBundle.getBundle("TestResource", locale);
	private static String NotebookFileImplNoFile = null;
	private static String NotebookFileImplNoFileTemp = null;
	private static String FileTestPathKeeper = null;
	private static String FileTest1PathKeeper = null;
	private static String FileTest2PathKeeper = null;
	
	public static String getNotebookFileImplNoFile() {
		NotebookFileImplNoFile = resources.getString("NotebookFileImplNoFile");
		return NotebookFileImplNoFile;
	}
	
	public static String getNotebookFileImplNoFileTemp() {
		NotebookFileImplNoFileTemp = resources.getString("NotebookFileImplNoFileTemp");
		return NotebookFileImplNoFileTemp;
	}
	
	public static String getFileTestPathKeeper() {
		FileTestPathKeeper = resources.getString("FileTestPathKeeper");
		return FileTestPathKeeper;
	}
	
	public static String getFileTest1PathKeeper() {
		FileTest1PathKeeper = resources.getString("FileTest1PathKeeper");
		return FileTest1PathKeeper;
	}
	
	public static String getFileTest2PathKeeper() {
		FileTest2PathKeeper = resources.getString("FileTest2PathKeeper");
		return FileTest2PathKeeper;
	}
}
