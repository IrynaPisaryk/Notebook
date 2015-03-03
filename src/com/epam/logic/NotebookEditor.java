package com.epam.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.dao.DAOFactory;
import com.epam.dao.NotebookDAO;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public final class NotebookEditor {

	 NotebookDAO dao = DAOFactory.getDAO();
	
	public Notebook addNote(Date date, String note) throws IOException{       
        return dao.addNote(date, note);
}
	
	public Notebook addNoteWithEMail(Date date, String note, String email) throws IOException{
        return dao.addNoteWithEMail(date, note, email);
}
	
	public Notebook addNoteWithSignature(Date date, String note, String signature) throws IOException{
        return dao.addNoteWithSignature(date, note, signature);
}
	
	public Notebook addNoteWithTitle(Date date, String note, String title) throws IOException{
        return dao.addNoteWithTitle(date, note, title);
	}
	public Notebook deleteNote(int index) throws IOException{
        return dao.deleteNote(index);
	}
	
	public Notebook deleteAllNotes() throws IOException{
        return dao.deleteAllNotes();
	}
	
	public Note findNoteByIndex(int index){
        return dao.findNoteByIndex(index);
	}
	public ArrayList<Note> findNoteByTitle(String title){
		return dao.findNoteByTitle(title);
	}
	public ArrayList<Note> findNoteBySignature(String signature){
		return dao.findNoteBySignature(signature);
	}
	public ArrayList<Note> findNoteByEMail(String email){
		return dao.findNoteByEMail(email);
	}
	public ArrayList<Note> findNoteByDate(Date date){
		return dao.findNoteByDate(date);
	}
	public ArrayList<Note> findNoteByNote(String note){
		return dao.findNoteByNote(note);
	}
	public Notebook changeNote(int index, String newNote) throws IOException{
        return dao.changeNote(index, newNote);
	}
	public Notebook sortNote() throws IOException{
		return dao.sortNote();
	}
	public Notebook replaceNote(int indexOldNote, Note newNote) throws IOException{
        return dao.replaceNote(indexOldNote, newNote);
	}
	public Note cloneNote(int index) throws CloneNotSupportedException{
		return dao.cloneNote(index);
	}
	public Notebook formatNote(int index) throws IOException{
        return dao.formatNote(index);
	}

}
