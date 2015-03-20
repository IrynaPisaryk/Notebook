package com.epam.notebook.test;

import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.notebook.Note;
import com.epam.notebook.Notebook;
import com.epam.notebook.NotebookException;

public class NotebookTest extends Object {

	Date date = new Date();
	Note note1;
	Note note2;
	Note note3;
	ArrayList<Note> notes;	
	ArrayList<Note> nullNotes;
	Notebook notebook;

	@BeforeMethod
	public void beforeTest() {
		note1 = new Note(date, "Note1");
		note2 = new Note(date, "Note2");
		note3 = new Note(date, "Note3");
		notes = new ArrayList<Note>();	
		nullNotes = new ArrayList<Note>();
		notes.add(note1);
		notes.add(note2);
		notes.add(note3);	
		notebook = new Notebook();
		notebook.setNotebook(notes);
	}

	//exceptions
	@Test
	public void setNoteTest() throws NotebookException {		
		Note note = new Note(date, "Note4");
		int index = 2;
		notebook.setNote(index, note);
		Assert.assertEquals(notebook.getNote(index), note);
	}

	@Test
	public void deleteNoteTest() throws NotebookException {
		Note note = notebook.getNote(2);
		notebook.deleteNote(1);
		Assert.assertEquals(notebook.getNote(1), note);
	}

	@Test
	public void deleteNotebookTest() throws NotebookException {
		notebook.deleteNotebook();
		Assert.assertEquals(notebook.getNotebook().size(), 0);
	}

	@Test
	public void setNotebookTest() throws NotebookException {
		ArrayList<Note> notes = new ArrayList<Note>();
		notes.add(new Note(date, "Note5"));
		notebook.setNotebook(notes);
		Assert.assertEquals(notebook.getNotebook(), notes);
	}

	@Test
	public void getNoteTest() throws NotebookException {
		int index = 2;
		Assert.assertEquals(notebook.getNote(index), this.notes.get(index));
	}

	@Test
	public void getNotebookTest() throws NotebookException {
		Assert.assertEquals(notebook.getNotebook(), notes);
	}

}