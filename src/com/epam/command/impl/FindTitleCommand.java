package com.epam.command.impl;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindTitleCommand implements Command {
	
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		String title = null;
		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findTitle");
		if(params.length != 0){
			title = (String) params[0];
		}		
		Response response = new Response("findTitle", editor.findNoteByTitle(title));
		return response;
	}
}
