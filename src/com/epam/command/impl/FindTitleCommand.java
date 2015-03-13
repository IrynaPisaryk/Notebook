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

public class FindTitleCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		String title = null;
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] params = request.getParam("findTitle");
		if (params.length != 0) {
			title = (String) params[0];
		}
		ArrayList<Note> notes = null;
		try {
			notes = editor.findNoteByTitle(title);
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("Find by title command function error");
		}
		Response response = new Response("findTitle", notes);
		logger.info("Find note by title  " + title);
		return response;
	}
}
