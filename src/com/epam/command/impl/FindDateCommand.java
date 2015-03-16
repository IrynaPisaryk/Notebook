package com.epam.command.impl;

import java.util.ArrayList;
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
import com.epam.notebook.Note;

public class FindDateCommand implements Command {
	@Override
	public Response execute(Request request) throws CommandException {
		Date date = null;
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		ArrayList<Note> notes = null;

		Object[] params = request.getParam("findDate");

		try {
			if (params.length != 0) {
				date = (Date) params[0];
			}
			notes = editor.findNoteByDate(date);
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "Find by date function error", e);
			throw new CommandException("Find by date function error");
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "Input parameters for find by date function error", e);
			throw new CommandException("Input parameters for find by date function error");
		}
		
		Response response = new Response("findDate", notes);
		logger.info("Find note by date  " + date);
		return response;
	}
}