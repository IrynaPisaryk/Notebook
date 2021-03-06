package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class CloneCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException, CloneNotSupportedException, ParseException{
		NotebookEditor editor = new NotebookEditor();
		Object[] obj = request.getParam("cloneNote");
		editor.cloneNote((int)obj[0]);
		Response response = new Response("cloneNote", null);		
		return response;
	}
}
