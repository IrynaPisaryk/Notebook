package com.epam.view;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.epam.command.Request;
import com.epam.exception.ViewException;
import com.epam.notebook.Note;

public class ParametersConductor {

	private Scanner scan1 = new Scanner(System.in);
	private Scanner scan2 = new Scanner(System.in);
	
	public Request prepareAddParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		
		Date date = setDate(resourseMenu);
		System.out.println(resourseMenu.getString("addMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addNote", date, text);
		return request;
	}

	public Request prepareAddEMailParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		Date date = setDate(resourseMenu);
		System.out.println(resourseMenu.getString("addMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println(resourseMenu.getString("emailMenu"));
		String email = null;
		try {
			email = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addEMail", date, text, email);
		return request;

	}

	public Request prepareAddSignParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		Date date = setDate(resourseMenu);
		System.out.println(resourseMenu.getString("addMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println(resourseMenu.getString("signatureMenu"));
		String sig = null;
		try {
			sig = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addSign", date, text, sig);
		return request;
	}

	public Request prepareAddTitleParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		Date date = setDate(resourseMenu);
		System.out.println(resourseMenu.getString("addMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println(resourseMenu.getString("titleMenu"));
		String title = null;
		try {
			title = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("addTitle", date, text, title);
		return request;
	}

	public Request prepareChangeParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("addMenu"));
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println(resourseMenu.getString("addNoteMenu"));
		String newText = null;
		try {
			newText = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("changeNote", index, newText);
		return request;
	}

	public Request prepareCloneParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("indexMenu"));
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

	public Request prepareDeleteParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("indexMenu"));
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("deleteNote", index);
		return request;
	}

	public Request prepareFindParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchIndexMenu"));
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("find", index);
		return request;
	}

	public Request prepareFindEMailParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchEMailMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findEMail", text);
		return request;
	}

	public Request prepareFindSignParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchSignatureMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findSign", text);
		return request;
	}

	public Request prepareFindTitleParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchTitleMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findTitle", text);
		return request;
	}

	public Request prepareFindDateParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchDateMenu"));
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

	public Request prepareFindNoteParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchNoteMenu"));
		String text = null;
		try {
			text = scan2.nextLine();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("findNote", text);
		return request;
	}

	public Request prepareFormatParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		System.out.println(resourseMenu.getString("searchNoteMenu"));
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		request.setParam("formatNote", index);
		return request;
	}

	public Request prepareReplaceParams(Request request, ResourceBundle resourseMenu) throws ViewException {
		Date date = setDate(resourseMenu);
		System.out.println(resourseMenu.getString("replaceMenu"));
		int index = 0;
		try {
			index = scan1.nextInt();
		} catch (InputMismatchException e) {
			throw new ViewException();
		}
		System.out.println(resourseMenu.getString("replaceNewMenu"));
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

	private Date setDate(ResourceBundle resourseMenu) throws ViewException {
		Date date = null;
		System.out.println(resourseMenu.getString("setDate"));
		String number = scan2.nextLine();
		try {
			date = new Date(number);
		} catch (IllegalArgumentException e) {
			throw new ViewException();
		}
		return date;
	}

}
