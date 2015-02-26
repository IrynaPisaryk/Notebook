package com.epam.command;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public class Request {

	/*private Map<String, ArrayList<Object>> parameters = new HashMap<>();
	
	public void setParam(String key, ArrayList<Object> obj){
		parameters.put(key, obj);
		//Object ob = ;
	}

	public void setParam(String key){
		ArrayList<Object> defaultObj = new ArrayList<Object>();
		parameters.put(key, defaultObj);
	}
	
	public Object getParam(String key){
		return parameters.get(key);
	}*/

	private Note note = null;
	private NoteWithEMail noteEMail = null;
	private NoteWithSignature noteSignature = null;
	private NoteWithTitle noteTitle = null;
	private int index = -1;
	private String field = null;
	private Date date = null;

	public Request(){

	}

	public Request(Note note){
		this.note = note;
	}

	public Request(Date date){
		this.date = date;
	}

	public Request(int index){
		this.index = index;
	}

	public Request(int index, String note){
		this.index = index;
		field = note;
	}

	public Request(String note){
		field = note;
	}

	public Request(Note note, String field){
		this.note = note;
		this.field = field;
	}


	public Request(int index, Note note){
		this.index = index;
		this.note = note;
	}

	public Request(NoteWithEMail noteEMail){
		this.noteEMail = noteEMail;
	}

	public Request(NoteWithSignature noteSignature){
		this.noteSignature = noteSignature;
	}

	public Request(NoteWithTitle noteTitle){
		this.noteTitle = noteTitle;
	}

	public Note getNote(){
		return note;
	}

	public NoteWithEMail getNoteWithEMail(){
		return noteEMail;
	}

	public NoteWithSignature getNoteWithSignature(){
		return noteSignature;
	}

	public NoteWithTitle getNoteWithTitle(){
		return noteTitle;
	}

	public void setNote(Note note){
		this.note = note;
	}

	public void setNoteWithEMail(NoteWithEMail noteEMail){
		this.noteEMail = noteEMail;
	}

	public void setNoteWithSignature(NoteWithSignature noteSignature){
		this.noteSignature = noteSignature;
	}

	public void setWithTitle(NoteWithTitle noteTitle){
		this.noteTitle = noteTitle;
	}

	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}

	public void setField(String field){
		this.field = field;
	}

	public String getField(){
		return field;
	}

	public void setDate(Date date){
		this.date = date;
	}

	public Date getDate(){
		return date;
	}
}
