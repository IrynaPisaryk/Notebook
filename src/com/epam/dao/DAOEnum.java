package com.epam.dao;

public enum DAOEnum {

	USING_MEMORY("memory"), USING_FILE("file");

	private String typeValue;

	private DAOEnum(String type) {
		typeValue = type;
	}

	static public DAOEnum getType(String pType) {
		for (DAOEnum type : DAOEnum.values()) {
			if (type.getTypeValue().equals(pType)) {
				return type;
			}
		}
		return null;
	}

	public String getTypeValue() {
		return typeValue;
	}

}
