package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;

public class DeleteCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("deleteNote");
		try {
			editor.deleteNote((int) obj[0]);
		} catch (LogicException e) {
			throw new CommandException("Delete command function error", e);
		}
		Response response = new Response("deleteNote", null);
		return response;
	}

}
