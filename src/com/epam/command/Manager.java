package com.epam.command;

import java.io.IOException;

public class Manager {

	private CommandHelper helper = new CommandHelper();
    
    public Response doRequest(CommandName nc, Request request) throws IOException, CloneNotSupportedException{
                    Command command = helper.getCommand(nc);
                    Response response = command.execute(request);
                    return response;
    }
	
}
