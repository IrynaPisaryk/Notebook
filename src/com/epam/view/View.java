package com.epam.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.epam.command.CommandName;
import com.epam.command.Manager;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public class View {

	private Manager manager = new Manager();

	private int showMenu(){
		System.out.println("What you want to do?"+"\n"
				+"add note: 1"+"\n"
				+"change note: 2"+"\n"
				+"clone note: 3"+"\n"
				+"delete all notes: 4"+"\n"
				+"delete note: 5"+"\n"
				+"find note: 6"+"\n"
				+"format note: 7"+"\n"
				+"replace note: 8"+"\n"
				+"sort note: 9"+"\n"
				+"exit: 0"+"\n");
		Scanner scan = new Scanner(System.in);	
		//hasNextInt()
		//hasNextËşáîéÒèïÈñïîëüçóéÒóïèöà
		int result = scan.nextInt();
		if(result >= 0 && result < 10){
			return result;
		}
		else{
			System.out.println("Incorrect number");
			return 0;
		}
		
	}
	public void run() throws IOException, CloneNotSupportedException, ParseException{
		int whatDo = -1;
		while(whatDo != 0){
			whatDo = showMenu();
			Request request = prepareParams(whatDo);		
			if(request == null){
				return;
			}		
			CommandName name = getCommandName(whatDo);
			Response response = manager.doRequest(name, request);
			printResponse(response);
		}
	}	
	private CommandName getCommandName(int whatDo){		
		CommandName name = null;
		switch(whatDo){
		case(1):
			name  = CommandName.getType("add");
		break;
		case(2):
			name  = CommandName.getType("change");
		break;
		case(3):
			name  = CommandName.getType("clone");
		break;
		case(4):
			name  = CommandName.getType("delete_all");
		break;
		case(5):
			name  = CommandName.getType("delete");
		break;
		case(6):
			name  = CommandName.getType("find");
		break;
		case(7):
			name  = CommandName.getType("format");
		break;
		case(8):
			name  = CommandName.getType("replace");
		break;
		case(9):
			name  = CommandName.getType("sort");
		break;
		}		
		return name;
	}
	private void printResponse(Response response) {
		if(response.getNotes() != null){
			for(Note note : response.getNotes()){
				System.out.println(note.toString());
			}
		}

		if(response.getNotebook().getNotebook() != null){
			for(Note note : response.getNotebook().getNotebook()){
				System.out.println(note.toString());
			}
		}

		if(response.getNote() != null){
			System.out.println(response.getNote().toString());
		}

	}
	private Request prepareParams(int i) throws ParseException {
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Request request = new Request();
		switch(i){
		case(1):
			return prepareAddParams(scan1, scan2, request);
		case(2):
			return prepareChangeParams(scan1, scan2, request);
		case(3):
			return prepareCloneParams(scan1, scan2, request);
		case(4):
			return prepareDeleteAllParams(scan1, scan2, request);
		case(5):
			return prepareDeleteParams(scan1, scan2, request);
		case(6):
			return prepareFindParams(scan1, scan2, request);
		case(7):
			return prepareFormatParams(scan1, scan2, request);
		case(8):
			return prepareReplaceParams(scan1, scan2, request);
		case(9):
			return prepareSortParams(scan1, scan2, request);
		case(0):
			System.out.println("Bye");
		scan1.close();
		scan2.close();
		return null;
		}
		scan1.close();
		scan2.close();
		return request;
	}
	private Request prepareAddParams(Scanner scan1, Scanner scan2, Request request) throws ParseException{
		Date date = setDate();
		System.out.println("What kind of note you want to add?"+"\n"
				+"just note: 1"+"\n"
				+"note with email: 2"+"\n"
				+"note with signature: 3"+"\n"
				+"note with title: 4"+"\n");

		int result = scan1.nextInt();
		switch(result){
		case(1):
			System.out.println("Enter note text:");
		String text = scan2.nextLine();
		Note note = new Note(date, text);
		request.setParam("addNote", note);				
		return request;
		case(2):
			System.out.println("Enter note text:");
		text = scan2.nextLine();
		System.out.println("Enter e-mail:");
		String email = scan2.nextLine();
		NoteWithEMail noteMail = new NoteWithEMail(date, text, email);
		request.setParam("addNote", noteMail);				
		return request;
		case(3):
			System.out.println("Enter note text:");
		text = scan2.nextLine();
		System.out.println("Enter signature:");
		String sig = scan2.nextLine();
		NoteWithSignature noteSign = new NoteWithSignature(date, text, sig);
		request.setParam("addNote", noteSign);				
		return request;
		case(4):
			System.out.println("Enter note text:");
		text = scan2.nextLine();
		System.out.println("Enter title:");
		String title = scan2.nextLine();
		NoteWithTitle noteTitle = new NoteWithTitle(date, text, title);
		request.setParam("addNote", noteTitle);				
		return request;
		default:
			System.out.println("Incorrect number");
			return null;
		}		
	}
	private Request prepareChangeParams(Scanner scan1, Scanner scan2, Request request){
		System.out.println("Enter note index:");
		int index = scan1.nextInt();
		System.out.println("Enter new note text:");
		String newText = scan2.nextLine();
		request.setParam("changeNote", index, newText);
		return request;
	}
	private Request prepareCloneParams(Scanner scan1, Scanner scan2, Request request){
		System.out.println("Enter note index:");
		int index = scan1.nextInt();
		request.setParam("cloneNote", index);
		return request;
	}
	private Request prepareDeleteAllParams(Scanner scan1, Scanner scan2, Request request){
		request.setParam("deteleAllNotes");
		return request;
	}
	private Request prepareDeleteParams(Scanner scan1, Scanner scan2, Request request){
		System.out.println("Enter note index:");
		int index = scan1.nextInt();
		request.setParam("deleteNote", index);
		return request;
	}
	private Request prepareFindParams(Scanner scan1, Scanner scan2, Request request) throws ParseException{
		System.out.println("You want to find by index or some text field or date?"+"\n"
				+"index: 1"+"\n"
				+"text: 2"+"\n"
				+"date: 3"+"\n");	
		int result = scan1.nextInt();
		switch(result){
		case(1):
			System.out.println("Enter index for search:");
		int index = scan1.nextInt();
		request.setParam("findNote", index);
		return request;

		case(2):
			System.out.println("Enter text for search:");
		String text = scan2.nextLine();
		request.setParam("findNote", text);
		return request;

		case(3):
			System.out.println("Enter date in ms for search in format dd.mm.yyyy:");
		String indexDate = scan2.nextLine();		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");
		Date dateFind = sdf.parse(indexDate);
		request.setParam("findNote", dateFind);
		return request;
		default:
			System.out.println("Incorrect number");
			return null;
		}
	}
	private Request prepareFormatParams(Scanner scan1, Scanner scan2, Request request){
		System.out.println("Enter index of note you want to format:");
		int index = scan1.nextInt();
		request.setParam("formatNote", index);
		return request;
	}
	private Request prepareReplaceParams(Scanner scan1, Scanner scan2, Request request) throws ParseException{
		Date date = setDate();
		System.out.println("Enter index of note you want to replace:");
		int index = scan1.nextInt();
		System.out.println("Enter text of new note:");
		String text = scan2.nextLine();
		Note newNote  = new Note(date, text);
		request.setParam("replaceNote", index, newNote);
		return request;
	}
	private Request prepareSortParams(Scanner scan1, Scanner scan2, Request request){
		request.setParam("sortNote");
		return request;
	}	
	private Date setDate() throws ParseException{
		Date date;
		System.out.println("Enter the date of note in format dd.mm.yyyy" );
		Scanner scan = new Scanner(System.in);
		String number = scan.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy");
		date = sdf.parse(number);
		return date;
	}
}
