package com.epam.command.impl;

import java.util.Date;

import com.epam.command.Command;
import com.epam.command.CommandException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookEditor;

public class AddSignCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		Date date = null;
		String note = null;
		String sign = null;

		NotebookEditor editor = new NotebookEditor();

		Object[] obj = request.getParam("addSign");

		try {
			if (obj.length != 0) {
				date = (Date) obj[0];
				note = (String) obj[1];
				sign = (String) obj[2];
			}
			editor.addNoteWithSignature(date, note, sign);
		} catch (LogicException e) {
			throw new CommandException("AddSign function error", e);
		} catch (NullPointerException e) {
			throw new CommandException("Input parameters for AddSign function error", e);
		}
		Response response = new Response("addSign", null);
		return response;
	}
}
