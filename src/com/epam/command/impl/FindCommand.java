package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class FindCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		int index = -1;
		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("find");
		if (params.length != 0) {
			index = (int) params[0];
		}
		Note note = null;
		try {
			note = editor.findNoteByIndex(index);
		} catch (LogicException e) {
			throw new CommandException("Find command function error", e);
		}
		Response response = new Response("find", note);
		return response;
	}
}
