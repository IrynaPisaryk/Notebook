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

public class FindCommand implements Command {	
	
	@Override
	public Response execute(Request request) throws CommandException{

		int index = -1;
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] params = request.getParam("find");
		if(params.length != 0){
			index = (int) params[0];
		}
		Note note = null;
		try{
			note = editor.findNoteByIndex(index);
		}catch(LogicException e){
			
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("Find command function error");
		}
		Response response = new Response("find", note);
		logger.info("find by index  " + index);
		return response;
	}
}
