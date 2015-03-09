package com.epam.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.epam.command.Request;
import com.epam.notebook.Note;

public class ParametersConductor {

	private Scanner scan1 = new Scanner(System.in);
	private Scanner scan2 = new Scanner(System.in);
	
	public Request prepareAddParams(Request request) throws ParseException{
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = scan2.nextLine();
		request.setParam("addNote", date, text);				
		return request;
	}
	public Request prepareAddEMailParams(Request request) throws ParseException{
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = scan2.nextLine();
		System.out.println("Enter e-mail:");
		String email = scan2.nextLine();
		request.setParam("addEMail", date, text, email);				
		return request;

	}
	public Request prepareAddSignParams(Request request) throws ParseException{
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = scan2.nextLine();
		System.out.println("Enter signature:");
		String sig = scan2.nextLine();
		request.setParam("addSign", date, text, sig);				
		return request;
	}
	public Request prepareAddTitleParams(Request request) throws ParseException{
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = scan2.nextLine();
		System.out.println("Enter title:");
		String title = scan2.nextLine();
		request.setParam("addTitle", date, text, title);				
		return request;
	}
	public Request prepareChangeParams(Request request){
		System.out.println("Enter note index:");
		int index = scan1.nextInt();
		System.out.println("Enter new note text:");
		String newText = scan2.nextLine();
		request.setParam("changeNote", index, newText);
		return request;
	}
	public Request prepareCloneParams(Request request){
		System.out.println("Enter note index:");
		int index = scan1.nextInt();
		request.setParam("cloneNote", index);
		return request;
	}
	public Request prepareDeleteAllParams(Request request){
		request.setParam("deteleAllNotes");
		return request;
	}
	public Request prepareDeleteParams(Request request){
		System.out.println("Enter note index:");
		int index = scan1.nextInt();
		request.setParam("deleteNote", index);
		return request;
	}
	public Request prepareFindParams(Request request) throws ParseException{

		System.out.println("Enter index for search:");
		int index = scan1.nextInt();
		request.setParam("find", index);
		return request;
	}
	public Request prepareFindEMailParams(Request request) throws ParseException{
		System.out.println("Enter email for search:");
		String text = scan2.nextLine();
		request.setParam("findEMail", text);
		return request;	
	}

	public Request prepareFindSignParams(Request request) throws ParseException{
		System.out.println("Enter signature for search:");
		String text = scan2.nextLine();
		request.setParam("findSign", text);
		return request;	
	}

	public Request prepareFindTitleParams(Request request) throws ParseException{
		System.out.println("Enter title for search:");
		String text = scan2.nextLine();
		request.setParam("findTitle", text);
		return request;	
	}

	public Request prepareFindDateParams(Request request) throws ParseException{
		System.out.println("Enter date for search in format dd.mm.yyyy:");
		String indexDate = scan2.nextLine();	
		request.setParam("findDate", new Date(indexDate));
		return request;
	}

	public Request prepareFindNoteParams(Request request) throws ParseException{
		System.out.println("Enter note for search:");
		String text = scan2.nextLine();
		request.setParam("findNote", text);
		return request;	
	}

	public Request prepareFormatParams(Request request){
		System.out.println("Enter index of note you want to format:");
		int index = scan1.nextInt();
		request.setParam("formatNote", index);
		return request;
	}
	public Request prepareReplaceParams(Request request) throws ParseException{
		Date date = setDate();
		System.out.println("Enter index of note you want to replace:");
		int index = scan1.nextInt();
		System.out.println("Enter text of new note:");
		String text = scan2.nextLine();
		Note newNote  = new Note(date, text);
		request.setParam("replaceNote", index, newNote);
		return request;
	}
	public Request prepareSortParams(Request request){
		request.setParam("sortNote");
		return request;
	}	
	
	private Date setDate() throws ParseException{
		Date date;
		System.out.println("Enter the date of note in format dd/mm/yyyy" );
		String number = scan2.nextLine();
		date = new Date(number);
		return date;
	}
	
}
