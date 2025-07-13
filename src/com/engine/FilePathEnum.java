package com.engine;

public enum FilePathEnum {
	ComPath("src//com//"),
	InfoPath("db//_info//");
	public final String path;
	private FilePathEnum(String path) {
		this.path = path;
	}
}