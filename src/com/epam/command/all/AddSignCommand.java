package com.epam.command.all;

import java.io.IOException;
import java.util.Date;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class AddSignCommand implements Command {

	private Date date;
	private String note;
	private String sign;
	
	@Override
	public Response execute(Request request) throws IOException{
	
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addSign");
		
		if(obj.length !=0){
			this.date = (Date)obj[0];
			this.note = (String)obj[1];
			this.sign = (String)obj[2];
		}		
		Response response = new Response("addSign", editor.addNoteWithSignature(date, note, sign));
		return response;
	}
}

