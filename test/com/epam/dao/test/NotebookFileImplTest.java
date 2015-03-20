package com.epam.dao.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.dao.DAOException;
import com.epam.dao.impl.NotebookFileImpl;
import com.epam.dao.impl.NotebookMemoryImpl;
import com.epam.logic.LogicException;
import com.epam.logic.NotebookAdapter;
import com.epam.logic.NotebookIO;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.notebook.NotebookException;
import com.epam.property.TestProvider;


public class NotebookFileImplTest {

	private NotebookFileImpl notebookFile = new NotebookFileImpl();
	
	@Test
	public void addNoteTest() throws DAOException, LogicException {
		
		notebookFile.addNote(new Date("2015/01/01"), "vvv");
		NotebookIO io = new NotebookIO();
		Note readNote = io.readNoteFromFile(notebookFile.getFile(), 0);
		Assert.assertEquals(readNote.toString(), new Note(new Date("2015/01/01"), "vvv").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void addNoteWithEMailTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithEMail(new Date("2015/03/03"), "slot", "nookie");
		NotebookIO io = new NotebookIO();
		Note readNote = io.readNoteFromFile(notebookFile.getFile(), 0);
		Assert.assertEquals(readNote.toString(), new NoteWithEMail(new Date("2015/03/03"), "slot", "nookie").toString());
		notebookFile.getFile().delete();
	}
	
	@Test 
	public void addNoteWithSignatureTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithSignature(new Date("2015/03/03"), "slot", "sign");
		NotebookIO io = new NotebookIO();
		Note readNote = io.readNoteFromFile(notebookFile.getFile(), 0);
		Assert.assertEquals(readNote.toString(), new NoteWithSignature(new Date("2015/03/03"), "slot", "sign").toString());
		notebookFile.getFile().delete();
	}
	
	@Test 
	public void addNoteWithTitleTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		NotebookIO io = new NotebookIO();
		Note readNote = io.readNoteFromFile(notebookFile.getFile(), 0);
		Assert.assertEquals(readNote.toString(), new NoteWithTitle(new Date("2015/03/03"), "slot", "title").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void deleteNoteTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.deleteNote(0);
		NotebookIO io = new NotebookIO();		
		Assert.assertEquals(io.returnSize(notebookFile.getFile()), 0);
		notebookFile.getFile().delete();
	}
	
	@Test
	public void deleteAllNotesTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNote(new Date("2015/01/01"), "note");
		notebookFile.deleteAllNotes();
		NotebookIO io = new NotebookIO();		
		Assert.assertEquals(io.returnSize(notebookFile.getFile()), 0);
		notebookFile.getFile().delete();
	}
	
	@Test
	public void findNoteByIndexTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNote(new Date("2015/01/01"), "note");
		Assert.assertEquals(notebookFile.findNoteByIndex(0).toString(), new NoteWithTitle(new Date("2015/03/03"), "slot", "title").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void findNoteByTitleTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNote(new Date("2015/01/01"), "note");
		notebookFile.addNoteWithEMail(new Date("2014/08/08"), "drug", "fuck");
		ArrayList<Note> notes = notebookFile.findNoteByTitle("title");
		Assert.assertEquals(notes.get(0).toString(), new NoteWithTitle(new Date("2015/03/03"), "slot", "title").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void findNoteBySignatureTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNote(new Date("2015/01/01"), "note");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		ArrayList<Note> notes = notebookFile.findNoteBySignature("signature");
		Assert.assertEquals(notes.get(0).toString(), new NoteWithSignature(new Date("2014/08/08"), "drug", "signature").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void findNoteByEMailTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		ArrayList<Note> notes = notebookFile.findNoteByEMail("email");
		Assert.assertEquals(notes.get(0).toString(), new NoteWithEMail(new Date("2015/01/01"), "note", "email").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void findNoteByDateTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		ArrayList<Note> notes = notebookFile.findNoteByDate(new Date("2015/01/01"));
		Assert.assertEquals(notes.get(0).toString(), new NoteWithEMail(new Date("2015/01/01"), "note", "email").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void findNoteByNoteTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		ArrayList<Note> notes = notebookFile.findNoteByNote("slot");
		Assert.assertEquals(notes.get(0).toString(), new NoteWithTitle(new Date("2015/03/03"), "slot", "title").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void changeNoteTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.changeNote(0, "All");
		NotebookIO io = new NotebookIO();		
		Assert.assertEquals(io.readNoteFromFile(notebookFile.getFile(), 0).toString(), new NoteWithTitle(new Date("2015/03/03"), "All", "title").toString());
		notebookFile.getFile().delete();
	}
	
	@Test
	public void sortNoteTest() throws DAOException, LogicException, NotebookException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		notebookFile.sortNote();
		
		NotebookMemoryImpl notebookMemory = new NotebookMemoryImpl();
		notebookMemory.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookMemory.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookMemory.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		notebookMemory.sortNote();
		
		NotebookIO io = new NotebookIO();		
		ArrayList<Note> notes = io.readNotebookFromFile(notebookFile.getFile());
		
		int diff = 0;
		for(int i = 0; i < notes.size(); i++){			
			
			if(!(notes.get(i).toString().equals(NotebookAdapter.getInstance().getNotebook().getNote(i).toString()))){
				diff++;
			}
		}		
		Assert.assertEquals(diff, 0);
		notebookFile.getFile().delete();		
	}
	
	
	@Test
	public void replaceNoteTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		notebookFile.replaceNote(1, new Note(new Date("2015/01/01"), "ooo"));		
		NotebookIO io = new NotebookIO();
		Assert.assertEquals(io.readNoteFromFile(notebookFile.getFile(), 1).toString(), new Note(new Date("2015/01/01"), "ooo").toString());
		notebookFile.getFile().delete();	
	}
	
	@Test
	public void cloneNoteTest() throws DAOException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.addNoteWithEMail(new Date("2015/01/01"), "note", "email");
		notebookFile.addNoteWithSignature(new Date("2014/08/08"), "drug", "signature");
		Assert.assertEquals(notebookFile.cloneNote(2).toString(), new NoteWithSignature(new Date("2014/08/08"), "drug", "signature").toString());
		notebookFile.getFile().delete();	
	}
	
	@Test
	public void formatNoteTest() throws DAOException, LogicException{
		notebookFile.setFile(new File(TestProvider.getFileTestPathKeeper()));
		notebookFile.addNoteWithTitle(new Date("2015/03/03"), "slot", "title");
		notebookFile.formatNote(0);
		NotebookIO io = new NotebookIO();
		Assert.assertEquals(io.readNoteFromFile(notebookFile.getFile(), 0).toString(), new Note(new Date("2015/03/03"), "slot").toString());
		notebookFile.getFile().delete();	
	}
}
