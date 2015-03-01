package com.epam.command;

import java.util.ArrayList;

import com.epam.logic.NotebookAdapter;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public class Response {

	private Notebook notebook = null;
	private ArrayList<Note> notes = null;
	private Note note = null;
	
	public Response(){
		notebook = NotebookAdapter.getInstance().getNotebook();
	}
	
	public Response(ArrayList<Note> notes){
		this.notes = notes;
	}
	
	public Response(Note note) {
		this.note = note;
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
	
	public void setNote(Note note){
		this.note = note;
	}
	
	public Note getNote(){
		return note;
	}
}
