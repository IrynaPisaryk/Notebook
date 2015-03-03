package com.epam.command;

public enum CommandName {

	ADD("add"),
	ADD_EMAIL_NOTE("addEMail"),
	ADD_SIGN_NOTE("addSign"),
	ADD_TITLE_NOTE("addTitle"),
	DETETE("delete"), 
	DELETE_ALL("delete_all"),
	FIND("find"), 
	FIND_BY_EMAIL("findEMail"),
	FIND_BY_TITLE("findTitle"),
	FIND_BY_SIGN("findSign"),
	FIND_BY_DATE("findDate"),
	FIND_BY_NOTE("findNote"),
	CHANGE("change"),
	SORT("sort"),
	REPLACE("replace"),
	CLONE("clone"),
	FORMAT("format");	
	
	private String typeValue;

	private CommandName(String type) {
		typeValue = type;
	}

	static public CommandName getType(String pType) {
		for (CommandName type: CommandName.values()) {
			if (type.getTypeValue().equals(pType)) {
				return type;
			}
		}
		throw new RuntimeException("unknown type");
	}

	public String getTypeValue() {
		return typeValue;
	}
}
