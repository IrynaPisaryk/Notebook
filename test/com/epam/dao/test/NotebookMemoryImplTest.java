package com.epam.dao.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.dao.impl.NotebookMemoryImpl;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;

public class NotebookMemoryImplTest {
	
	private static NotebookMemoryImpl notebookMemory = new NotebookMemoryImpl();
	private Date date = new Date();
	
	@Test
	public void addNoteTest() {		
		Note note = new Note(date, "note1");
		notebookMemory.addNote(date, "note1");
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), note);		
	}
	
	@Test
	public void addNoteWithEMailTest() {	
		notebookMemory.deleteAllNotes();
		NoteWithEMail note = new NoteWithEMail(date, "note1", "a@a.com");
		notebookMemory.addNoteWithEMail(date, "note1", "a@a.com");
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), note);		
	}
	
	@Test
	public void addNoteWithSignatureTest() {	
		notebookMemory.deleteAllNotes();
		NoteWithSignature note = new NoteWithSignature(date, "note1", "I");
		notebookMemory.addNoteWithSignature(date, "note1", "I");
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), note);		
	}
	
	@Test
	public void changeNoteTest() {
		notebookMemory.deleteAllNotes();
		notebookMemory.addNote(date, "note");
		String newNote = "III";
		notebookMemory.changeNote(0, newNote);
		Assert.assertEquals(notebookMemory.getNotebook().getNote().getNote(), newNote);
	}
	
	@Test
	public void findNoteByTitleTest() {
		notebookMemory.deleteAllNotes();	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithTitle(date, "note", "title");
		Assert.assertEquals(notebookMemory.findNoteByTitle("title").get(0).compareTo(1), 0);
	}
	
	@Test
	public void findNoteTest() {
		notebookMemory.deleteAllNotes();	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithTitle(date, "note", "title");
		Assert.assertEquals(notebookMemory.findNoteByTitle("title").get(0).compareTo(1), 0);
	}
	
	
}
