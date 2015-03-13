package com.epam.command;

import com.epam.exception.CommandException;

public interface Command {

	public Response execute(Request request) throws CommandException;

}
