package com.epam.dao.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.dao.impl.NotebookMemoryImpl;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;

public class NotebookMemoryImplTest {
	
	private static NotebookMemoryImpl notebookMemory = new NotebookMemoryImpl();
	private Date date = new Date();
	
	/*@BeforeMethod
	public void beforeTest(){
		notebookMemory.deleteAllNotes();
	}
	
	@Test
	public void addNoteTest() {		
		Note note = new Note(date, "note1");
		notebookMemory.addNote(date, "note1");
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), note);		
	}
	
	@Test
	public void addNoteWithEMailTest() {			
		NoteWithEMail note = new NoteWithEMail(date, "note1", "a@a.com");
		notebookMemory.addNoteWithEMail(date, "note1", "a@a.com");
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), note);		
	}
	
	@Test
	public void addNoteWithSignatureTest() {	
		NoteWithSignature note = new NoteWithSignature(date, "note1", "I");
		notebookMemory.addNoteWithSignature(date, "note1", "I");
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), note);		
	}
	
	@Test
	public void changeNoteTest() {
		notebookMemory.addNote(date, "note");
		String newNote = "III";
		notebookMemory.changeNote(0, newNote);
		Assert.assertEquals(notebookMemory.getNotebook().getNote().getNote(), newNote);
	}
	
	@Test
	public void findNoteByTitleTest() {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithTitle(date, "note", "title");
		Assert.assertEquals(notebookMemory.findNoteByTitle("title").get(0).compareTo(1), 0);
	}
	
	@Test
	public void findNoteByIndexTest() {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		Assert.assertEquals(notebookMemory.findNoteByIndex(1).toString(), new Note(date, "noteAAAAAAA").toString());
	}
	
	@Test
	public void cloneNoteTest() throws CloneNotSupportedException {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		Assert.assertEquals(notebookMemory.cloneNote(0).toString(), new Note(date, "note").toString());
	}
	
	@Test
	public void deleteNoteTest() {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		notebookMemory.deleteNote(0);
		Assert.assertEquals(notebookMemory.getNotebook().getNote().toString(), new Note(date, "noteAAAAAAA").toString());
	}
	
	@Test(expectedExceptions = Exception.class)
	public void deleteAllNotesTest() {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		notebookMemory.deleteAllNotes();
		Assert.assertEquals(notebookMemory.getNotebook().getNote(), new Note(date, "noteAAAAAAA").toString());
	}
	
	@Test
	public void findNoteBySignatureTest() {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithSignature(date, "note", "sign");
		Assert.assertEquals(notebookMemory.findNoteBySignature("sign").get(0).compareTo(1), 0);
	}
	
	@Test
	public void findNoteByEMailTest() {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithEMail(date, "note", "a@a.com");
		Assert.assertEquals(notebookMemory.findNoteByEMail("a@a.com").get(0).compareTo(1), 0);
	}
	
	@Test
	public void findNoteByDateTest() {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithEMail(date, "note", "a@a.com");
		Assert.assertEquals(notebookMemory.findNoteByDate(date).size(), 2);
	}*/
}
