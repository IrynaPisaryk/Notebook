package com.epam.dao;

import com.epam.dao.impl.NotebookFileImpl;
import com.epam.dao.impl.NotebookMemoryImpl;

public final class DAOFactory {

	private static NotebookMemoryImpl notebookMemory = new NotebookMemoryImpl();
	private static NotebookFileImpl notebookFile = new NotebookFileImpl();
	private static DAOEnum type = DAOEnum.getType("file");
	
	public static NotebookDAO getDAO() {
		switch (type) {
		case USING_MEMORY:
			return notebookMemory;
		case USING_FILE:
			return notebookFile;
		default:
			return null;
		}
	}
}
