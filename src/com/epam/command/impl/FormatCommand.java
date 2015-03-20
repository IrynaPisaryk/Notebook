package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;

public class FormatCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("formatNote");
		try {
			editor.formatNote((int) obj[0]);
		} catch (LogicException e) {
			throw new CommandException("Format command function error", e);
		}
		Response response = new Response("formatNote", null);
		return response;
	}
}
