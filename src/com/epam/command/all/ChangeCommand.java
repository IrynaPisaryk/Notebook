package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class ChangeCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException, ParseException{		
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("changeNote");
		editor.changeNote((int)obj[0], (String)obj[1]);
		Response response = new Response("changeNote", null);		
		return response;
	}
}
