package com.epam.command.impl;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FormatCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("formatNote");
		editor.formatNote((int)obj[0]);
		Response response = new Response("formatNote", null);		
		return response;
	}
}
