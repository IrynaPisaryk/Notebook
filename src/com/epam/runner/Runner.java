package com.epam.runner;
import java.io.IOException;
import java.util.Date;

import com.epam.command.CommandName;
import com.epam.command.Manager;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;



public class Runner {

	public static void main(String[] args) throws IOException, CloneNotSupportedException{
		Manager man  = new Manager();
		Date date = new Date();
		Note note = new Note(date, "a");
		NoteWithSignature note1 = new NoteWithSignature(date, "a", "k");
		NoteWithTitle note2 = new NoteWithTitle(date, "a", "k");
		Request request = new Request(note2);
		CommandName name = CommandName.getType("add");
		Response response = man.doRequest(name, request);
		System.out.println(response.getNotebook().getNote().toString());
	}
}