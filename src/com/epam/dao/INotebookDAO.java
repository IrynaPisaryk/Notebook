package com.epam.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.notebook.Note;

public interface INotebookDAO {
	
	//void-boolean
	void addNote(Date date, String note) throws IOException;

	void addNoteWithEMail(Date date, String note, String email) throws IOException;

	void addNoteWithSignature(Date date, String note, String signature) throws IOException;

	void addNoteWithTitle(Date date, String note, String title) throws IOException;

	void deleteNote(int index) throws IOException;
	
	void deleteAllNotes() throws IOException;

	Note findNoteByIndex(int index) throws ParseException, IOException;

	ArrayList<Note> findNoteByTitle(String title);

	ArrayList<Note> findNoteBySignature(String signature);

	ArrayList<Note> findNoteByEMail(String email);

	ArrayList<Note> findNoteByDate(Date date);

	ArrayList<Note> findNoteByNote(String note);

	void changeNote(int index, String newNote) throws IOException;

	void sortNote() throws IOException;

	void replaceNote(int indexOldNote, Note newNote) throws IOException;

	Note cloneNote(int index) throws CloneNotSupportedException;

	void formatNote(int index) throws IOException;

	
}
