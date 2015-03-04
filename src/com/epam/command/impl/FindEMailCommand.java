package com.epam.command.impl;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindEMailCommand implements Command {
	
	@Override
	public Response execute(Request request) throws IOException{
		String email = null;
		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findEMail");
		if(params.length != 0){
			email = (String) params[0];
		}		
		Response response = new Response("findEMail", editor.findNoteByEMail(email));
		return response;
	}
}
