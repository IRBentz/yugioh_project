package com.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

import org.json.JSONObject;

public class JsonStreamFileHandler extends Handler {
	private BufferedWriter writer;
	private boolean firstEntry = true;
	private File file;

	public JsonStreamFileHandler() {
		System.out.println("Initiating");
		String filename = LogManager.getLogManager().getProperty(getClass().getName() + ".filename");
		if (filename == null)
			filename = "logs.json";
		file = new File(filename);

		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("[\n");
		} catch (IOException e) {
			reportError("Failed to open log file", e, ErrorManager.OPEN_FAILURE);
		}
	}

	@Override
	public void publish(LogRecord record) {
		System.out.println("publishing");
		if (!isLoggable(record))
			return;

		JSONObject json = JsonFormatter.formatRecord(record);

		try {
			if (!firstEntry)
				writer.write(",\n");
			writer.write(json.toString(2));
			firstEntry = false;
		} catch (IOException e) {
			reportError("Failed to write log entry", e, ErrorManager.WRITE_FAILURE);
		}
	}

	@Override
	public void flush() {
		System.out.println("flushing");
		try {
			writer.flush();
		} catch (IOException e) {
			reportError("Flush failed", e, ErrorManager.FLUSH_FAILURE);
		}
	}

	@Override
	public void close() throws SecurityException {
		System.out.println("closing");
		try {
			writer.write("\n]\n");
			writer.close();
		} catch (IOException e) {
			reportError("Failed to close log file", e, ErrorManager.CLOSE_FAILURE);
		}
	}
}
