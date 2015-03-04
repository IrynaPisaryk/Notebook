package com.epam.command.impl;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindCommand implements Command {	
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		int index = -1;
		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("find");
		if(params.length != 0){
			index = (int) params[0];
		}
		Response response = new Response("find", editor.findNoteByIndex(index));
		return response;
	}
}
