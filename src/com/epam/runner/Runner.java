package com.epam.runner;
import java.io.IOException;
import java.util.Date;

import com.epam.command.CommandName;
import com.epam.command.Manager;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.notebook.Note;



public class Runner {

	public static void main(String[] args) throws IOException, CloneNotSupportedException{
		Manager man  = new Manager();
		Date date = new Date();
		Note note = new Note(date, "a");
		Request request = new Request(note);
		CommandName name = CommandName.getType("add");
		Response response = man.doRequest(name, request);
		System.out.println(response.getNotebook().getNote().toString());
	}
}