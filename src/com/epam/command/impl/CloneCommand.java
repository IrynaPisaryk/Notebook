package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class CloneCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("cloneNote");
		Note note = null;
		try {
			note = editor.cloneNote((int) obj[0]);
		} catch (LogicException e) {
			throw new CommandException("Clone command function error", e);
		}
		Response response = new Response("cloneNote", note);
		return response;
	}
}
