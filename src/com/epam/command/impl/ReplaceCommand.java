package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class ReplaceCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("replaceNote");
		try {
			editor.replaceNote((int) obj[0], (Note) obj[1]);
		} catch (LogicException e) {
			throw new CommandException("Replace function error", e);
		} catch (NullPointerException e) {
			throw new CommandException("Input parameters for replace function error", e);
		}
		Response response = new Response("replaceNote", null);
		return response;
	}
}
