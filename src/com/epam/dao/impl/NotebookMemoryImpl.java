package com.epam.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.epam.notebook.Note;
import com.epam.dao.INotebookDAO;
import com.epam.logic.NotebookAdapter;
import com.epam.logic.comparator.NoteComparator;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.notebook.Notebook;

public final class NotebookMemoryImpl implements INotebookDAO {

	private Notebook notebook = NotebookAdapter.getInstance().getNotebook();

	@Override
	public void addNote(Date date, String note) {
		Note newNote = new Note(date, note);
		notebook.setNote(newNote);
	}

	@Override
	public void addNoteWithEMail(Date date, String note, String email) {
		NoteWithEMail newMailNote = new NoteWithEMail(date, note, email);
		notebook.setNote(newMailNote);
	}

	@Override
	public void addNoteWithSignature(Date date, String note, String signature) {
		NoteWithSignature newSignatureNote = new NoteWithSignature(date, note,
				signature);
		notebook.setNote(newSignatureNote);
	}

	@Override
	public void addNoteWithTitle(Date date, String note, String title) {
		NoteWithTitle newTitleNote = new NoteWithTitle(date, note, title);
		notebook.setNote(newTitleNote);

	}

	@Override
	public void changeNote(int index, String newNote) {
		if (!notebook.getNote(index).getNote().equals(newNote)) {
			notebook.getNote(index).setNote(newNote);
		}
	}

	@Override
	public Note cloneNote(int index) throws CloneNotSupportedException {
		notebook.setNote(notebook.getNote(index).clone());
		return notebook.getNote(index).clone();
	}

	@Override
	public void deleteNote(int index) {
		notebook.deleteNote(index);
	}
	
	@Override
	public void deleteAllNotes() {
		notebook.deleteNotebook();
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
	public void formatNote(int index) {
		Note newNote = notebook.getNote(index);
		if (newNote instanceof NoteWithEMail
				|| newNote instanceof NoteWithSignature
				|| newNote instanceof NoteWithTitle) {
			newNote = new Note(notebook.getNote(index).getDate(), notebook
					.getNote(index).getNote());
		}
		notebook.deleteNote(index);
		notebook.setNote(index, newNote);
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote) {
		notebook.deleteNote(indexOldNote);
		notebook.setNote(indexOldNote, newNote);

	}

	@Override
	public void sortNote() {
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notebook.getNotebook(), comparator);
	}
}
