package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.CommandException;
import com.epam.exception.LogicException;
import com.epam.logic.NotebookEditor;

public class SortCommand implements Command {

	@Override
	public Response execute(Request request) throws CommandException{		
		NotebookEditor editor = new NotebookEditor();
		try{
			editor.sortNote();
		}catch(LogicException e){
			throw new CommandException("Sort command function error");
		}
		Response response = new Response("sortNote", null);		
		return response;
	}
}
