package com.epam.dao.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.dao.INotebookDAO;
import com.epam.logic.NotebookIO;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public final class NotebookFileImpl implements INotebookDAO{


	/*{
	try {
		io.writeNotebookIntoFile(notebook);
	} catch (IOException e) {
		e.printStackTrace();
	}
}*/

	
	@Override
	public void addNote(Date date, String text) throws IOException {
		NotebookIO io = new NotebookIO();
		Note note = new Note(date, text);
		io.writeNoteIntoFile(note);
		
	}

	@Override
	public void addNoteWithEMail(Date date, String text, String email)
			throws IOException {
		NotebookIO io = new NotebookIO();
		NoteWithEMail note = new NoteWithEMail(date, text, email);
		io.writeNoteIntoFile(note);
	}

	@Override
	public void addNoteWithSignature(Date date, String text,
			String signature) throws IOException {
		NoteWithSignature note = new NoteWithSignature(date, text, signature);
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(note);
	}

	@Override
	public void addNoteWithTitle(Date date, String text, String title)
			throws IOException {
		NoteWithTitle note = new NoteWithTitle(date, text, title);
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(note);
	}

	@Override
	public void deleteNote(int index) throws IOException {
		NotebookIO io = new NotebookIO();
		String note = io.readNoteFromFile(index);
		io.writeNoteIntoFile(note);
	}

	@Override
	public void deleteAllNotes() throws IOException {
		NotebookIO io = new NotebookIO();
		io.setFile();
	}

	@Override
	public Note findNoteByIndex(int index) throws ParseException, IOException {
		NotebookIO io = new NotebookIO();
		io.returnNoteByIndex(index);
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteBySignature(String signature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByEMail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByNote(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeNote(int index, String newNote) throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void sortNote() throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote)
			throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public Note cloneNote(int index) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void formatNote(int index) throws IOException {
		// TODO Auto-generated method stub
	}		

}
