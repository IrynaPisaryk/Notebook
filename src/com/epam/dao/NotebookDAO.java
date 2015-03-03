package com.epam.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public interface NotebookDAO {
	Notebook addNote(Date date, String note) throws IOException;

	Notebook addNoteWithEMail(Date date, String note, String email) throws IOException;

	Notebook addNoteWithSignature(Date date, String note, String signature) throws IOException;

	Notebook addNoteWithTitle(Date date, String note, String title) throws IOException;

	Notebook deleteNote(int index) throws IOException;
	
	Notebook deleteAllNotes() throws IOException;

	Note findNoteByIndex(int index);

	ArrayList<Note> findNoteByTitle(String title);

	ArrayList<Note> findNoteBySignature(String signature);

	ArrayList<Note> findNoteByEMail(String email);

	ArrayList<Note> findNoteByDate(Date date);

	ArrayList<Note> findNoteByNote(String note);

	Notebook changeNote(int index, String newNote) throws IOException;

	Notebook sortNote() throws IOException;

	Notebook replaceNote(int indexOldNote, Note newNote) throws IOException;

	Note cloneNote(int index) throws CloneNotSupportedException;

	Notebook formatNote(int index) throws IOException;

	
}
