package com.epam.command.all;

import java.io.IOException;
import java.util.ArrayList;

import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookAdapter;
import com.epam.logic.NotebookEditor;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public class FindCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{

		Notebook notebook = NotebookAdapter.getInstance().getNotebook();
		NotebookEditor editor = new NotebookEditor();
		ArrayList<Note> notes = new ArrayList<Note>();		
		
		if(request.getIndex() != -1){			
			Note note = editor.findNoteByIndex(request.getIndex());
			Response response = new Response(note);	
			return response;
		}
		else if(request.getDate() != null){			
			ArrayList<Integer>index = editor.findNoteByDate(request.getDate());	
			for(Integer i: index){
				notes.add(notebook.getNote(i));
			}	
			Response response = new Response(notes);	
			return response;
		}
		else{
			ArrayList<Integer>indexByNote = editor.findNoteByNote(request.getField());
			ArrayList<Integer>indexByMail = editor.findNoteByEMail(request.getField());
			ArrayList<Integer>indexByTitle = editor.findNoteByTitle(request.getField());
			ArrayList<Integer>indexBySign = editor.findNoteBySignature(request.getField());
			
			if(!indexByNote.isEmpty()){
				for(Integer i: indexByNote){
					notes.add(notebook.getNote(i));
				}
			}
			if(!indexByMail.isEmpty()){
				for(Integer i: indexByMail){
					notes.add(notebook.getNote(i));
				}

			}
			if(!indexByTitle.isEmpty()){
				for(Integer i: indexByTitle){
					notes.add(notebook.getNote(i));
				}

			}
			if(!indexBySign.isEmpty()){
				for(Integer i: indexBySign){
					notes.add(notebook.getNote(i));
				}
			}			
			Response response = new Response(notes);	
			return response;
		}		
	}
}
