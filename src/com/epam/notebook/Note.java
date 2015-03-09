package com.epam.notebook;

import java.util.Date;

public class Note implements Cloneable{

	private Date date;
	private String note;
	

	public Note(Date date, String note) {
		this.date = date;
		this.note = note;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	@Override
	public int hashCode() {
		final int prime = 345;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
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

		Note notes = (Note) obj;

		if (date == null) {
			if (notes.date != null) {
				return false;
			}
		} else if (!date.equals(notes.date)) {
			return false;
		}
		if (note == null) {
			if (notes.note != null) {
				return false;
			}
		} else if (!note.equals(notes.note)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Note[date=" + (date.getYear()+1900) +"/"+(date.getMonth()+1)+"/"+date.getDate()+"]"+ "[note=" + note + "]";
	}	

	public Note clone() throws CloneNotSupportedException {
		
		Note obj = null;		
		try {
			obj = (Note) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new CloneNotSupportedException();
		}
		if(null != this.date){
			obj.date = (Date) this.date.clone();
		}
		return obj;
		
	}
}