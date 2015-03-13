package com.epam.view;

import java.util.ArrayList;
import com.epam.command.Response;
import com.epam.exception.NotebookException;
import com.epam.exception.ViewException;
import com.epam.logic.NotebookAdapter;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public class Printer {

	public void printResponse(String key, Response response)
			throws ViewException {

		Notebook notebook = NotebookAdapter.getInstance().getNotebook();

		try {
			System.out.println("Notebook: ");
			if (!(notebook.getNotebook().isEmpty())) {
				for (Note i : notebook.getNotebook()) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println("Empty");
			}
			System.out.println("\n");
			if (response.getParam(key) instanceof Note) {
				System.out.println("Your note: ");
				Note note = (Note) response.getParam(key);
				System.out.println(note.toString());
				System.out.println("\n");
			} else if (response.getParam(key) instanceof ArrayList) {
				System.out.println("Found notes: ");
				ArrayList<Note> notes = (ArrayList<Note>) response.getParam(key);
				for (int i = 0; i < notes.size(); i++) {
					System.out.println(notes.get(i).toString());
				}
				System.out.println("\n");
			}
		} catch (NotebookException e) {
			throw new ViewException();
		} catch (NullPointerException e) {
			throw new ViewException();
		}

	}
}
