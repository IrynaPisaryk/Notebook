package com.epam.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.epam.notebook.Note;
import com.epam.dao.NotebookDAO;
import com.epam.logic.NotebookAdapter;
import com.epam.logic.comparator.NoteComparator;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.notebook.Notebook;

public final class NotebookMemoryImpl implements NotebookDAO {

	private Notebook notebook = NotebookAdapter.getInstance().getNotebook();

	@Override
	public Notebook addNote(Date date, String note) {
		Note newNote = new Note(date, note);
		notebook.setNote(newNote);
		return notebook;
	}

	@Override
	public Notebook addNoteWithEMail(Date date, String note, String email) {
		NoteWithEMail newMailNote = new NoteWithEMail(date, note, email);
		notebook.setNote(newMailNote);
		return notebook;
	}

	@Override
	public Notebook addNoteWithSignature(Date date, String note, String signature) {
		NoteWithSignature newSignatureNote = new NoteWithSignature(date, note,
				signature);
		notebook.setNote(newSignatureNote);
		return notebook;
	}

	@Override
	public Notebook addNoteWithTitle(Date date, String note, String title) {
		NoteWithTitle newTitleNote = new NoteWithTitle(date, note, title);
		notebook.setNote(newTitleNote);
		return notebook;

	}

	@Override
	public Notebook changeNote(int index, String newNote) {
		if (!notebook.getNote(index).getNote().equals(newNote)) {
			notebook.getNote(index).setNote(newNote);
		}
		return notebook;
	}

	@Override
	public Note cloneNote(int index) throws CloneNotSupportedException {
		notebook.setNote(notebook.getNote(index).clone());
		return notebook.getNote(index).clone();
	}

	@Override
	public Notebook deleteNote(int index) {
		notebook.deleteNote(index);
		return notebook;
	}
	
	@Override
	public Notebook deleteAllNotes() {
		notebook.deleteNotebook();
		return notebook;
	}

	@Override
	public Note findNoteByIndex(int index) {
		return notebook.getNote(index);
	}

	@Override
	public ArrayList<Note> findNoteByTitle(String title) {
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
		ArrayList<Note> arrayOfFoundNote = new ArrayList<Note>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getNote().equals(note)) {
				arrayOfFoundNote.add(notebook.getNote(i));
			}
		}
		return arrayOfFoundNote;
	}

	@Override
	public Notebook formatNote(int index) {
		Note newNote = notebook.getNote(index);
		if (newNote instanceof NoteWithEMail
				|| newNote instanceof NoteWithSignature
				|| newNote instanceof NoteWithTitle) {
			newNote = new Note(notebook.getNote(index).getDate(), notebook
					.getNote(index).getNote());
		}
		notebook.deleteNote(index);
		notebook.setNote(index, newNote);
		return notebook;
	}

	@Override
	public Notebook replaceNote(int indexOldNote, Note newNote) {
		notebook.deleteNote(indexOldNote);
		notebook.setNote(indexOldNote, newNote);
		return notebook;

	}

	@Override
	public Notebook sortNote() {
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notebook.getNotebook(), comparator);
		return notebook;
	}
}
