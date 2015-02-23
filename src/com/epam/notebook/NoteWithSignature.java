package com.epam.notebook;

import java.util.Date;

public final class NoteWithSignature extends Note {

	private static final long serialVersionUID = 1L;
	private String signature;

	public NoteWithSignature(Date date, String note, String signature) {
		super(date, note);
		this.signature = signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSignature() {
		return signature;
	}

	@Override
	public int hashCode() {
		final int prime = 345;
		int result = super.hashCode();
		result = prime * result
				+ ((signature == null) ? 0 : signature.hashCode());
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

		NoteWithSignature noteSig = (NoteWithSignature) obj;

		if (!super.equals(noteSig))
			return false;

		if (signature == null) {
			if (noteSig.signature != null) {
				return false;
			}
		} else if (!signature.equals(noteSig.signature)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "NoteWithSignature" + "[date=" + super.getDate() + "]"
				+ "[note=" + super.getNote() + "]" + "[signature=" + signature
				+ "]";
	}
}
