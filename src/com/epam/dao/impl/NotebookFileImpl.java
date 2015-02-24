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
	public void addNote(Date date, String note) throws IOException {
		notebook = io.readNotebookFromFile();
		Note newNote = new Note(date, note);
		notebook.setNote(newNote);
		io.writeNotebookIntoFile(notebook);

	}

	@Override
	public void addNoteWithEMail(Date date, String note, String email) throws IOException {
		notebook = io.readNotebookFromFile();
		NoteWithEMail newMailNote = new NoteWithEMail(date, note, email);
		notebook.setNote(newMailNote);
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public void addNoteWithSignature(Date date, String note, String signature) throws IOException {
		notebook = io.readNotebookFromFile();
		NoteWithSignature newSignatureNote = new NoteWithSignature(date, note,
				signature);
		notebook.setNote(newSignatureNote);
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public void addNoteWithTitle(Date date, String note, String title) throws IOException {
		notebook = io.readNotebookFromFile();
		NoteWithTitle newTitleNote = new NoteWithTitle(date, note, title);
		notebook.setNote(newTitleNote);
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public void changeNote(int index, String newNote) throws IOException {
		notebook = io.readNotebookFromFile();
		if (notebook.getNote(index).getNote() != newNote) {
			notebook.getNote(index).setNote(newNote);
		}
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public Note cloneNote(int index) throws CloneNotSupportedException {
		return notebook.getNote(index).clone();
	}

	@Override
	public void deleteNote(int index) throws IOException {
		notebook = io.readNotebookFromFile();
		notebook.deleteNote(index);
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public Note findNoteByIndex(int index) {
		notebook = io.readNotebookFromFile();
		return notebook.getNote(index);
	}

	@Override
	public ArrayList<Integer> findNoteByTitle(String title) {
		notebook = io.readNotebookFromFile();
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
		notebook = io.readNotebookFromFile();
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
		notebook = io.readNotebookFromFile();
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
		notebook = io.readNotebookFromFile();
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
		notebook = io.readNotebookFromFile();
		ArrayList<Integer> indexOfFoundNote = new ArrayList<Integer>();
		for (int i = 0; i < notebook.getNotebook().size(); i++) {
			if (notebook.getNote(i).getNote().equals(note)) {
				indexOfFoundNote.add(i);
			}
		}
		return indexOfFoundNote;
	}

	@Override
	public void formatNote(int index) throws IOException {
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
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote) throws IOException {
		notebook = io.readNotebookFromFile();
		notebook.deleteNote(indexOldNote);
		notebook.setNote(indexOldNote, newNote);
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public void sortNote() throws IOException {
		notebook = io.readNotebookFromFile();
		NoteComparator comparator = new NoteComparator();
		Collections.sort(notebook.getNotebook(), comparator);
		io.writeNotebookIntoFile(notebook);
	}

	@Override
	public void deleteAllNotes() throws IOException {
		notebook = io.readNotebookFromFile();
		notebook.deleteNotebook();
		io.writeNotebookIntoFile(notebook);		
	}

}
