package com.epam.runner;
import java.io.IOException;
import java.util.Date;

import com.epam.logic.NotebookEditor;


public class Runner {

	public static void main(String[] args) throws IOException{

		NotebookEditor editor = new NotebookEditor();
		Date date = new Date();	
		Date date1 = new Date(243254654);	
		Date date2 = new Date(5464);	
		Date date3 = new Date(675675);	
		Date date4 = new Date(87687887);		
		editor.addNote(date, "aaa");
		editor.addNote(date1, "b");
		editor.addNoteWithTitle(date, "tiiiii", "drrr");
		editor.addNoteWithEMail(date2, "note with mail", "a@ya.ru");
		editor.addNoteWithSignature(date3, "iy's me", "ira");
		editor.addNoteWithTitle(date4, "tiiiii", "title");
		editor.addNoteWithEMail(date4, "note with mail", "a@ya.ru");
		//editor.deleteNote(3);
		//editor.sortNote();
		//ArrayList<Integer> newArrayInd = editor.findNoteByDate(date4);
		//ArrayList<Integer> newArrayInd = editor.findNoteByTitle("drrr");
		//ArrayList<Integer> newArrayInd = editor.findNoteByEMail("a@ya.ru");
		//ArrayList<Integer> newArrayInd = editor.findNoteByNote("tiiiii");
		//ArrayList<Integer> newArrayInd = editor.findNoteBySignature("ira");		
		/*for(Integer i: editor.findNoteBySignature("ira")){
			System.out.println(notebook.getNote(i));
		}*/
		//editor.changeNote(4, "SATANA");
		//editor.printNote(4);
		//Note note = new Note(date, "aaasss");
		//editor.replaceNote(2, note);
		/*try {
			Note note = editor.cloneNote(5);
			editor.replaceNote(0, note);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//editor.formatNote(5);
		/*for(Note i: notebook.getNotebook()){
			System.out.println(editor.printNote(index);));
		}*/
		
		for(int i=0; i<7; i++){
			editor.printNote(i);
		}
	}
}