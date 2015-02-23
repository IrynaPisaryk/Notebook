package com.epam.dao;

public final class DAOFactory {

	private static NotebookMemoryImpl notebookMemory = new NotebookMemoryImpl();
	private static NotebookFileImpl notebookFile = new NotebookFileImpl();
	private static int type = 2;// "memory";

	public static NotebookDAO getDAO() {
		switch (type) {
		case 1:
			return notebookMemory;
		case 2:
			return notebookFile;
		default:
			return null;
		}
	}
}
