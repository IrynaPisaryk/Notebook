package com.epam.command.impl;

import java.util.ArrayList;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class FindEMailCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		String email = null;
		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findEMail");
		if (params.length != 0) {
			email = (String) params[0];
		}
		ArrayList<Note> notes = null;
		try {
			notes = editor.findNoteByEMail(email);
		} catch (LogicException e) {
			throw new CommandException("Find by email command function error", e);
		}
		Response response = new Response("findEMail", notes);
		return response;
	}
}
