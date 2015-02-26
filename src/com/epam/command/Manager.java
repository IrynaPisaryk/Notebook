package com.epam.command;

import java.io.IOException;
import java.util.Date;

import com.epam.notebook.Note;

public class Manager {

	private CommandHelper helper = new CommandHelper();
    
    public Response doRequest(CommandName nc, Request request) throws IOException, CloneNotSupportedException{
                    Command command = helper.getCommand(nc);
                    
                    if(request.getField() != null && request.getIndex() == 0){
                    	Date date = new Date();
                    	Note defaultNote = new Note(date, "default");
                    	Request defaultRequest = new Request(defaultNote, request.getField());
                    	Response response = command.execute(defaultRequest);
                    	return response;
                    }
                    Response response = command.execute(request);
                    return response;
    }
	
}
