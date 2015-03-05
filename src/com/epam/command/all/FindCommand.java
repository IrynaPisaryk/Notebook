package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindCommand implements Command {

	private int index;
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("find");
		if(params.length != 0){
			index = (int) params[0];
		}
		editor.findNoteByIndex(index);
		Response response = new Response("find", null);
		return response;
	}
}
