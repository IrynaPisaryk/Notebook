package com.epam.dao;

import com.epam.dao.impl.NotebookFileImpl;
import com.epam.dao.impl.NotebookMemoryImpl;

public abstract class DAOFactory {

	private static DAOEnum type = DAOEnum.getType("memory");
	public abstract NotebookDAO getNotebookDAO();	
	
	public static NotebookDAO getDAO() {
		switch (type) {
		case USING_MEMORY:
			return NotebookMemoryDAOFactory.getDAO();
		case USING_FILE:
			//return notebookFile;
		default:
			return null;
		}
	}
}
