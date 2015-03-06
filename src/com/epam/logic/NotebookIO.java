package com.epam.logic;

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

import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public final class NotebookIO{	


	private File file = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test.txt");
	private File file1 = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test1.txt");
	//private File file = new File("D:\\test.txt");
	//private File file1 = new File("D:\\test1.txt");
	

	public void setFile(){
		file = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test.txt");
		//file = new File("D:\\test.txt");
	}

	public void writeNoteIntoFile(Note note) throws IOException{
		Writer writer = new FileWriter(file, true);
		PrintWriter out = new PrintWriter(writer);
		out.println(note.toString());	
		writer.close();	
	}
	
	public Note readNoteFromFile(int index) throws IOException, ParseException{
		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int innerIndex=-1;
		while ((line = bufferedReader.readLine()) 
				!= null) {
			innerIndex++;
			if(innerIndex == index){
				//bufferedReader.close();
				return changeLineintoNote(line);
			}
		}
		//bufferedReader.close();
		return null;

	}	

	public Note returnNoteByIndex(int index) throws ParseException, IOException{

		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int innerIndex=-1;
		while ((line = bufferedReader.readLine()) 
				!= null) {
			innerIndex++;
			if(innerIndex == index){
				//bufferedReader.close();
				return changeLineintoNote(line);
			}
		}
		//bufferedReader.close();
		return null;

	}

	public static Note changeLineintoNote(String line) throws ParseException{

		Pattern p = Pattern.compile("(\\W|^)NoteWithEMail(\\W|$) ");  
		Pattern p1 = Pattern.compile("(\\W|^)NoteWithSignature(\\W|$) ");  
		Pattern p2 = Pattern.compile("(\\W|^)NoteWithTitle(\\W|$) ");  
		Matcher m = p.matcher(line); 
		Matcher m1 = p1.matcher(line); 
		Matcher m2 = p2.matcher(line); 

		if(m.matches()){
			Date date =new Date(line.substring(line.indexOf('[')+6, line.indexOf(']')));
			line = line.substring(line.indexOf(']'), line.length());
			String email = line.substring(line.lastIndexOf('[')+7, line.lastIndexOf(']'));
			String text = line.substring(7, line.lastIndexOf('[')-1);
			return new NoteWithEMail(date, text, email);
		}else if(m1.matches()){
			Date date =new Date(line.substring(line.indexOf('[')+6, line.indexOf(']')));
			line = line.substring(line.indexOf(']'), line.length());
			String sign = line.substring(line.lastIndexOf('[')+12, line.lastIndexOf(']'));
			String text = line.substring(7, line.lastIndexOf('[')-1);
			return new NoteWithSignature(date, text, sign);
		}else if(m2.matches()){
			Date date =new Date(line.substring(line.indexOf('[')+6, line.indexOf(']')));
			line = line.substring(line.indexOf(']'), line.length());
			String title = line.substring(line.lastIndexOf('[')+8, line.lastIndexOf(']'));
			String text = line.substring(7, line.lastIndexOf('[')-1);
			return new NoteWithTitle(date, text, title);
		}else{
			Date date =new Date(line.substring(line.indexOf('[')+6, line.indexOf(']')));
			String text = line.substring(line.indexOf(']')+7, line.length()-1);
			return new Note(date, text);
		}	
	}

	public int returnSize() throws IOException{

		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		int innerIndex=-1;
		while ((line = bufferedReader.readLine()) 
				!= null) {
			innerIndex++;
		}
		//bufferedReader.close();
		return innerIndex;

	}

	public void writeNoteIntoFile(int index, Note note) throws IOException {
				
		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		Writer writerTemp = new FileWriter(file1, true);
		PrintWriter outTemp = new PrintWriter(writerTemp);		
		
		
		String line;
		int innerIndex=0;
		while ((line = bufferedReader.readLine()) != null) {
			if(innerIndex == index){				
				outTemp.println(note.toString());
			}else{
				outTemp.println(line);
			}			
			innerIndex++;			
		}
		bufferedReader.close();
		outTemp.close();	
		File fileNew = new File("C:\\Users\\Irina_Pisarik\\Desktop\\testNew.txt");		
			Reader readerTemp = new FileReader(file1);
			BufferedReader bufferedReaderTemp = new BufferedReader(readerTemp);
			Writer writer = new FileWriter(fileNew, true);
			PrintWriter out = new PrintWriter(writer);
			while((line = bufferedReaderTemp.readLine()) != null){
				out.println(line);
			}
			bufferedReaderTemp.close();
			out.close();
			file1.delete();	
			file.delete();
			file = fileNew;
		}
				
	

	public ArrayList<Note> readNotebookFromFile() throws IOException, ParseException {
		ArrayList<Note> notesArray = new ArrayList<Note>();
		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		while ((line = bufferedReader.readLine()) 
				!= null) {
			Note note = changeLineintoNote(line);
			notesArray.add(note);
		}
		bufferedReader.close();
		return notesArray;


	}

	public void writeNotebookIntoFile(ArrayList<Note> notes) throws IOException {
		Writer writer = new FileWriter(file, true);
		PrintWriter out = new PrintWriter(writer);
		for(Note note : notes){
			out.println(note.toString());	
		}	      
		writer.close();

	}

	/*public Note readNotebookFromFile() throws IOException, ParseException{

	      Reader reader = new FileReader(file);
	      BufferedReader bufferedReader = new BufferedReader(reader);
	      String line;
	      while ((line = bufferedReader.readLine())!= null) {
	    	 if(line.startsWith("Note")){
	    		 Date date;
	    		 SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");
	    			date = sdf.parse(line.substring(10, 27));
	    		 String text = line.substring(45, line.length()-2);
	    		 Note note = new Note(date, text);
	    		 return note;
	    	 }
	    	 if(line.startsWith("NoteWithEMail")){

	    	 }
	      }
	      bufferedReader.close();
		return null;

	}*/
}
