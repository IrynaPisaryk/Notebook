package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindNoteCommand implements Command {

	private String note;
	
	@Override
	public Response execute(Request request) throws IOException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findNote");
		if(params.length != 0){
			note = (String) params[0];
		}		
		Response response = new Response("findNote", editor.findNoteByNote(note));
		return response;
	}
}