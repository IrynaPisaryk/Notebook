package com.epam.view;

import java.util.ArrayList;

import com.epam.command.Response;
import com.epam.notebook.Note;

public class Printer {

	public void printResponse(String key, Response response) {

		/*if(response.getParam(key) == null){
			Notebook notebook = NotebookAdapter.getInstance().getNotebook();
			for(Note i: notebook.getNotebook()){
				System.out.println(i.toString());
			}
			System.out.println("\n");
		}else*/ if(response.getParam(key) instanceof Note){
			Note note = (Note)response.getParam(key);
			System.out.println(note.toString());
			System.out.println("\n");
		}else if(response.getParam(key) instanceof ArrayList){
			ArrayList<Note> notes = (ArrayList<Note>)response.getParam(key);
			for(int i =0; i<notes.size(); i++){
				System.out.println(notes.get(i).toString());
			}
			System.out.println("\n");
		}
	}
}
