package com;

public class YgoRunner {
	public static void main(String[] args) {
		com.logging.builtin.Logging.setupLogging();
		
		com.engine.DBBuilder builder = new com.engine.Backendv4(0);
		builder.buildDB();
	}
}
