package com.epam.command.impl;

import java.io.IOException;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class AddTitleCommand implements Command {
	
	@Override
	public Response execute(Request request) throws IOException{
	
		Date date = null;
		String note = null;
		String title = null;
		
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addTitle");
		
		if(obj.length !=0){
			date = (Date)obj[0];
			note = (String)obj[1];
			title = (String)obj[2];
		}	
		editor.addNoteWithTitle(date, note, title);
		Response response = new Response("addTitle", null);
		return response;
	}
}

