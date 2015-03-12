package com.epam.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.epam.dao.DAOFactory;
import com.epam.dao.INotebookDAO;
import com.epam.exception.DAOException;
import com.epam.exception.LogicException;
import com.epam.logger.LoggerApp;
import com.epam.notebook.Note;

public final class NotebookEditor {

	 INotebookDAO dao = DAOFactory.getDAO();
	 Logger logger = LoggerApp.getInstance().getLogger();
	
	public void addNote(Date date, String note) throws LogicException{       
        try{
        	dao.addNote(date, note);
        }catch(DAOException e){        	
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
}
	
	public void addNoteWithEMail(Date date, String note, String email) throws LogicException{
       try{
    	   dao.addNoteWithEMail(date, note, email);
       }catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
       	throw new LogicException();
       }
}
	
	public void addNoteWithSignature(Date date, String note, String signature) throws LogicException{
        try{
        	dao.addNoteWithSignature(date, note, signature);
        }catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
}
	
	public void addNoteWithTitle(Date date, String note, String title) throws LogicException{
        try{
        	dao.addNoteWithTitle(date, note, title);
        }catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
	}
	public void deleteNote(int index) throws LogicException{
        try{
        	dao.deleteNote(index);
        }catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
	}
	
	public void deleteAllNotes() throws LogicException{
        try{
        	dao.deleteAllNotes();
        }catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
	}
	
	public Note findNoteByIndex(int index) throws LogicException{
        try {
			return dao.findNoteByIndex(index);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	
	public ArrayList<Note> findNoteByTitle(String title) throws LogicException{
		try{
			return dao.findNoteByTitle(title);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	
	public ArrayList<Note> findNoteBySignature(String signature) throws LogicException{
		try{
			return dao.findNoteBySignature(signature);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	
	public ArrayList<Note> findNoteByEMail(String email) throws LogicException{
		try{
			return dao.findNoteByEMail(email);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	
	public ArrayList<Note> findNoteByDate(Date date) throws LogicException{
		try{
			return dao.findNoteByDate(date);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	public ArrayList<Note> findNoteByNote(String note) throws LogicException{
		try{
			return dao.findNoteByNote(note);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	public void changeNote(int index, String newNote) throws LogicException{
        try{
        	dao.changeNote(index, newNote);
        }catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	
	public void sortNote() throws LogicException{
		try{
			dao.sortNote();
		}catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
	}
	public void replaceNote(int indexOldNote, Note newNote) throws LogicException{
        try{
        	dao.replaceNote(indexOldNote, newNote);
        }catch(DAOException e){
			logger.log(Level.SEVERE, "Exception", e);
        	throw new LogicException();
        }
	}
	
	public Note cloneNote(int index) throws LogicException{
		try{
			return dao.cloneNote(index);
		}catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
	
	public void formatNote(int index) throws LogicException{
        try{
        	dao.formatNote(index);
        }catch (DAOException e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new LogicException();
		}
	}
}
