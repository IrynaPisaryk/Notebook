package com.epam.command.all;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class FindDateCommand implements Command {

	private Date date;
	
	@Override
	public Response execute(Request request) throws IOException, ParseException{

		NotebookEditor editor = new NotebookEditor();
		Object[] params = request.getParam("findDate");
		if(params.length != 0){
			date = (Date) params[0];
		}		
		editor.findNoteByDate(date);
		Response response = new Response("findDate", null);
		return response;
	}
}