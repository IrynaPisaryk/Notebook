package com.epam.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.epam.notebook.Note;
import com.epam.dao.INotebookDAO;
import com.epam.exception.DAOException;
import com.epam.exception.NotebookException;
import com.epam.logger.LoggerApp;
import com.epam.logic.NotebookAdapter;
import com.epam.logic.comparator.NoteComparator;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.notebook.Notebook;

public final class NotebookMemoryImpl implements INotebookDAO {

	private Notebook notebook = NotebookAdapter.getInstance().getNotebook();
	private Logger logger = LoggerApp.getInstance().getLogger();

	@Override
	public void addNote(Date date, String note) {
		Note newNote = new Note(date, note);
		notebook.setNote(newNote);
	}

	@Override
	public void addNoteWithEMail(Date date, String note, String email) {
		NoteWithEMail newMailNote = new NoteWithEMail(date, note, email);
		notebook.setNote(newMailNote);
	}

	@Override
	public void addNoteWithSignature(Date date, String note, String signature) {
		NoteWithSignature newSignatureNote = new NoteWithSignature(date, note, signature);
		notebook.setNote(newSignatureNote);
	}

	@Override
	public void addNoteWithTitle(Date date, String note, String title) {
		NoteWithTitle newTitleNote = new NoteWithTitle(date, note, title);
		notebook.setNote(newTitleNote);

	}

	@Override
	public void changeNote(int index, String newNote) throws DAOException{
		try{
			if (!notebook.getNote(index).getNote().equals(newNote)) {
				notebook.getNote(index).setNote(newNote);
			}
		}
		catch(NotebookException e){			
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("ChangeNote fucnction error");
		}
	}

	@Override
	public Note cloneNote(int index) throws DAOException {
		try{
			return notebook.getNote(index).clone();
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("CloneNote fucnction error");
		}		
	}

	@Override
	public void deleteNote(int index) throws DAOException{
		try{
			notebook.deleteNote(index);
		}catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("DeleteNote fucnction error");
		}
	}
	
	@Override
	public void deleteAllNotes() throws DAOException{
		try{
			notebook.deleteNotebook();
		}catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("DeleteNote fucnction error");
		}
	}

	@Override
	public Note findNoteByIndex(int index) throws DAOException{
		try{
			return notebook.getNote(index);
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FindNoteByIndex fucnction error");
		}
	}

	@Override
	public ArrayList<Note> findNoteByTitle(String title) throws DAOException{
		try{
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithTitle) {
				NoteWithTitle noteWithTitle = (NoteWithTitle) notebook
						.getNote(i);
				if (noteWithTitle.getTitle().equals(title)) {
					arrayOfFoundNote.add(noteWithTitle);
				}
			}
		}
		return arrayOfFoundNote;
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FindNoteByTitle fucnction error");
		}
	}

	@Override
	public ArrayList<Note> findNoteBySignature(String signature) throws DAOException{
		try{
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithSignature) {
				NoteWithSignature noteWithSignature = (NoteWithSignature) notebook
						.getNote(i);
				if (noteWithSignature.getSignature().equals(signature)) {
					arrayOfFoundNote.add(noteWithSignature);
				}
			}
		}
		return arrayOfFoundNote;
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FindNoteBySignature fucnction error");
		}
	}

	@Override
	public ArrayList<Note> findNoteByEMail(String email) throws DAOException{
		try{
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithEMail) {
				NoteWithEMail noteWithEMail = (NoteWithEMail) notebook
						.getNote(i);
				if (noteWithEMail.getEMail().equals(email)) {
					arrayOfFoundNote.add(noteWithEMail);
				}
			}
		}
		return arrayOfFoundNote;
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FindNoteByEMail fucnction error");
		}
	}

	@Override
	public ArrayList<Note> findNoteByDate(Date date) throws DAOException{
		try{
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getDate().equals(date)) {
				arrayOfFoundNote.add(notebook.getNote(i));
			}
		}
		return arrayOfFoundNote;
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FindNoteByDate fucnction error");
		}
	}

	@Override
	public ArrayList<Note> findNoteByNote(String note) throws DAOException{
		try{
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getNote().equals(note)) {
				arrayOfFoundNote.add(notebook.getNote(i));
			}
		}
		return arrayOfFoundNote;
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FindNoteByNote fucnction error");
		}
	}

	@Override
	public void formatNote(int index) throws DAOException{
		try{
			Note newNote = notebook.getNote(index);		
		if (newNote instanceof NoteWithEMail
				|| newNote instanceof NoteWithSignature
				|| newNote instanceof NoteWithTitle) {
			newNote = new Note(notebook.getNote(index).getDate(), notebook
					.getNote(index).getNote());
		}
		notebook.deleteNote(index);
		notebook.setNote(index, newNote);
		}
		catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("FormatNote fucnction error");
		}
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote) throws DAOException{
		try{
		notebook.deleteNote(indexOldNote);
		notebook.setNote(indexOldNote, newNote);
		}catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("DeleteNote fucnction error");
		}

	}

	@Override
	public void sortNote() throws DAOException{
		try{
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notebook.getNotebook(), comparator);
		}catch(NotebookException e){
			logger.log(Level.SEVERE, "Exception", e);
			throw new DAOException("DeleteNote fucnction error");
		}
	}
}
