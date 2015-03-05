package com.epam.dao;

public abstract class DAOFactory {

	private static DAOEnum type = DAOEnum.getType("file");
	public abstract INotebookDAO getNotebookDAO();	
	
	public static INotebookDAO getDAO() {
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
