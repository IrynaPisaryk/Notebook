package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindSignCommand implements Command {

	private String signature;
	
	@Override
	public Response execute(Request request) throws IOException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findSign");
		if(params.length != 0){
			signature = (String) params[0];
		}		
		Response response = new Response("findSign", editor.findNoteBySignature(signature));
		return response;
	}
}