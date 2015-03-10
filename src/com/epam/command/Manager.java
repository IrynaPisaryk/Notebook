package com.epam.command;

import java.util.logging.Logger;

import com.epam.exception.CommandException;
import com.epam.exception.ManagerException;
import com.epam.logger.LoggerApp;

public class Manager {

	private CommandHelper helper = new CommandHelper();
    
    public Response doRequest(CommandName nc, Request request) throws ManagerException{
                    Command command = helper.getCommand(nc);
                    Response response = null;
                    try{
                    	response = command.execute(request);
                    }catch(CommandException e){                    	
            			throw new ManagerException("Manager error");
            		}                    
                    return response;
    }
	
}
        