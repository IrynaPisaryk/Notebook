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

public class AddTitleCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Date date = null;
		String note = null;
		String title = null;
		Logger logger = LoggerApp.getInstance().getLogger();

		NotebookEditor editor = new NotebookEditor();

		Object[] obj = request.getParam("addTitle");

		try {
			if (obj.length != 0) {
				date = (Date) obj[0];
				note = (String) obj[1];
				title = (String) obj[2];
			}
			editor.addNoteWithTitle(date, note, title);
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "AddTitle function error", e);
			throw new CommandException("AddTitle function error");
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "Input parameters for AddTitle function error", e);
			throw new CommandException("Input parameters for AddTitle function error");
		}
		
		Response response = new Response("addTitle", null);
		logger.info("Create new note with title with fields: " + date.toString() + " and " + note + "and" + title);
		return response;
	}
}
