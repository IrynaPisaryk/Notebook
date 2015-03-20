package com.epam.dao.test;

import java.io.File;

import org.testng.annotations.Test;

import com.epam.dao.DAOException;
import com.epam.dao.impl.NotebookFileImpl;
import com.epam.property.TestProvider;

//if file is't exist

public class NotebookFileImplNoFileTest {
	
	private NotebookFileImpl notebookFile = new NotebookFileImpl();
	
	{
		notebookFile.setFile(new File(TestProvider.getNotebookFileImplNoFile()));
		notebookFile.setFileTemp(new File(TestProvider.getNotebookFileImplNoFileTemp()));		
	}
	
	
	@Test(expectedExceptions = DAOException.class)
	public void addNoteTest() throws DAOException {
		notebookFile.addNote(null, "text");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void addNoteWithEMailTest() throws DAOException {
		notebookFile.addNoteWithEMail(null, "text", "email");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void addNoteWithSignatureTest() throws DAOException {
		notebookFile.addNoteWithSignature(null, "text", "signature");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void addNoteWithTitleTest() throws DAOException {
		notebookFile.addNoteWithTitle(null, "text", "title");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void deleteNoteTest() throws DAOException {
		notebookFile.deleteNote(0);
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void deleteAllNotesTest() throws DAOException {
		notebookFile.deleteAllNotes();
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void findNoteByIndexTest() throws DAOException {
		notebookFile.findNoteByIndex(0);
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void findNoteByTitleTest() throws DAOException {
		notebookFile.findNoteByTitle("title");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void findNoteBySignatureTest() throws DAOException {
		notebookFile.findNoteBySignature("signature");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void findNoteByEMailTest() throws DAOException {
		notebookFile.findNoteByEMail("email");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void findNoteByDateTest() throws DAOException {
		notebookFile.findNoteByDate(null);
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void findNoteByNoteTest() throws DAOException {
		notebookFile.findNoteByNote("text");
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void changeNoteTest() throws DAOException {
		notebookFile.changeNote(0, null);
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void sortNoteTest() throws DAOException {
		notebookFile.sortNote();
	}
	
	
	@Test(expectedExceptions = DAOException.class)
	public void replaceNoteTest() throws DAOException {
		notebookFile.replaceNote(0, null);
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void cloneNoteTest() throws DAOException {
		notebookFile.cloneNote(0);
	}
	
	@Test(expectedExceptions = DAOException.class)
	public void formatNoteTest() throws DAOException {
		notebookFile.formatNote(0);
	}
	
}
