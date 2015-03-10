package com.epam.command.impl;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.CommandException;
import com.epam.exception.LogicException;
import com.epam.logger.LoggerApp;
import com.epam.logic.NotebookEditor;

public class AddEMailCommand implements Command {	
	@Override
	public Response execute(Request request) throws CommandException{
	
		Date date = null;
		String note = null;
		String email = null;
		Logger logger = LoggerApp.getInstance().getLogger();		
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addEMail");
		
		if(obj.length !=0){
			date = (Date)obj[0];
			note = (String)obj[1];
			email = (String)obj[2];
		}	
		try{
			editor.addNoteWithEMail(date, note, email);
		}catch(LogicException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("AddEMail command function error");
		}
		Response response = new Response("addEMail", null);
		logger.info("addEMail " + note.toString());
		return response;
	}
}


