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
	public Response execute(Request request) throws CommandException {

		Date date = null;
		String note = null;
		String email = null;
		Logger logger = LoggerApp.getInstance().getLogger();
		NotebookEditor editor = new NotebookEditor();

		Object[] obj = request.getParam("addEMail");

		try {
			if (obj.length != 0) {
				date = (Date) obj[0];
				note = (String) obj[1];
				email = (String) obj[2];
			}
			editor.addNoteWithEMail(date, note, email);
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "AddEMail function error", e);
			throw new CommandException("AddEMail function error");
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "Input parameters for AddEMail function error", e);
			throw new CommandException("Input parameters for AddEMail function error");
		}
		Response response = new Response("addEMail", null);		
		logger.info("Create new note with email with fields: " + date.toString() + " and " + note + "and" + email);
		return response;
	}
}
