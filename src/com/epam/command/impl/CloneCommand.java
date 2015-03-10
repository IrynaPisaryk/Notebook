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
import com.epam.notebook.Note;

public class CloneCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException{
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] obj = request.getParam("cloneNote");
		Note note = null;
		try{
			note = editor.cloneNote((int)obj[0]);
		}catch(LogicException e){			
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("Clone command function error");
		}
		Response response = new Response("cloneNote", note);	
		logger.info("cloneNote  " + (int)obj[0]);
		return response;
	}
}
