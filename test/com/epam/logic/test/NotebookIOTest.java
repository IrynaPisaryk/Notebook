package com.epam.logic.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.logic.LogicException;
import com.epam.logic.NotebookIO;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.property.TestProvider;
import com.epam.resource.ResourceProvider;

public class NotebookIOTest {
 
	@Test
	public void setFileTest() throws LogicException{
		File file = new File(TestProvider.getFileTestPathKeeper());
		NotebookIO io = new NotebookIO();
		io.setFile(file);
		Assert.assertEquals(file.length(), 0);
		file.delete();		
	}
	
	@Test
	public void writeNoteIntoFileTest() throws LogicException {	
		File file = new File(TestProvider.getFileTestPathKeeper());
		Date d = new Date("2015/06/06");
		Note note = new Note(d, "I hate this world");
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(file, note);
		Note newNote = io.readNoteFromFile(file, 0);
		Assert.assertEquals(note.toString(), newNote.toString());
		file.delete();
	}
	
	@Test
	public void readNoteFromFileTest() throws LogicException {			
		File file = new File(TestProvider.getFileTestPathKeeper());
		Date d = new Date("2015/01/01");
		Note note1 = new Note(d, "all");
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(file, note1);		
		Note note = io.readNoteFromFile(file, 0);					
		Assert.assertEquals(note.toString(), note1.toString());
		file.delete();
	}	
		
	@Test
	public void readNoteFromFileByIndexTest() throws LogicException {
		File file = new File(TestProvider.getFileTestPathKeeper());
		NotebookIO io = new NotebookIO();
		Date date = new Date("2015/06/06");
		Note note = new Note(date, "ira");
		NoteWithEMail noteM = new NoteWithEMail(date, "fuck this world", "a@a.ru");
		NoteWithTitle noteT = new NoteWithTitle(date, "this world fuck me", "ira");		
		io.writeNoteIntoFile(file, note);
		io.writeNoteIntoFile(file, noteM);
		io.writeNoteIntoFile(file, noteT);
		Assert.assertEquals(io.readNoteFromFile(file, 1).toString(), noteM.toString());
		file.delete();
	}	

	@Test
	public void changeLineintoNoteTest() throws LogicException {
		File file = new File(TestProvider.getFileTestPathKeeper());
		String line = "Note[date=2015/6/6][note=ira]";		
		Date date = new Date("2015/6/6");
		String text = "ira";
		Note note  = new Note(date, text);		
		Note noteFunc = NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
		file.delete();
	}
	
	@Test
	public void changeLineintoNoteWithEMailTest() throws LogicException {
		String line = "NoteWithEMail[date=2015/6/6][note=ira][email=a@a.ru]";		
		NoteWithEMail note  = new NoteWithEMail(new Date("2015/6/6"), "ira", "a@a.ru");		
		NoteWithEMail noteFunc = (NoteWithEMail)NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}
	
	@Test
	public void changeLineintoNoteWithSignatureTest() throws LogicException {
		String line = "NoteWithSignature[date=2015/6/6][note=ira][signature=Endy]";	
		NoteWithSignature note  = new NoteWithSignature(new Date("2015/6/6"), "ira", "Endy");		
		NoteWithSignature noteFunc = (NoteWithSignature)NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}
	
	@Test
	public void changeLineintoNoteWithTitleTest() throws LogicException {
		String line = "NoteWithTitle[date=2015/6/6][note=ira][title=Warning]";		
		NoteWithTitle note  = new NoteWithTitle(new Date("2015/6/6"), "ira", "Warning");		
		NoteWithTitle noteFunc = (NoteWithTitle)NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}

	@Test
	public void returnSizeTest() throws LogicException {	
		File file = new File(TestProvider.getFileTest1PathKeeper());
		Date d = new Date("2015/06/06");
		Note note = new Note(d, "I hate this world");
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(file, note);
		Assert.assertEquals(io.returnSize(file), 1);
		file.delete();
	}

	@Test
	public void writeNoteIntoFileInPositionTest() throws LogicException {
		File file = new File(TestProvider.getFileTestPathKeeper());
		File fileTemp = new File(TestProvider.getFileTest2PathKeeper());
		NotebookIO io = new NotebookIO();
		ArrayList<Note> array = new ArrayList<Note>();
		array.add(new Note(new Date("2015/01/01"), "all"));
		array.add(new Note(new Date("2013/06/06"), "rere"));
		array.add(new Note(new Date("2010/03/16"), "mimimi"));
		io.writeNotebookIntoFile(file, array);
		io.writeNoteIntoFile(file, fileTemp, 1, new Note(new Date("2015/04/01"), "olimpicus"));
		Assert.assertEquals(io.readNoteFromFile(file, 1), new Note(new Date("2015/04/01"), "olimpicus"));
		file.delete();
		fileTemp.delete();
	}


	public void readNotebookFromFileTest() throws LogicException {
		File file = new File(TestProvider.getFileTestPathKeeper());
		NotebookIO io = new NotebookIO();
		ArrayList<Note> array = new ArrayList<Note>();
		array.add(new Note(new Date("2015/01/01"), "all"));
		array.add(new Note(new Date("2013/06/06"), "rere"));
		array.add(new Note(new Date("2010/03/16"), "mimimi"));
		io.writeNotebookIntoFile(file, array);
		Assert.assertSame(io.readNotebookFromFile(file), array);
		file.delete();
	}

	@Test
	public void writeNotebookIntoFileTest() throws LogicException {
		File file = new File(TestProvider.getFileTestPathKeeper());
		NotebookIO io = new NotebookIO();
		ArrayList<Note> array = new ArrayList<Note>();
		array.add(new Note(new Date("2015/01/01"), "all"));
		array.add(new Note(new Date("2013/06/06"), "rere"));
		array.add(new Note(new Date("2010/03/16"), "mimimi"));
		io.writeNotebookIntoFile(file, array);
		ArrayList<Note> arrayf = io.readNotebookFromFile(file);
		int diff=0;
		for(int i = 0; i < array.size(); i++){
			if(!(array.get(i).toString().equals(arrayf.get(i).toString()))){
				diff++;
			}
		}
		Assert.assertEquals(diff, 0);
	} 
  
}
