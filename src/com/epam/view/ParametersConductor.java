package com.epam.view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.epam.command.Request;
import com.epam.exception.ViewException;
import com.epam.notebook.Note;

public class ParametersConductor {

	private Scanner scan1 = new Scanner(System.in);
	private Scanner scan2 = new Scanner(System.in);

	public Request prepareAddParams(Request request) throws ViewException {
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addNote", date, text);
		return request;
	}

	public Request prepareAddEMailParams(Request request) throws ViewException {
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println("Enter e-mail:");
		String email = null;
		try {
			email = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addEMail", date, text, email);
		return request;

	}

	public Request prepareAddSignParams(Request request) throws ViewException {
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println("Enter signature:");
		String sig = null;
		try {
			sig = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addSign", date, text, sig);
		return request;
	}

	public Request prepareAddTitleParams(Request request) throws ViewException {
		Date date = setDate();
		System.out.println("Enter note text:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println("Enter title:");
		String title = null;
		try {
			title = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addTitle", date, text, title);
		return request;
	}

	public Request prepareChangeParams(Request request) throws ViewException {
		System.out.println("Enter note index:");
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println("Enter new note text:");
		String newText = null;
		try {
			newText = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("changeNote", index, newText);
		return request;
	}

	public Request prepareCloneParams(Request request) throws ViewException {
		System.out.println("Enter note index:");
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("cloneNote", index);
		return request;
	}

	public Request prepareDeleteAllParams(Request request) {
		request.setParam("deteleAllNotes");
		return request;
	}

	public Request prepareDeleteParams(Request request) throws ViewException {
		System.out.println("Enter note index:");
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("deleteNote", index);
		return request;
	}

	public Request prepareFindParams(Request request) throws ViewException {
		System.out.println("Enter index for search:");
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("find", index);
		return request;
	}

	public Request prepareFindEMailParams(Request request) throws ViewException {
		System.out.println("Enter email for search:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findEMail", text);
		return request;
	}

	public Request prepareFindSignParams(Request request) throws ViewException {
		System.out.println("Enter signature for search:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findSign", text);
		return request;
	}

	public Request prepareFindTitleParams(Request request) throws ViewException {
		System.out.println("Enter title for search:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findTitle", text);
		return request;
	}

	public Request prepareFindDateParams(Request request) throws ViewException {
		System.out.println("Enter date for search in format dd.mm.yyyy:");
		String indexDate = null;
		try {
			indexDate = scan2.nextLine();	
			request.setParam("findDate", new Date(indexDate));
		} catch (InputMismatchException e) {
			throw new ViewException();
		} catch(IllegalArgumentException e){
			throw new ViewException();
		}
		return request;
	}

	public Request prepareFindNoteParams(Request request) throws ViewException {
		System.out.println("Enter note for search:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findNote", text);
		return request;
	}

	public Request prepareFormatParams(Request request) throws ViewException {
		System.out.println("Enter index of note you want to format:");
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("formatNote", index);
		return request;
	}

	public Request prepareReplaceParams(Request request) throws ViewException {
		Date date = setDate();
		System.out.println("Enter index of note you want to replace:");
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println("Enter text of new note:");
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		Note newNote = new Note(date, text);
		request.setParam("replaceNote", index, newNote);
		return request;
	}

	public Request prepareSortParams(Request request) {
		request.setParam("sortNote");
		return request;
	}

	private Date setDate() throws ViewException {
		Date date = null;
		System.out.println("Enter the date of note in format dd/mm/yyyy");
		String number = scan2.nextLine();
		try {
			date = new Date(number);
		} catch (IllegalArgumentException e) {
			throw new ViewException();
		}
		return date;
	}

}
