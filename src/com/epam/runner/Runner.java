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
import com.epam.view.View;



public class Runner {

	public static void main(String[] args) throws IOException, CloneNotSupportedException{
		View vw = new View();
		vw.run();
	}
}