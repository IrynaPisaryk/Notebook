package com.epam.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.epam.dao.NotebookDAO;
import com.epam.logic.NotebookAdapter;
import com.epam.logic.NotebookIO;
import com.epam.logic.comparator.NoteComparator;
import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.notebook.Notebook;

public final class NotebookFileImpl implements NotebookDAO{

	private Notebook notebook = NotebookAdapter.getInstance().getNotebook();
	NotebookIO io = new NotebookIO();	


	{
		try {
			io.writeNotebookIntoFile(notebook);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Notebook addNote(Date date, String note) throws IOException {
		notebook = io.readNotebookFromFile();
		Note newNote = new Note(date, note);
		notebook.setNote(newNote);
		io.writeNotebookIntoFile(notebook);
		return notebook;

	}

	@Override
	public Notebook addNoteWithEMail(Date date, String note, String email) throws IOException {
		notebook = io.readNotebookFromFile();
		NoteWithEMail newMailNote = new NoteWithEMail(date, note, email);
		notebook.setNote(newMailNote);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Notebook addNoteWithSignature(Date date, String note, String signature) throws IOException {
		notebook = io.readNotebookFromFile();
		NoteWithSignature newSignatureNote = new NoteWithSignature(date, note,
				signature);
		notebook.setNote(newSignatureNote);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Notebook addNoteWithTitle(Date date, String note, String title) throws IOException {
		notebook = io.readNotebookFromFile();
		NoteWithTitle newTitleNote = new NoteWithTitle(date, note, title);
		notebook.setNote(newTitleNote);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Notebook changeNote(int index, String newNote) throws IOException {
		notebook = io.readNotebookFromFile();
		if (notebook.getNote(index).getNote() != newNote) {
			notebook.getNote(index).setNote(newNote);
		}
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Note cloneNote(int index) throws CloneNotSupportedException {
		return notebook.getNote(index).clone();
	}

	@Override
	public Notebook deleteNote(int index) throws IOException {
		notebook = io.readNotebookFromFile();
		notebook.deleteNote(index);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Note findNoteByIndex(int index) {
		notebook = io.readNotebookFromFile();
		return notebook.getNote(index);
	}

	@Override
	public ArrayList<Note> findNoteByTitle(String title) {
		notebook = io.readNotebookFromFile();
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithTitle) {
				NoteWithTitle noteWithTitle = (NoteWithTitle) notebook
						.getNote(i);
				if (noteWithTitle.getTitle().equals(title)) {
					arrayOfFoundNote.add(noteWithTitle);
				}
			}
		}
		return arrayOfFoundNote;
	}

	@Override
	public ArrayList<Note> findNoteBySignature(String signature) {
		notebook = io.readNotebookFromFile();
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithSignature) {
				NoteWithSignature noteWithSignature = (NoteWithSignature) notebook
						.getNote(i);
				if (noteWithSignature.getSignature().equals(signature)) {
					arrayOfFoundNote.add(noteWithSignature);
				}
			}
		}
		return arrayOfFoundNote;
	}

	@Override
	public ArrayList<Note> findNoteByEMail(String email) {
		notebook = io.readNotebookFromFile();
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithEMail) {
				NoteWithEMail noteWithEMail = (NoteWithEMail) notebook
						.getNote(i);
				if (noteWithEMail.getEMail().equals(email)) {
					arrayOfFoundNote.add(noteWithEMail);
				}
			}
		}
		return arrayOfFoundNote;
	}

	@Override
	public ArrayList<Note> findNoteByDate(Date date) {
		notebook = io.readNotebookFromFile();
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getDate().equals(date)) {
				arrayOfFoundNote.add(notebook.getNote(i));
			}
		}
		return arrayOfFoundNote;
	}

	@Override
	public ArrayList<Note> findNoteByNote(String note) {
		notebook = io.readNotebookFromFile();
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getNote().equals(note)) {
				arrayOfFoundNote.add(notebook.getNote(i));
			}
		}
		return arrayOfFoundNote;
	}

	@Override
	public Notebook formatNote(int index) throws IOException {
		notebook = io.readNotebookFromFile();
		Note newNote = notebook.getNote(index);
		if (newNote instanceof NoteWithEMail
				|| newNote instanceof NoteWithSignature
				|| newNote instanceof NoteWithTitle) {
			newNote = new Note(notebook.getNote(index).getDate(), notebook
					.getNote(index).getNote());
		}
		notebook.deleteNote(index);
		notebook.setNote(index, newNote);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Notebook replaceNote(int indexOldNote, Note newNote) throws IOException {
		notebook = io.readNotebookFromFile();
		notebook.deleteNote(indexOldNote);
		notebook.setNote(indexOldNote, newNote);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Notebook sortNote() throws IOException {
		notebook = io.readNotebookFromFile();
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notebook.getNotebook(), comparator);
		io.writeNotebookIntoFile(notebook);
		return notebook;
	}

	@Override
	public Notebook deleteAllNotes() throws IOException {
		notebook = io.readNotebookFromFile();
		notebook.deleteNotebook();
		io.writeNotebookIntoFile(notebook);
		return notebook;		
	}

}
