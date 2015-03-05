package com.epam.logic;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.dao.DAOFactory;
import com.epam.dao.INotebookDAO;
import com.epam.notebook.Note;

public final class NotebookEditor {

	 INotebookDAO dao = DAOFactory.getDAO();
	
	public void addNote(Date date, String note) throws IOException{       
        dao.addNote(date, note);
}
	
	public void addNoteWithEMail(Date date, String note, String email) throws IOException{
       dao.addNoteWithEMail(date, note, email);
}
	
	public void addNoteWithSignature(Date date, String note, String signature) throws IOException{
        dao.addNoteWithSignature(date, note, signature);
}
	
	public void addNoteWithTitle(Date date, String note, String title) throws IOException{
        dao.addNoteWithTitle(date, note, title);
	}
	public void deleteNote(int index) throws IOException, ParseException{
        dao.deleteNote(index);
	}
	
	public void deleteAllNotes() throws IOException{
        dao.deleteAllNotes();
	}
	
	public Note findNoteByIndex(int index) throws ParseException, IOException{
        return dao.findNoteByIndex(index);
	}
	public ArrayList<Note> findNoteByTitle(String title) throws IOException, ParseException{
		return dao.findNoteByTitle(title);
	}
	public ArrayList<Note> findNoteBySignature(String signature) throws IOException, ParseException{
		return dao.findNoteBySignature(signature);
	}
	public ArrayList<Note> findNoteByEMail(String email) throws IOException, ParseException{
		return dao.findNoteByEMail(email);
	}
	public ArrayList<Note> findNoteByDate(Date date) throws IOException, ParseException{
		return dao.findNoteByDate(date);
	}
	public ArrayList<Note> findNoteByNote(String note) throws IOException, ParseException{
		return dao.findNoteByNote(note);
	}
	public void changeNote(int index, String newNote) throws IOException, ParseException{
        dao.changeNote(index, newNote);
	}
	public void sortNote() throws IOException, ParseException{
		dao.sortNote();
	}
	public void replaceNote(int indexOldNote, Note newNote) throws IOException{
        dao.replaceNote(indexOldNote, newNote);
	}
	public Note cloneNote(int index) throws CloneNotSupportedException, IOException, ParseException{
		return dao.cloneNote(index);
	}
	public void formatNote(int index) throws IOException, ParseException{
        dao.formatNote(index);
	}

}
