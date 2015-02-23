package com.epam.notebook;

import java.io.Serializable;
import java.util.ArrayList;

public class Notebook implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Note> notebook = new ArrayList<Note>();
	
	public Note getNote(int index) {
		return notebook.get(index);
	}
	//????
	public Note getNote() {
		return notebook.get(0);
	}

	public void setNote(int index, Note note) {
		notebook.add(index, note);
	}
	
	public void setNote(Note note) {
		notebook.add(note);
	}

	public void deleteNote(int index) {
		notebook.remove(index);
	}

	public ArrayList<Note> getNotebook() {
		return notebook;
	}

	public void setNotebook(ArrayList<Note> notebook) {
		this.notebook.clear();
		this.notebook.addAll(notebook);
	}

	public int deleteNotebook() {
		notebook.clear();
		return notebook.size();
	}
	

}
