package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Notebook;

public class AddCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{
		
		NotebookEditor editor = new NotebookEditor();
		editor.addNote(request.getNote().getDate(), request.getNote().getNote());
		Response response = new Response();
		return response;
	}

	
		
}
