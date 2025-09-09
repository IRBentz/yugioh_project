package com.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {
	protected Logging() {}
	
	public static void setupLogging() {
		try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("src\\com\\logging\\logger.properties"));
		} catch (SecurityException | IOException e) {
			Logger.getGlobal().log(Level.SEVERE, "An exception has occured attempting to read logger.properties", e);
		}
	}

}
