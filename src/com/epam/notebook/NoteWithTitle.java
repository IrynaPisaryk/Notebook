package com.epam.notebook;
import java.util.Date;

public final class NoteWithTitle extends Note {

	private static final long serialVersionUID = 1L;
	private String title;

	public NoteWithTitle(Date date, String note, String title) {
		super(date, note);
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		final int prime = 345;
		int result = super.hashCode();
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NoteWithTitle noteTitle = (NoteWithTitle) obj;

		if (!super.equals(noteTitle)) {
			return false;
		}
		if (title == null) {
			if (noteTitle.title != null) {
				return false;
			}
		} else if (!title.equals(noteTitle.title)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "NoteWithTitle" + "[date=" + super.getDate().getYear()+"/"+super.getDate().getMonth()+"/"+super.getDate().getDay() + "]" + "[note="
				+ super.getNote() + "]" + "[title=" + title + "]";
	}

}
