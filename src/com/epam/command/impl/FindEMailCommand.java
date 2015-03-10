package com.epam.command.impl;

import java.util.ArrayList;
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

public class FindEMailCommand implements Command {
	
	@Override
	public Response execute(Request request) throws CommandException{
		String email = null;
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] params = request.getParam("findEMail");
		if(params.length != 0){
			email = (String) params[0];
		}	
		ArrayList<Note> notes = null;
		try{
			notes = editor.findNoteByEMail(email);
		}catch(LogicException e){			
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("Find by email command function error");
		}
		Response response = new Response("findEMail", notes);
		logger.info("find by email  " + email);
		return response;
	}
}
