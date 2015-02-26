package com.epam.command;

public enum CommandName {

	ADD("add"),
	DETETE("delete"), 
	DELETE_ALL("delete_all"),
	FIND("find"), 
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
