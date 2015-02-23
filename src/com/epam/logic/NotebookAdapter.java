package com.epam.logic;

import com.epam.notebook.Notebook;

public final class NotebookAdapter {

	private static final NotebookAdapter instance = new NotebookAdapter();
	private Notebook noteBook = new Notebook();

	public static NotebookAdapter getInstance() {
		return instance;
	}

	public Notebook getNotebook() {
		return noteBook;
	}
}
