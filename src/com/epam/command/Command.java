package com.epam.command;


public interface Command {

	public Response execute(Request request) throws CommandException;

}
