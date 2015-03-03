package com.epam.command.all;

import java.io.IOException;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class AddTitleCommand implements Command {

	private Date date;
	private String note;
	private String title;
	
	@Override
	public Response execute(Request request) throws IOException{
	
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addTitle");
		
		if(obj.length !=0){
			this.date = (Date)obj[0];
			this.note = (String)obj[1];
			this.title = (String)obj[2];
		}		
		Response response = new Response("addTitle", editor.addNoteWithTitle(date, note, title));
		return response;
	}
}

