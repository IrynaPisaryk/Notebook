package com.epam.dao.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.epam.dao.INotebookDAO;
import com.epam.exception.DAOException;
import com.epam.logic.NotebookIO;
import com.epam.logic.comparator.NoteComparator;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public final class NotebookFileImpl implements INotebookDAO{

	//private File file = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test.txt");
	//private File file1 = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test1.txt");
	private File file = new File("D:\\test.txt");
	private File file1 = new File("D:\\test1.txt");


	@Override
	public void addNote(Date date, String text) throws DAOException{
		NotebookIO io = new NotebookIO();
		Note note = new Note(date, text);
		try{
			io.writeNoteIntoFile(file, note);
		}catch(IOException e){
			throw new DAOException("Can not write note into file");
		}

	}

	@Override
	public void addNoteWithEMail(Date date, String text, String email) throws DAOException {
		NotebookIO io = new NotebookIO();
		NoteWithEMail note = new NoteWithEMail(date, text, email);
		try{
			io.writeNoteIntoFile(file, note);
		}catch(IOException e){
			throw new DAOException("Can not write note with email into file");
		}
	}

	@Override
	public void addNoteWithSignature(Date date, String text,
			String signature) throws DAOException {
		NoteWithSignature note = new NoteWithSignature(date, text, signature);
		NotebookIO io = new NotebookIO();
		try{
			io.writeNoteIntoFile(file, note);
		}catch(IOException e){
			throw new DAOException("Can not write note with signature into file");
		}
	}

	@Override
	public void addNoteWithTitle(Date date, String text, String title)
			throws DAOException {
		NoteWithTitle note = new NoteWithTitle(date, text, title);
		NotebookIO io = new NotebookIO();
		try{
			io.writeNoteIntoFile(file, note);
		}catch(IOException e){
			throw new DAOException("Can not write note with title into file");
		}
	}

	@Override
	public void deleteNote(int index) throws DAOException{
		NotebookIO io = new NotebookIO();
		try{
			io.writeNoteIntoFile(file, file1, index);
		}catch(IOException e){
			throw new DAOException("Can not delete note from file");
		}
		
	}

	@Override
	public void deleteAllNotes() throws DAOException {
		NotebookIO io = new NotebookIO();
		try{
			io.setFile(file);
		}catch(IOException e){
			throw new DAOException("Can not delete note from file");
		}
	}

	@Override
	public Note findNoteByIndex(int index) throws DAOException{
		NotebookIO io = new NotebookIO();
		try{
			return io.readNoteFromFile(file, index);
		}catch(IOException e){
			throw new DAOException("Can not find note by index into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by index into file");
		}
	}

	@Override
	public ArrayList<Note> findNoteByTitle(String title) throws DAOException{		
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		try{
		for(int i = 0; i < io.returnSize(file); i++){
			Note note = io.readNoteFromFile(file, i);
			if(note instanceof NoteWithTitle){
				NoteWithTitle noteTitle = (NoteWithTitle)note;
				if(noteTitle.getTitle().equals(title)){
					foundNotes.add(noteTitle);
				}
			}
		}
		return foundNotes;
		}catch(IOException e){
			throw new DAOException("Can not find note by title into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by title into file");
		}
	}

	@Override
	public ArrayList<Note> findNoteBySignature(String signature) throws DAOException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		try{
		for(int i = 0; i < io.returnSize(file); i++){
			Note note = io.readNoteFromFile(file, i);
			if(note instanceof NoteWithSignature){
				NoteWithSignature noteSign = (NoteWithSignature)note;
				if(noteSign.getSignature().equals(signature)){
					foundNotes.add(noteSign);
				}
			}
		}
		return foundNotes;
		}catch(IOException e){
			throw new DAOException("Can not find note by signature into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by signature into file");
		}
	}

	@Override
	public ArrayList<Note> findNoteByEMail(String email) throws DAOException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		try{
		for(int i = 0; i < io.returnSize(file); i++){
			Note note = io.readNoteFromFile(file, i);
			if(note instanceof NoteWithEMail){
				NoteWithEMail noteEMail = (NoteWithEMail)note;
				if(noteEMail.getEMail().equals(email)){
					foundNotes.add(noteEMail);
				}
			}
		}
		return foundNotes;
		}catch(IOException e){
			throw new DAOException("Can not find note by email into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by email into file");
		}
	}

	@Override
	public ArrayList<Note> findNoteByDate(Date date) throws DAOException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		try{
		for(int i = 0; i < io.returnSize(file); i++){
			Note note = io.readNoteFromFile(file, i);	
			String month = null;
			String day = null;
			if(Integer.valueOf(note.getDate().getMonth())<10){
				month = "0"+ (note.getDate().getMonth()+1);				
			}else{
				month = ""+(note.getDate().getMonth()+1);
			}
			if(Integer.valueOf(note.getDate().getDate())<10){
				day = "0"+ (note.getDate().getDate());
			}else{
				day = ""+ (note.getDate().getDate());
			}
			String dateF = (note.getDate().getYear()+1900)+"/"+month+"/"+day;
			
			if(Integer.valueOf(date.getMonth())<10){
				month = "0"+ (date.getMonth()+1);				
			}else{
				month = ""+(date.getMonth()+1);
			}
			if(Integer.valueOf(date.getDate())<10){
				day = "0"+ (date.getDate());
			}else{
				day = ""+ (date.getDate());
			}			
			String foundDate = (date.getYear()+1900)+"/"+month+"/"+day;
			if(dateF.equals(foundDate)){				
				foundNotes.add(note);
			}
		}
		
		return foundNotes;
		}catch(IOException e){
			throw new DAOException("Can not find note by date into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by date into file");
		}
	}

	@Override
	public ArrayList<Note> findNoteByNote(String note) throws DAOException {
		ArrayList<Note> foundNotes = new ArrayList<Note>();
		NotebookIO io = new NotebookIO();
		try{
		for(int i = 0; i < io.returnSize(file); i++){
			Note noteNew = io.readNoteFromFile(file, i);
			if(noteNew.getNote().equals(note)){
				foundNotes.add(noteNew);
			}
		}

		return foundNotes;
		}catch(IOException e){
			throw new DAOException("Can not find note by note into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by note into file");
		}
	}

	@Override
	public void changeNote(int index, String newNote) throws DAOException {
		NotebookIO io = new NotebookIO();
		try{
		Note note = io.readNoteFromFile(file, index);
		note.setNote(newNote);	
		io.writeNoteIntoFile(file, file1, index, note);		
		}catch(IOException e){
			throw new DAOException("Can not change note into file");
		}catch(ParseException e){
			throw new DAOException("Can not change note into file");
		}
	}

	@Override
	public void sortNote() throws DAOException {
		NotebookIO io = new NotebookIO();
		try{
		ArrayList<Note> notes = io.readNotebookFromFile(file);
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notes, comparator);
		io.setFile(file);
		io.writeNotebookIntoFile(file, notes);
		}catch(IOException e){
			throw new DAOException("Can not sort note into file");
		}catch(ParseException e){
			throw new DAOException("Can not sort note into file");
		}
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote)
			throws DAOException {
		NotebookIO io = new NotebookIO();
		try{
			io.writeNoteIntoFile(file, file1, indexOldNote, newNote);
		}catch(IOException e){
			throw new DAOException("Can not replace note into file");
		}
	}

	@Override
	public Note cloneNote(int index) throws DAOException {
		NotebookIO io = new NotebookIO();
		try{
		Note note = io.readNoteFromFile(file, index);		
		return note.clone();
		}catch(IOException e){
			throw new DAOException("Can not clone note from file");
		}catch(CloneNotSupportedException e){
			throw new DAOException("Can not clone note from file");
		}
		catch(ParseException e){
			throw new DAOException("Can not clone note from file");
		}
	}

	@Override
	public void formatNote(int index) throws DAOException {
		NotebookIO io = new NotebookIO();
		try{
		Note note = io.readNoteFromFile(file, index);
		if(!(note.toString().startsWith("Note["))){
			note = new Note(note.getDate(), note.getNote());
		}
		io.writeNoteIntoFile(file, file1, index, note);
		}catch(IOException e){
			throw new DAOException("Can not find note by index into file");
		}catch(ParseException e){
			throw new DAOException("Can not find note by index into file");
		}
	}		

}
