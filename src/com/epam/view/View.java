package com.epam.view;

import java.io.IOException;
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
		int result = scan.nextInt();
		//scan.close();
		return result;
	}

	public void run() throws IOException, CloneNotSupportedException{

		int whatDo = -1;
		while(whatDo != 0){
			whatDo = showMenu();
		Request request = prepareParams(whatDo);
		if(request == null){
			return;
		}
		CommandName name = CommandName.getType("add");
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
		Response response = manager.doRequest(name, request);
		printResponse(response);
		}
	}

	private void printResponse(Response response) {
		if(response.getNotes() != null){
			for(Note note : response.getNotes()){
				System.out.println(note.toString());
			}
		}

		else if(response.getNotebook().getNotebook() != null){
			for(Note note : response.getNotebook().getNotebook()){
				System.out.println(note.toString());
			}
		}

		else{
			System.out.println(response.getNote().toString());
		}
		
	}

	private Request prepareParams(int i) {

		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Date date = new Date();
		Request request = new Request();
		if(i == 1){
			System.out.println("What kind of note you want to add?"+"\n"
					+"just note: 1"+"\n"
					+"note with email: 2"+"\n"
					+"note with signature: 3"+"\n"
					+"note with title: 4"+"\n");
			int result = scan1.nextInt();
			if(result == 1){				
					System.out.println("Enter note text:");
					String text = scan2.nextLine();
					Note note = new Note(date, text);
					request.setParam("addNote", note);				
					return request;
			} else if(result == 2){
				System.out.println("Enter note text:");
				String text = scan2.nextLine();
				System.out.println("Enter e-mail:");
				String email = scan2.nextLine();
				NoteWithEMail note = new NoteWithEMail(date, text, email);
				request.setParam("addNote", note);				
				return request;
			}
			else if(result == 3){
				System.out.println("Enter note text:");
				String text = scan2.nextLine();
				System.out.println("Enter signature:");
				String sig = scan2.nextLine();
				NoteWithSignature note = new NoteWithSignature(date, text, sig);
				request.setParam("addNote", note);				
				return request;
			}
			else if(result == 4){
				System.out.println("Enter note text:");
				String text = scan2.nextLine();
				System.out.println("Enter title:");
				String title = scan2.nextLine();
				NoteWithTitle note = new NoteWithTitle(date, text, title);
				request.setParam("addNote", note);				
				return request;
			}
		}
		else if(i ==2){
			System.out.println("Enter note index:");
			int index = scan1.nextInt();
			System.out.println("Enter new note text:");
			String newText = scan2.nextLine();
			request.setParam("changeNote", index, newText);
			return request;
		}
		else if(i ==3){
			System.out.println("Enter note index:");
			int index = scan1.nextInt();
			request.setParam("cloneNote", index);
			return request;
		}

		else if(i ==4){
			request.setParam("deteleAllNotes");
			return request;
		}

		else if(i ==5){
			System.out.println("Enter note index:");
			int index = scan1.nextInt();
			request.setParam("deteleNote", index);
			return request;
		}

		else if(i ==6){
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
				System.out.println("Enter date in ms for search:");
			int indexDate = scan1.nextInt();
			Date dateFind = new Date(indexDate);
			request.setParam("findNote", dateFind);
			return request;
			}

		}

		else if(i ==7){
			System.out.println("Enter index of note you want to format:");
			int index = scan1.nextInt();
			request.setParam("formatNote", index);
			return request;
		}

		else if(i ==8){
			System.out.println("Enter index of note you want to replace:");
			int index = scan1.nextInt();
			System.out.println("Enter text of new note:");
			String text = scan2.nextLine();
			Note newNote  = new Note(date, text);
			request.setParam("replaceNote", index, newNote);
			return request;
		}
		else if(i ==9){
			request.setParam("sortNote");
			return request;
		}

		else if(i ==0 ){
			System.out.println("Bye");
			return null;
		}
		return null;

	}

}
