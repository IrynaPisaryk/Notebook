package com.epam.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.exception.DAOException;
import com.epam.notebook.Note;

public interface INotebookDAO {
	
	//void-boolean
	void addNote(Date date, String note) throws DAOException;

	void addNoteWithEMail(Date date, String note, String email) throws DAOException;

	void addNoteWithSignature(Date date, String note, String signature) throws DAOException;

	void addNoteWithTitle(Date date, String note, String title) throws DAOException;

	void deleteNote(int index) throws DAOException;
	
	void deleteAllNotes() throws DAOException;

	Note findNoteByIndex(int index) throws DAOException;

	ArrayList<Note> findNoteByTitle(String title) throws DAOException;

	ArrayList<Note> findNoteBySignature(String signature) throws DAOException;

	ArrayList<Note> findNoteByEMail(String email) throws DAOException;

	ArrayList<Note> findNoteByDate(Date date) throws DAOException;

	ArrayList<Note> findNoteByNote(String note) throws DAOException;

	void changeNote(int index, String newNote) throws DAOException;

	void sortNote() throws DAOException;

	void replaceNote(int indexOldNote, Note newNote) throws DAOException;

	Note cloneNote(int index) throws DAOException;

	void formatNote(int index) throws DAOException;

	
}
