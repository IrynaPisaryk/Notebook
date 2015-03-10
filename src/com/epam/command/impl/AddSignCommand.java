package com.epam.command.impl;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.CommandException;
import com.epam.exception.LogicException;
import com.epam.logger.LoggerApp;
import com.epam.logic.NotebookEditor;

public class AddSignCommand implements Command {
	
	@Override
	public Response execute(Request request) throws CommandException{
	
		Date date = null;
		String note = null;
		String sign = null;
		Logger logger = LoggerApp.getInstance().getLogger();
		
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addSign");
		
		if(obj.length !=0){
			date = (Date)obj[0];
			note = (String)obj[1];
			sign = (String)obj[2];
		}	
		try{
			editor.addNoteWithSignature(date, note, sign);
		}catch(LogicException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new CommandException("AddSign command function error");
		}
		Response response = new Response("addSign", null);
		logger.info("addSign " + note.toString());
		return response;
	}
}

