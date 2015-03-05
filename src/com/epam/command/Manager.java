package com.epam.command;

import java.io.IOException;
import java.text.ParseException;

public class Manager {

	private CommandHelper helper = new CommandHelper();
    
    public Response doRequest(CommandName nc, Request request) throws IOException, CloneNotSupportedException, ParseException{
                    Command command = helper.getCommand(nc);
                    Response response = command.execute(request);
                    return response;
    }
	
}
        