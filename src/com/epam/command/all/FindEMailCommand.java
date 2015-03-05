package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindEMailCommand implements Command {

	private String email;
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findEMail");
		if(params.length != 0){
			email = (String) params[0];
		}		
		editor.findNoteByEMail(email);
		Response response = new Response("findEMail", null);
		return response;
	}
}
