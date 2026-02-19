package com;

import com.engine.Backendv4;
import com.engine.DBBuilder;
import com.logging.builtin.Logging;

public class YgoRunner {
	public static void main(String[] args) {
		Logging.setupLogging();
		
		DBBuilder builder = new Backendv4(0);
		builder.buildDB();
	}
}
