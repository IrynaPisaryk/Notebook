package com.epam.dao.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.epam.dao.INotebookDAO;
import com.epam.logic.NotebookIO;
import com.epam.logic.comparator.NoteComparator;
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
	public void deleteNote(int index) throws IOException, ParseException {
		NotebookIO io = new NotebookIO();
		Note note = io.readNoteFromFile(index);
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
	public ArrayList<Note> findNoteByTitle(String title) throws IOException, ParseException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		for(int i = 0; i < io.returnSize(); i++){
			Note note = io.readNoteFromFile(i);
			if(note instanceof NoteWithTitle){
				NoteWithTitle noteTitle = (NoteWithTitle)note;
				if(noteTitle.getTitle().equals(title)){
					foundNotes.add(noteTitle);
				}
			}
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteBySignature(String signature) throws IOException, ParseException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		for(int i = 0; i < io.returnSize(); i++){
			Note note = io.readNoteFromFile(i);
			if(note instanceof NoteWithSignature){
				NoteWithSignature noteSign = (NoteWithSignature)note;
				if(noteSign.getSignature().equals(signature)){
					foundNotes.add(noteSign);
				}
			}
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteByEMail(String email) throws IOException, ParseException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		for(int i = 0; i < io.returnSize(); i++){
			Note note = io.readNoteFromFile(i);
			if(note instanceof NoteWithEMail){
				NoteWithEMail noteEMail = (NoteWithEMail)note;
				if(noteEMail.getEMail().equals(email)){
					foundNotes.add(noteEMail);
				}
			}
		}
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteByDate(Date date) throws IOException, ParseException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		for(int i = 0; i < io.returnSize(); i++){
			Note note = io.readNoteFromFile(i);
				if(note.getDate().equals(date)){
					foundNotes.add(note);
				}
			}
		
		return foundNotes;
	}

	@Override
	public ArrayList<Note> findNoteByNote(String note) throws IOException, ParseException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		for(int i = 0; i < io.returnSize(); i++){
			Note noteNew = io.readNoteFromFile(i);
				if(noteNew.getNote().equals(note)){
					foundNotes.add(noteNew);
				}
			}
		
		return foundNotes;
	}

	@Override
	public void changeNote(int index, String newNote) throws IOException, ParseException {
		NotebookIO io = new NotebookIO();
		Note note = io.readNoteFromFile(index);
		note.setNote(newNote);	
		io.writeNoteIntoFile(index, note);			
	}

	@Override
	public void sortNote() throws IOException, ParseException {
		NotebookIO io = new NotebookIO();
		ArrayList<Note> notes = io.readNotebookFromFile();
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notes, comparator);
		io.setFile();
		io.writeNotebookIntoFile(notes);
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote)
			throws IOException {
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(indexOldNote, newNote);
	}

	@Override
	public Note cloneNote(int index) throws CloneNotSupportedException, IOException, ParseException {
		NotebookIO io = new NotebookIO();
		Note note = io.readNoteFromFile(index);		
		return note.clone();
	}

	@Override
	public void formatNote(int index) throws IOException, ParseException {
		NotebookIO io = new NotebookIO();
		Note note = io.readNoteFromFile(index);	
		if(!(note instanceof Note)){
			note = (Note)note;
		}
		io.writeNoteIntoFile(index, note);
	}		

}
