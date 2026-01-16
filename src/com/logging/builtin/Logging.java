package com.logging.builtin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {
	public static void setupLogging() {
		try  {
			LogManager.getLogManager().readConfiguration(new FileInputStream("src/logging.properties"));
		} catch (SecurityException | IOException e) {
			Logger.getGlobal().log(Level.SEVERE, "An exception has occured attempting to read logger.properties", e);
		}
	}

	protected Logging() {
	}

}
