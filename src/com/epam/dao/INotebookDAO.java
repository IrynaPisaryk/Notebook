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

	void deleteNote(int index) throws IOException, ParseException;
	
	void deleteAllNotes() throws IOException;

	Note findNoteByIndex(int index) throws ParseException, IOException;

	ArrayList<Note> findNoteByTitle(String title) throws IOException, ParseException;

	ArrayList<Note> findNoteBySignature(String signature) throws IOException, ParseException;

	ArrayList<Note> findNoteByEMail(String email) throws IOException, ParseException;

	ArrayList<Note> findNoteByDate(Date date) throws IOException, ParseException;

	ArrayList<Note> findNoteByNote(String note) throws IOException, ParseException;

	void changeNote(int index, String newNote) throws IOException, ParseException;

	void sortNote() throws IOException, ParseException;

	void replaceNote(int indexOldNote, Note newNote) throws IOException;

	Note cloneNote(int index) throws CloneNotSupportedException, IOException, ParseException;

	void formatNote(int index) throws IOException, ParseException;

	
}
