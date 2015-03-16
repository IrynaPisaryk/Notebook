package com.epam.dao.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.dao.impl.NotebookFileImpl;
import com.epam.exception.DAOException;
import com.epam.exception.LogicException;
import com.epam.exception.NotebookException;
import com.epam.logic.NotebookAdapter;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public class NotebookFileImplTest {

	private NotebookFileImpl notebookFile = new NotebookFileImpl();
	
	@Test(expectedExceptions = LogicException.class)
	public void addNoteTest() throws DAOException, NotebookException {
		notebookFile.addNote(new Date("ghhh"), "vvv");
		Assert.assertTrue(true);
	}
}
