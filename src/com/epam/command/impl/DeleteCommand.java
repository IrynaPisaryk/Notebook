package com.epam.command.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.CommandException;
import com.epam.exception.LogicException;
import com.epam.logger.LoggerApp;
import com.epam.logic.NotebookEditor;

public class DeleteCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException{		
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] obj = request.getParam("deleteNote");
		try{
			editor.deleteNote((int)obj[0]);
		}catch(LogicException e){
			
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("Delete command function error");
		}
		Response response = new Response("deleteNote", null);
		logger.info("deleteNote  "+ (int)obj[0]);
		return response;
	}
	
}
