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

public class ChangeCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException{		
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] obj = request.getParam("changeNote");
		try{
			editor.changeNote((int)obj[0], (String)obj[1]);
		}catch(LogicException e){			
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("Change command function error");
		}
		Response response = new Response("changeNote", null);	
		logger.info("changeNote " + (int)obj[0]);
		return response;
	}
}
