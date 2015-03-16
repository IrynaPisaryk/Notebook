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

public class ReplaceCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		Logger logger = LoggerApp.getInstance().getLogger();
		Object[] obj = request.getParam("replaceNote");
		try {
			editor.replaceNote((int) obj[0], (Note) obj[1]);
		} catch (LogicException e) {
			logger.log(Level.SEVERE, "Replace function error", e);
			throw new CommandException("Replace function error");
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, "Input parameters for replace function error", e);
			throw new CommandException("Input parameters for replace function error");
		}
		Response response = new Response("replaceNote", null);
		logger.info("Replace note with id=" + (int) obj[0]);
		return response;
	}
}
