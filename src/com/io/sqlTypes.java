package com.io;

public enum sqlTypes {
	INTEGER(Integer.class), TEXT(String.class);

	private Class<?> dataType;

	sqlTypes(Class<?> clazz) {
		dataType = clazz;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	@Override
	public String toString() {
		return "[" + name() + ", " + dataType.getCanonicalName() + "]";
	}
}
