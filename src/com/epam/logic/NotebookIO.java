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

import com.epam.exception.LogicException;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public final class NotebookIO {

	public void setFile(File file) throws LogicException {
		file.delete();
		try{
			file.createNewFile();
		} catch(IOException e){
			throw new LogicException();
		}
	}

	public void writeNoteIntoFile(File file, Note note) throws LogicException  {
		try{
			Writer writer = new FileWriter(file, true);
			PrintWriter out = new PrintWriter(writer);
			out.println(note.toString());
			writer.close();
		} catch(IOException e){
			throw new LogicException();
		}
	}

	public Note readNoteFromFile(File file, int index) throws LogicException {
		try{
			Reader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			int innerIndex = -1;
			while ((line = bufferedReader.readLine()) != null) {
				innerIndex++;
				if (innerIndex == index) {
					bufferedReader.close();
					return changeLineintoNote(line);
				}
			}
			bufferedReader.close();
		} catch(IOException e){
			throw new LogicException();
		}		
		return null;

	}

	public static Note changeLineintoNote(String line)  {

		String date = line.substring(line.indexOf('[') + 6, line.indexOf(']'));
		String year = date.substring(0, date.indexOf('/'));
		String day = date.substring(date.lastIndexOf('/'), date.length());
		String month = date.substring(date.indexOf('/'), date.lastIndexOf('/'));
		Date newDate = new Date(year + "/" + month + "/" + day);		

		if (line.startsWith("NoteWithEMail")) {
			line = line.substring(line.indexOf(']'), line.length());
			String email = line.substring(line.lastIndexOf('[') + 7, line.lastIndexOf(']'));
			String text = line.substring(7, line.lastIndexOf('[') - 1);

			return new NoteWithEMail(newDate, text, email);

		} else if (line.startsWith("NoteWithSignature")) {
			line = line.substring(line.indexOf(']'), line.length());
			String sign = line.substring(line.lastIndexOf('[') + 11, line.lastIndexOf(']'));
			String text = line.substring(7, line.lastIndexOf('[') - 1);

			return new NoteWithSignature(newDate, text, sign);

		} else if (line.startsWith("NoteWithTitle")) {			
			line = line.substring(line.indexOf(']'), line.length());
			String title = line.substring(line.lastIndexOf('[') + 7, line.lastIndexOf(']'));
			String text = line.substring(7, line.lastIndexOf('[') - 1);

			return new NoteWithTitle(newDate, text, title);

		} else {
			String text = line.substring(line.indexOf(']') + 7, line.length() - 1);

			return new Note(newDate, text);
		}


	}

	public int returnSize(File file) throws LogicException  {

		try{
			Reader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			int innerIndex = 0;
			while ((line = bufferedReader.readLine()) != null) {
				innerIndex++;
			}
			bufferedReader.close();
			return innerIndex;
		} catch(IOException e){
			throw new LogicException();
		}

	}

	public void writeNoteIntoFile(File file, File file1, int index, Note note) throws LogicException {

		try{
			Reader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);

			Writer writerTemp = new FileWriter(file1, true);
			PrintWriter outTemp = new PrintWriter(writerTemp);

			String line;
			int innerIndex = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if (innerIndex == index) {
					outTemp.println(note.toString());
				} else {
					outTemp.println(line);
				}
				innerIndex++;
			}
			bufferedReader.close();
			outTemp.close();
			Reader readerTemp = new FileReader(file1);
			BufferedReader bufferedReaderTemp = new BufferedReader(readerTemp);
			Writer writer = new FileWriter(file);
			PrintWriter out = new PrintWriter(writer);
			while ((line = bufferedReaderTemp.readLine()) != null) {
				out.println(line);
			}
			bufferedReaderTemp.close();
			out.close();
			file1.delete();
		} catch(IOException e){
			throw new LogicException();
		}
	}

	public void writeNoteIntoFile(File file, File file1, int index) throws LogicException {

		try{
			Reader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);

			Writer writerTemp = new FileWriter(file1, true);
			PrintWriter outTemp = new PrintWriter(writerTemp);

			String line;
			int innerIndex = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if (innerIndex == index) {

				} else {
					outTemp.println(line);
				}
				innerIndex++;
			}
			bufferedReader.close();
			outTemp.close();
			Reader readerTemp = new FileReader(file1);
			BufferedReader bufferedReaderTemp = new BufferedReader(readerTemp);
			Writer writer = new FileWriter(file);
			PrintWriter out = new PrintWriter(writer);
			while ((line = bufferedReaderTemp.readLine()) != null) {
				out.println(line);
			}
			bufferedReaderTemp.close();
			out.close();
			file1.delete();
		} catch(IOException e){
			throw new LogicException();
		}
	}

	public ArrayList<Note> readNotebookFromFile(File file) throws LogicException {

		try{
			ArrayList<Note> notesArray = new ArrayList<Note>();
			Reader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Note note = changeLineintoNote(line);
				notesArray.add(note);
			}
			bufferedReader.close();
			return notesArray;
		}catch(IOException e){
			throw new LogicException();
		}

	}

	public void writeNotebookIntoFile(File file, ArrayList<Note> notes) throws LogicException {

		try{
			Writer writer = new FileWriter(file, true);
			PrintWriter out = new PrintWriter(writer);
			for (Note note : notes) {
				out.println(note.toString());
			}
			writer.close();
		} catch(IOException e){
			throw new LogicException();
		}

	}

}
