package com.epam.dao.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.dao.impl.NotebookMemoryImpl;
import com.epam.exception.DAOException;
import com.epam.exception.NotebookException;
import com.epam.logic.NotebookAdapter;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public class NotebookMemoryImplTest {
	
	private static NotebookMemoryImpl notebookMemory = new NotebookMemoryImpl();
	private Date date = new Date();
	
	@BeforeMethod
	public void beforeTest() throws DAOException{
		notebookMemory.deleteAllNotes();
	}
	
	@Test
	public void addNoteTest() throws NotebookException {		
		Note note = new Note(date, "note1");
		notebookMemory.addNote(date, "note1");
		Assert.assertEquals(NotebookAdapter.getInstance().getNotebook().getNote(), note);		
	}
	
	@Test
	public void addNoteWithEMailTest() throws NotebookException {			
		NoteWithEMail note = new NoteWithEMail(date, "note1", "a@a.com");
		notebookMemory.addNoteWithEMail(date, "note1", "a@a.com");
		Assert.assertEquals(NotebookAdapter.getInstance().getNotebook().getNote(), note);		
	}
	
	@Test
	public void addNoteWithSignatureTest() throws NotebookException {	
		NoteWithSignature note = new NoteWithSignature(date, "note1", "I");
		notebookMemory.addNoteWithSignature(date, "note1", "I");
		Assert.assertEquals(NotebookAdapter.getInstance().getNotebook().getNote(), note);		
	}
	
	@Test
	public void changeNoteTest() throws NotebookException, DAOException {
		notebookMemory.addNote(date, "note");
		String newNote = "III";
		notebookMemory.changeNote(0, newNote);
		Assert.assertEquals(NotebookAdapter.getInstance().getNotebook().getNote().getNote(), newNote);
	}
	
	@Test
	public void findNoteByTitleTest() throws DAOException {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithTitle(date, "note", "title");
		NoteWithTitle note = new NoteWithTitle(date, "note", "title");
		Assert.assertEquals(notebookMemory.findNoteByTitle("title").get(0).toString().equals(note.toString()), true);
	}
	
	@Test
	public void findNoteByIndexTest() throws DAOException {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		Assert.assertEquals(notebookMemory.findNoteByIndex(1).toString(), new Note(date, "noteAAAAAAA").toString());
	}
	
	@Test
	public void cloneNoteTest() throws CloneNotSupportedException, DAOException {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		Assert.assertEquals(notebookMemory.cloneNote(0).toString(), new Note(date, "note").toString());
	}
	
	@Test
	public void deleteNoteTest() throws NotebookException, DAOException {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		notebookMemory.deleteNote(0);
		Assert.assertEquals(NotebookAdapter.getInstance().getNotebook().getNote().toString(), new Note(date, "noteAAAAAAA").toString());
	}
	
	@Test(expectedExceptions = Exception.class)
	public void deleteAllNotesTest() throws NotebookException, DAOException {
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNote(date, "noteAAAAAAA");
		notebookMemory.deleteAllNotes();
		Assert.assertEquals(NotebookAdapter.getInstance().getNotebook().getNote(), new Note(date, "noteAAAAAAA").toString());
	}
	
	@Test
	public void findNoteBySignatureTest() throws DAOException {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithSignature(date, "note", "sign");
		NoteWithSignature note = new NoteWithSignature(date, "note", "sign");
		Assert.assertEquals(notebookMemory.findNoteBySignature("sign").get(0).toString().equals(note.toString()), true);
	}
	
	@Test
	public void findNoteByEMailTest() throws DAOException {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithEMail(date, "note", "a@a.com");
		NoteWithEMail note = new NoteWithEMail(date, "note", "a@a.com");
		Assert.assertEquals(notebookMemory.findNoteByEMail("a@a.com").get(0).toString().equals(note.toString()), true);
	}
	
	@Test
	public void findNoteByDateTest() throws DAOException {	
		notebookMemory.addNote(date, "note");		
		notebookMemory.addNoteWithEMail(date, "note", "a@a.com");
		Assert.assertEquals(notebookMemory.findNoteByDate(date).size(), 2);
	}
}
