package com.epam.dao;

public abstract class DAOFactory {

	private static DAOEnum type = DAOEnum.getType("memory");
	public abstract NotebookDAO getNotebookDAO();	
	
	public static NotebookDAO getDAO() {
		switch (type) {
		case USING_MEMORY:
			return new NotebookMemoryDAOFactory().getNotebookDAO();
		case USING_FILE:
			return new NotebookFileDAOFactory().getNotebookDAO();
		default:
			return null;
		}
	}
}
