package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;

public class ChangeCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("changeNote");
		try {
			editor.changeNote((int) obj[0], (String) obj[1]);
		} catch (LogicException e) {
			throw new CommandException("Change command function error", e);
		}
		Response response = new Response("changeNote", null);
		return response;
	}
}
