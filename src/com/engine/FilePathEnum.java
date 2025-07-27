package com.engine;

public enum FilePathEnum {
	ComPath("src//com//"),
	DepPath("src//dep//"),
	InfoPath("db//_info//"),
	JsonPath("db//_json//");
	public final String path;
	private FilePathEnum(String path) {
		this.path = path;
	}
}