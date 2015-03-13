package com.epam.dao;

import com.epam.dao.impl.NotebookMemoryImpl;

public class NotebookMemoryDAOFactory extends DAOFactory {

	private NotebookMemoryImpl instance = new NotebookMemoryImpl();

	public INotebookDAO getNotebookDAO() {
		return instance;

	}

}
