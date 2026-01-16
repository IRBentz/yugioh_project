package com.logging.builtin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.json.JSONObject;

public class JsonStreamFileHandler extends Handler {
	private static final int MAX_LOG_FILES = 10;
	private static final Path LOG_DIR = Paths.get("com/logging/logs");
	private static final Path INDEX_FILE = LOG_DIR.resolve(".log_index");

	private BufferedWriter writer;
	private boolean firstEntry = true;
	private final int logIndex;

	public JsonStreamFileHandler() {
		try {
			Files.createDirectories(LOG_DIR);

			int idx = loadIndex();
			logIndex = idx;
			persistIndex(nextIndex(idx));
			
			File logFile = LOG_DIR.resolve("javaLog-" + logIndex + ".json").toFile();
			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write("[\n");

		} catch (IOException e) {
			reportError("Failed to initialize JsonStreamFileHandler", e, ErrorManager.OPEN_FAILURE);
			throw new IllegalStateException(e);
		}
	}

	private int loadIndex() {
		try {
			if (Files.exists(INDEX_FILE)) {
				String text = Files.readString(INDEX_FILE, StandardCharsets.UTF_8).trim();
				int i = Integer.parseInt(text);
				if (i >= 1 && i <= MAX_LOG_FILES)
					return i;
			}
		} catch (IOException | NumberFormatException e) {
			reportError("Failed to load log index", e, ErrorManager.GENERIC_FAILURE);
		}
		return 1;
	}

	private void persistIndex(int next) {
		try {
			Files.writeString(INDEX_FILE, Integer.toString(next), StandardCharsets.UTF_8);
		} catch (IOException e) {
			reportError("Failed to persist log index", e, ErrorManager.WRITE_FAILURE);
		}
	}

	private int nextIndex(int current) {
		return current % MAX_LOG_FILES + 1;
	}

	@Override
	public synchronized void publish(LogRecord recordToLog) {
		if (!isLoggable(recordToLog))
			return;

		try {
			JSONObject json = JsonFormatter.formatRecord(recordToLog);
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
		try {
			writer.flush();
		} catch (IOException e) {
			reportError("Flush failed", e, ErrorManager.FLUSH_FAILURE);
		}
	}

	@Override
	public void close() {
		try {
			writer.write("\n]\n");
			writer.close();
		} catch (IOException e) {
			reportError("Failed to close log file", e, ErrorManager.CLOSE_FAILURE);
		}
	}
}
