package com.epam.command.impl;

import java.util.ArrayList;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class FindDateCommand implements Command {
	@Override
	public Response execute(Request request) throws CommandException {
		Date date = null;
		NotebookEditor editor = new NotebookEditor();
		ArrayList<Note> notes = null;

		Object[] params = request.getParam("findDate");

		try {
			if (params.length != 0) {
				date = (Date) params[0];
			}
			notes = editor.findNoteByDate(date);
		} catch (LogicException e) {
			throw new CommandException("Find by date function error", e);
		} catch (NullPointerException e) {
			throw new CommandException("Input parameters for find by date function error", e);
		}
		
		Response response = new Response("findDate", notes);
		return response;
	}
}