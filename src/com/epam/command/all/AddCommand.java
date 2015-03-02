package com.epam.command.all;

import java.io.IOException;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public class AddCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{
	
		NotebookEditor editor = new NotebookEditor();
		
		Object[] obj = request.getParam("addNote");
		if(obj.length !=0){
			if(obj[0].getClass() == Note.class){
				Note note = (Note)obj[0];
				editor.addNote(note.getDate(), note.getNote());
			}
			else if(obj[0].getClass() == NoteWithEMail.class){
				NoteWithEMail note = (NoteWithEMail)obj[0];
				editor.addNoteWithEMail(note.getDate(), note.getNote(), note.getEMail());
			}
			else if(obj[0].getClass() == NoteWithSignature.class){
				NoteWithSignature note = (NoteWithSignature)obj[0];
				editor.addNoteWithSignature(note.getDate(), note.getNote(), note.getSignature());
			}
			else if(obj[0].getClass() == NoteWithTitle.class){
				NoteWithTitle note = (NoteWithTitle)obj[0];
				editor.addNoteWithTitle(note.getDate(), note.getNote(), note.getTitle());
			}			
		}
		Response response = new Response();
		return response;
	}



}
