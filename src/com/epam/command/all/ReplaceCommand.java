package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;

public class ReplaceCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{		
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("replaceNote");
		editor.replaceNote((int) obj[0], (Note) obj[1]);
		Response response = new Response("replaceNote", null);		
		return response;
	}
}
