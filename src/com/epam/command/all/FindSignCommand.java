package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindSignCommand implements Command {

	private String signature;
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findSign");
		if(params.length != 0){
			signature = (String) params[0];
		}		
		editor.findNoteBySignature(signature);
		Response response = new Response("findSign", null);
		return response;
	}
}