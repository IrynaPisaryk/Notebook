package com.epam.command.all;

import java.io.IOException;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class AddCommand implements Command {

	private Date date;
	private String note;
	
	@Override
	public Response execute(Request request) throws IOException{
	
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addNote");
		
		if(obj.length !=0){
			this.date = (Date)obj[0];
			this.note = (String)obj[1];
		}		
		editor.addNote(date, note);
		Response response = new Response("addNote", null);
		return response;
	}



}
