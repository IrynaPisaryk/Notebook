package com.epam.command.impl;

import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.CommandException;
import com.epam.exception.LogicException;
import com.epam.logic.NotebookEditor;

public class AddTitleCommand implements Command {
	
	@Override
	public Response execute(Request request) throws CommandException{
	
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
		try{
			editor.addNoteWithTitle(date, note, title);
		}catch(LogicException e){
			throw new CommandException("AddTitle command function error");
		}
		Response response = new Response("addTitle", null);
		return response;
	}
}

