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

public class FindSignCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		String signature = null;
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] params = request.getParam("findSign");
		if (params.length != 0) {
			signature = (String) params[0];
		}
		ArrayList<Note> notes = null;
		try {
			notes = editor.findNoteBySignature(signature);
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException(
					"Find by signature command function error");
		}
		Response response = new Response("findSign", notes);
		logger.info("Find note by signature  " + signature);
		return response;
	}
}