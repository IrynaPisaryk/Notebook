package com.epam.command.impl;

import java.util.ArrayList;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class FindSignCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		String signature = null;
		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findSign");
		if (params.length != 0) {
			signature = (String) params[0];
		}
		ArrayList<Note> notes = null;
		try {
			notes = editor.findNoteBySignature(signature);
		} catch (LogicException e) {
			throw new CommandException(
					"Find by signature command function error", e);
		}
		Response response = new Response("findSign", notes);
		return response;
	}
}