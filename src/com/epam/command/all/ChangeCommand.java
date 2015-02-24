package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class ChangeCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{
		Response response = new Response();
		NotebookEditor editor = new NotebookEditor();
		editor.changeNote(request.getIndex(), request.getField());;
		return response;
	}
}
