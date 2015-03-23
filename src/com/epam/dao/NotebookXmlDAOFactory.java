package com.epam.dao;

import com.epam.dao.impl.NotebookXmlImpl;

public class NotebookXmlDAOFactory extends DAOFactory {

	private NotebookXmlImpl instance = new NotebookXmlImpl();

	public INotebookDAO getNotebookDAO() {
		return instance;
	}

}
