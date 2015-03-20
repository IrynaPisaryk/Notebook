package com.epam.notebook;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Notebook {

	private ArrayList<Note> notebook = new ArrayList<Note>();

	public Note getNote(int index) throws NotebookException{
		try{
			return notebook.get(index);
		}
		catch(IndexOutOfBoundsException e){
			throw new NotebookException("Notebook size is null", e);
		}
	}

	public Note getNote() throws NotebookException{
		try{
			return notebook.get(0);
		}catch(IndexOutOfBoundsException e){
			throw new NotebookException("Notebook size is null", e);
		}
	}

	public void setNote(int index, Note note) {
		notebook.add(index, note);
	}

	public void setNote(Note note) {
		notebook.add(note);
	}

	public void deleteNote(int index) throws NotebookException{
		try{
			notebook.remove(index);
		}catch(IndexOutOfBoundsException e){
			throw new NotebookException("Notebook size is null", e);
		}
	}

	public ArrayList<Note> getNotebook() throws NotebookException{
		try{
			return notebook;
		}catch(IndexOutOfBoundsException e){
			throw new NotebookException("Notebook size is null", e);
		}
	}

	public void setNotebook(ArrayList<Note> notebook) {
		this.notebook.clear();
		this.notebook.addAll(notebook);
	}

	public int deleteNotebook() throws NotebookException{
		try{
			notebook.clear();		
			return notebook.size();
		}catch(IndexOutOfBoundsException e){
			throw new NotebookException("Notebook size is null", e);
		}
	}
}
