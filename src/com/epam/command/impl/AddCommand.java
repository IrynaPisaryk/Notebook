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

public class AddCommand implements Command {
	@Override
	public Response execute(Request request) throws CommandException {

		Date date = null;
		String note = null;
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();

		Object[] obj = request.getParam("addNote");
		try {
			
			if (obj.length != 0) {
				date = (Date) obj[0];
				note = (String) obj[1];
			}		
			editor.addNote(date, note);
			
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "Add function error", e);
			throw new CommandException("Add function error");
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "Input parameters for add function error", e);
			throw new CommandException("Input parameters for add function error");
		}		
		
		Response response = new Response("addNote", null);
		logger.info("Create new simple note with fields: " + date.toString() + " and " + note);	
		return response;
	}

}
