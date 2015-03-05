package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindTitleCommand implements Command {

	private String title;
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findTitle");
		if(params.length != 0){
			title = (String) params[0];
		}		
		editor.findNoteByTitle(title);
		Response response = new Response("findTitle", null);
		return response;
	}
}
