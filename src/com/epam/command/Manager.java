package com.epam.command;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Manager {

	private CommandHelper helper = new CommandHelper();
	public final static Logger log = Logger.getLogger(com.epam.command.Manager.class);

	public Response doRequest(CommandName nc, Request request) {
		
		String nameFile = "log4j.properties";
		PropertyConfigurator.configure(nameFile);
		
		Command command = helper.getCommand(nc);
		Response response = null;
		try {
			response = command.execute(request);
			log.info(request.getKey() + " command execute");
		} catch (CommandException e) {
			System.out.println("Program error occured");
			log.error(e.getStackTrace(), e);
		}
		return response;
	}
}
