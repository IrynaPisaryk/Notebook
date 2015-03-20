package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;

public class DeleteAllCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		NotebookEditor editor = new NotebookEditor();
		try {
			editor.deleteAllNotes();
		} catch (LogicException e) {
			throw new CommandException("Delete all command function error", e);
		}
		Response response = new Response("deteleAllNotes", null);
		return response;
	}
}
