package com.epam.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.epam.dao.DAOFactory;
import com.epam.dao.NotebookDAO;
import com.epam.notebook.Note;

public final class NotebookEditor {

	 NotebookDAO dao = DAOFactory.getDAO();
	
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
	public void deleteNote(int index) throws IOException{
        dao.deleteNote(index);
	}
	
	public void deleteAllNotes() throws IOException{
        dao.deleteAllNotes();
	}
	
	public Note findNoteByIndex(int index){
        return dao.findNoteByIndex(index);
	}
	public ArrayList<Integer> findNoteByTitle(String title){
		return dao.findNoteByTitle(title);
	}
	public ArrayList<Integer> findNoteBySignature(String signature){
		return dao.findNoteBySignature(signature);
	}
	public ArrayList<Integer> findNoteByEMail(String email){
		return dao.findNoteByEMail(email);
	}
	public ArrayList<Integer> findNoteByDate(Date date){
		return dao.findNoteByDate(date);
	}
	public ArrayList<Integer> findNoteByNote(String note){
		return dao.findNoteByNote(note);
	}
	public void changeNote(int index, String newNote) throws IOException{
        dao.changeNote(index, newNote);
	}
	public void sortNote() throws IOException{
		dao.sortNote();
	}
	public void printNote(int index){
        dao.printNote(index);
	}
	public void replaceNote(int indexOldNote, Note newNote) throws IOException{
        dao.replaceNote(indexOldNote, newNote);
	}
	public Note cloneNote(int index) throws CloneNotSupportedException{
		return dao.cloneNote(index);
	}
	public void formatNote(int index) throws IOException{
        dao.formatNote(index);
	}

}
