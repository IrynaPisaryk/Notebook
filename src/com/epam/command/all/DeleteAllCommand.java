package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class DeleteAllCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{		
		NotebookEditor editor = new NotebookEditor();
		Response response = new Response("deteleAllNotes", editor.deleteAllNotes());		
		return response;
	}
}
