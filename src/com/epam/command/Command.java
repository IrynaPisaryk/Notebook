package com.epam.command;

import java.io.IOException;

public interface Command {

	public Response execute(Request request) throws IOException, CloneNotSupportedException;
	
}
