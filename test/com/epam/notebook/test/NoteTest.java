package com.epam.notebook.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.notebook.Note;

public class NoteTest {
	
	Date date = new Date();
	Note note; 
	
	/*@DataProvider(name = "EqualsTestData")
	public Object[][] createData() {
		return new Object[][] {  };
	}*/
	
	@BeforeMethod
	public void beforeMethod(){
		this.note =  new Note(date, "myNote");
	}
	
	@Test
	public void setNoteTest() {
		note.setNote("lala");
		Assert.assertEquals(note.getNote(), "lala");
	}
	
	@Test
	public void getNoteTest() {
		Assert.assertEquals(note.getNote(), "myNote");
	}
	
	@Test
	public void getDateTest() {
		Assert.assertEquals(note.getDate(), date);
	}
	
	@Test
	public void setDateTest() {
		Date newDate = new Date();
		note.setDate(newDate);
		Assert.assertEquals(note.getDate(), newDate);
	}
	
	@Test(enabled = false, dataProvider = "EqualsTestData")
	public void equalsTest(Object obj, Note note, boolean expected) {
		
	}
}
