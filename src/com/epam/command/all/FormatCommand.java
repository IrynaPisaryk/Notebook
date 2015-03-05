package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FormatCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException, ParseException{
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("formatNote");
		editor.formatNote((int)obj[0]);
		Response response = new Response("formatNote", null);		
		return response;
	}
}
