package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindTitleCommand implements Command {

	private String title;
	
	@Override
	public Response execute(Request request) throws IOException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findTitle");
		if(params.length != 0){
			title = (String) params[0];
		}		
		Response response = new Response("findTitle", editor.findNoteByTitle(title));
		return response;
	}
}
