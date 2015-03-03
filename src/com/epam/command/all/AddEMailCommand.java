package com.epam.command.all;

import java.io.IOException;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class AddEMailCommand implements Command {

	private Date date;
	private String note;
	private String email;
	
	@Override
	public Response execute(Request request) throws IOException{
	
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addEMail");
		
		if(obj.length !=0){
			this.date = (Date)obj[0];
			this.note = (String)obj[1];
			this.email = (String)obj[2];
		}		
		Response response = new Response("addEMail", editor.addNoteWithEMail(date, note, email));
		return response;
	}
}


