package com.epam.command;

import java.io.IOException;
import java.text.ParseException;

public interface Command {

	public Response execute(Request request) throws IOException, CloneNotSupportedException, ParseException;
	
}
