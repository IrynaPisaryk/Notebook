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
		
		
		Request request = new Request(note);
		Request request1 = new Request(note1);
		Request request2 = new Request(note2);
		CommandName name = CommandName.getType("add");
		Response response = man.doRequest(name, request);
		Response response1 = man.doRequest(name, request1);
		Response response2 = man.doRequest(name, request2);		
		//System.out.println(response.getNotebook().getNote().toString());
		//System.out.println(response1.getNotebook().getNote().toString());
		//System.out.println(response2.getNotebook().getNote().toString());
		
		Request request3 = new Request(0);
		CommandName name1 = CommandName.getType("find");
		Response response3 = man.doRequest(name1, request3);
		System.out.println(response3.getNote());
		//System.out.println(response3.getNotes().get(1));
		
		
		
	}
}