package com.epam.dao;

import com.epam.dao.impl.NotebookFileImpl;

public class NotebookFileDAOFactory extends DAOFactory{	

		private NotebookFileImpl instance = new NotebookFileImpl();
		
		public INotebookDAO getNotebookDAO(){
			return instance;
			
		}	
}
