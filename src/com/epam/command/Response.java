package com.epam.command;

import java.util.ArrayList;

import com.epam.logic.NotebookAdapter;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public class Response {

	private Notebook notebook;
	private ArrayList<Note> notes;
	
	public Response(){
		notebook = NotebookAdapter.getInstance().getNotebook();
	}
	
	public Response(ArrayList<Note> notes){
		this.notes = notes;
	}
	
	public void setNotebook(Notebook notebook){
		this.notebook = notebook;
	}
	
	public Notebook getNotebook(){
		return notebook;
	}
	
	public void setNotes(ArrayList<Note> notes){
		this.notes = notes;
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
}
