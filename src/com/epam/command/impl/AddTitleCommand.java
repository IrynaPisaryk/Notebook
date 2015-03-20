package com.epam.command.impl;

import java.util.Date;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;

public class AddTitleCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Date date = null;
		String note = null;
		String title = null;

		NotebookEditor editor = new NotebookEditor();

		Object[] obj = request.getParam("addTitle");

		try {
			if (obj.length != 0) {
				date = (Date) obj[0];
				note = (String) obj[1];
				title = (String) obj[2];
			}
			editor.addNoteWithTitle(date, note, title);
		} catch (LogicException e) {
			throw new CommandException("AddTitle function error", e);
		} catch (NullPointerException e) {
			throw new CommandException("Input parameters for AddTitle function error", e);
		}
		
		Response response = new Response("addTitle", null);
		return response;
	}
}
