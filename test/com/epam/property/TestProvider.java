package com.epam.property;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestProvider {
	
	private static final Locale locale = Locale.ENGLISH;
	
	private static String path = System.getProperty("user.dir");
	private static File file = new File(path);
	private static URL[] urls = new URL[1];
	
	private static ClassLoader loader;	
	private static ResourceBundle resources;
	
	private static String NotebookFileImplNoFile = null;
	private static String NotebookFileImplNoFileTemp = null;
	private static String FileTestPathKeeper = null;
	private static String FileTest1PathKeeper = null;
	private static String FileTest2PathKeeper = null;
	
	static {
		try {
			urls[0] = file.toURI().toURL();
		} catch (MalformedURLException e) {
			System.out.println("Can not find resourse file");
			e.printStackTrace();
		}
		loader = new URLClassLoader(urls);
		resources = ResourceBundle.getBundle("TestResource", locale, loader);
	}
	
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
