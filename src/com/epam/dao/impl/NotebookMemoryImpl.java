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

	public Notebook getNotebook(){
		return notebook;
	}
	
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
	public ArrayList<Integer> findNoteByTitle(String title) {
		ArrayList<Integer> indexOfFoundNote = new ArrayList<Integer>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithTitle) {
				NoteWithTitle noteWithTitle = (NoteWithTitle) notebook
						.getNote(i);
				if (noteWithTitle.getTitle().equals(title)) {
					indexOfFoundNote.add(i);
				}
			}
		}
		return indexOfFoundNote;
	}

	@Override
	public ArrayList<Integer> findNoteBySignature(String signature) {
		ArrayList<Integer> indexOfFoundNote = new ArrayList<Integer>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithSignature) {
				NoteWithSignature noteWithSignature = (NoteWithSignature) notebook
						.getNote(i);
				if (noteWithSignature.getSignature().equals(signature)) {
					indexOfFoundNote.add(i);
				}
			}
		}
		return indexOfFoundNote;
	}

	@Override
	public ArrayList<Integer> findNoteByEMail(String email) {
		ArrayList<Integer> indexOfFoundNote = new ArrayList<Integer>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i) instanceof NoteWithEMail) {
				NoteWithEMail noteWithEMail = (NoteWithEMail) notebook
						.getNote(i);
				if (noteWithEMail.getEMail().equals(email)) {
					indexOfFoundNote.add(i);
				}
			}
		}
		return indexOfFoundNote;
	}

	@Override
	public ArrayList<Integer> findNoteByDate(Date date) {
		ArrayList<Integer> indexOfFoundNote = new ArrayList<Integer>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getDate().equals(date)) {
				indexOfFoundNote.add(i);
			}
		}
		return indexOfFoundNote;
	}

	@Override
	public ArrayList<Integer> findNoteByNote(String note) {
		ArrayList<Integer> indexOfFoundNote = new ArrayList<Integer>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getNote().equals(note)) {
				indexOfFoundNote.add(i);
			}
		}
		return indexOfFoundNote;
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
