package com.epam.dao;

import com.epam.resource.ResourceProvider;

public abstract class DAOFactory {

	private static DAOEnum type = DAOEnum.getType(ResourceProvider.getDataKeeper());

	public abstract INotebookDAO getNotebookDAO();

	public static INotebookDAO getDAO() {
		if (type != null) {
			switch (type) {
			case USING_MEMORY:
				return new NotebookMemoryDAOFactory().getNotebookDAO();
			case USING_FILE:
				return new NotebookFileDAOFactory().getNotebookDAO();
			default:
				return null;
			}
		} else {
			System.out.println("Unknown type");
			return null;
		}
	}
}
