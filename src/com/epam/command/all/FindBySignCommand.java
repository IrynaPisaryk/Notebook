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

public class FindBySignCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{		
		Notebook notebook = NotebookAdapter.getInstance().getNotebook();
		NotebookEditor editor = new NotebookEditor();
		ArrayList<Integer>index = editor.findNoteBySignature(request.getField());
		ArrayList<Note> notes = new ArrayList<Note>();
		for(Integer i: index){
			notes.add(notebook.getNote(i));
		}
		Response response = new Response(notes);
		return response;
		
	}
}
