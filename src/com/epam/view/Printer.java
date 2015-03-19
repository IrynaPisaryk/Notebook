package com.epam.view;

import java.util.ArrayList;
import java.util.ResourceBundle;

import com.epam.command.Response;
import com.epam.exception.NotebookException;
import com.epam.exception.ViewException;
import com.epam.logic.NotebookAdapter;
import com.epam.notebook.Note;
import com.epam.notebook.Notebook;

public class Printer {

	public void printResponse(String key, Response response, ResourceBundle resourseMenu)
			throws ViewException {

		Notebook notebook = NotebookAdapter.getInstance().getNotebook();

		try {
			System.out.println(resourseMenu.getString("notebook"));
			if (!(notebook.getNotebook().isEmpty())) {
				for (Note i : notebook.getNotebook()) {
					System.out.println(i.toString());
				}
			} else {
				System.out.println(resourseMenu.getString("empty"));
			}
			System.out.println("\n");
			if (response.getParam(key) instanceof Note) {
				System.out.println(resourseMenu.getString("note"));
				Note note = (Note) response.getParam(key);
				System.out.println(note.toString());
				System.out.println("\n");
			} else if (response.getParam(key) instanceof ArrayList) {
				System.out.println(resourseMenu.getString("foundNotes"));
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
