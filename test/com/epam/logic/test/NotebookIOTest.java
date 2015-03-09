package com.epam.logic.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.logic.NotebookIO;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public class NotebookIOTest {
 
	private File file;
	private File file1;
	
	@BeforeTest
	public void beforeTest(){		
		//File file = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test.txt");
		//File file1 = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test1.txt");
		file = new File("D:\\testFile.txt");
		file1 = new File("D:\\testTempFile.txt");
	}
  
	@AfterTest
	public void afterTest(){		
		file.deleteOnExit();
	}
  		

	@Test
	public void setFileTest() throws IOException{
		NotebookIO io = new NotebookIO();
		io.setFile(file);
		Assert.assertEquals(file.length(), 0);
		
	}
	
	@Test
	public void writeNoteIntoFileTest() throws IOException, ParseException {	
		Date d = new Date("2015/06/06");
		Note note = new Note(d, "I hate this world");
		NotebookIO io = new NotebookIO();
		io.writeNoteIntoFile(file, note);
		Note newNote = io.readNoteFromFile(file, 0);
		Assert.assertEquals(note.toString(), newNote.toString());
	}
	
	@Test
	public void readNoteFromFileTest() throws IOException, ParseException {	
		File fTest = new File("D:\\FTest.txt");
		NotebookIO io = new NotebookIO();
		Note note = io.readNoteFromFile(fTest, 0);		
		Date d = new Date("2015/06/06");
		Note note1 = new Note(d, "I hate this world");		
		Assert.assertEquals(note.toString(), note1.toString());
	}	
		
	@Test
	public void readNoteFromFileByIndexTest() throws IOException, ParseException {
		NotebookIO io = new NotebookIO();
		Date date = new Date("2015/06/06");
		Note note = new Note(date, "ira");
		NoteWithEMail noteM = new NoteWithEMail(date, "fuck this world", "a@a.ru");
		NoteWithTitle noteT = new NoteWithTitle(date, "this world fuck me", "ira");		
		io.writeNoteIntoFile(file, note);
		io.writeNoteIntoFile(file, noteM);
		io.writeNoteIntoFile(file, noteT);
		Assert.assertEquals(io.readNoteFromFile(file, 1).toString(), noteM.toString());

	}	

	@Test
	public void changeLineintoNoteTest() throws ParseException {

		String line = "Note[date=2015/6/6][note=ira]";		
		Date date = new Date("2015/6/6");
		String text = "ira";
		Note note  = new Note(date, text);		
		Note noteFunc = NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}
	
	@Test
	public void changeLineintoNoteWithEMailTest() throws ParseException {
		String line = "NoteWithEMail[date=2015/6/6][note=ira][email=a@a.ru]";		
		NoteWithEMail note  = new NoteWithEMail(new Date("2015/6/6"), "ira", "a@a.ru");		
		NoteWithEMail noteFunc = (NoteWithEMail)NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}
	
	@Test
	public void changeLineintoNoteWithSignatureTest() throws ParseException {
		String line = "NoteWithSignature[date=2015/6/6][note=ira][signature=Endy]";	
		NoteWithSignature note  = new NoteWithSignature(new Date("2015/6/6"), "ira", "Endy");		
		NoteWithSignature noteFunc = (NoteWithSignature)NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}
	
	@Test
	public void changeLineintoNoteWithTitleTest() throws ParseException {
		String line = "NoteWithTitle[date=2015/6/6][note=ira][title=Warning]";		
		NoteWithTitle note  = new NoteWithTitle(new Date("2015/6/6"), "ira", "Warning");		
		NoteWithTitle noteFunc = (NoteWithTitle)NotebookIO.changeLineintoNote(line);		
		Assert.assertEquals(noteFunc, note);		
	}

	@Test
	public void returnSizeTest() throws IOException {
		File fTest = new File("D:\\FTest.txt");
		NotebookIO io = new NotebookIO();
		Assert.assertEquals(io.returnSize(fTest), 1);
	}

	@Test
	public void writeNoteIntoFileInPositionTest() throws IOException, ParseException {
		File fTest = new File("D:\\newTest.txt");
		NotebookIO io = new NotebookIO();
		ArrayList<Note> array = new ArrayList<Note>();
		array.add(new Note(new Date("2015/01/01"), "all"));
		array.add(new Note(new Date("2013/06/06"), "rere"));
		array.add(new Note(new Date("2010/03/16"), "mimimi"));
		io.writeNotebookIntoFile(fTest, array);
		io.writeNoteIntoFile(fTest, file1, 1, new Note(new Date("2015/04/01"), "olimpicus"));
		Assert.assertEquals(io.readNoteFromFile(fTest, 1), new Note(new Date("2015/04/01"), "olimpicus"));
	}


	public void readNotebookFromFileTest() throws IOException, ParseException {
		File fTest = new File("D:\\newTest.txt");
		NotebookIO io = new NotebookIO();
		ArrayList<Note> array = new ArrayList<Note>();
		array.add(new Note(new Date("2015/01/01"), "all"));
		array.add(new Note(new Date("2013/06/06"), "rere"));
		array.add(new Note(new Date("2010/03/16"), "mimimi"));
		io.writeNotebookIntoFile(fTest, array);
		Assert.assertSame(io.readNotebookFromFile(fTest), array);
	}

	@Test
	public void writeNotebookIntoFileTest() throws IOException, ParseException {
		File fTest = new File("D:\\newTest1.txt");
		NotebookIO io = new NotebookIO();
		ArrayList<Note> array = new ArrayList<Note>();
		array.add(new Note(new Date("2015/01/01"), "all"));
		array.add(new Note(new Date("2013/06/06"), "rere"));
		array.add(new Note(new Date("2010/03/16"), "mimimi"));
		io.writeNotebookIntoFile(fTest, array);
		ArrayList<Note> arrayf = io.readNotebookFromFile(fTest);
		int diff=0;
		for(int i = 0; i < array.size(); i++){
			if(!(array.get(i).toString().equals(arrayf.get(i).toString()))){
				diff++;
			}
		}
		Assert.assertEquals(diff, 0);
	}
  
  
}
