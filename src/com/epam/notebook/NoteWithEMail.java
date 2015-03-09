package com.epam.notebook;

import java.util.Date;

public final class NoteWithEMail extends Note {

	private String eMail;

	public NoteWithEMail(Date date, String note, String eMail) {
		super(date, note);
		this.eMail = eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getEMail() {
		return eMail;
	}

	@Override
	public int hashCode() {
		final int prime = 345;
		int result = super.hashCode();
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
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
		NoteWithEMail noteE = (NoteWithEMail) obj;

		if (!super.equals(noteE)) {
			return false;
		}
		if (eMail == null) {
			if (noteE.eMail != null) {
				return false;
			}
		} else if (!eMail.equals(noteE.eMail)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "NoteWithEMail" + "[date=" + (super.getDate().getYear()+1900) +"/"+(super.getDate().getMonth()+1)
				+"/"+super.getDate().getDate()+ "]" + "[note="
				+ super.getNote() + "]" + "[eMail=" + eMail + "]";
	}

}
