package com.epam.command.impl;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class SortCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException, ParseException{		
		NotebookEditor editor = new NotebookEditor();
		editor.sortNote();
		Response response = new Response("sortNote", null);		
		return response;
	}
}
