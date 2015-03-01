package com.epam.command.all;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
		Object[] obj = request.getParam("findNote");
		
		if(obj[0].getClass() == int.class){		
			if((int)obj[0] != -1){
			Note note = editor.findNoteByIndex((int)obj[0]);
			Response response = new Response(note);	
			return response;
			}
		}
		else if(obj[0].getClass() == Date.class){			
			ArrayList<Integer>index = editor.findNoteByDate((Date)obj[0]);	
			for(Integer i: index){
				notes.add(notebook.getNote(i));
			}	
			Response response = new Response(notes);	
			return response;
		}
		else{
			String textForSearch = (String) obj[0];
			ArrayList<Integer>indexByNote = editor.findNoteByNote(textForSearch);
			ArrayList<Integer>indexByMail = editor.findNoteByEMail(textForSearch);
			ArrayList<Integer>indexByTitle = editor.findNoteByTitle(textForSearch);
			ArrayList<Integer>indexBySign = editor.findNoteBySignature(textForSearch);
			
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
		return null;		
	}
}
