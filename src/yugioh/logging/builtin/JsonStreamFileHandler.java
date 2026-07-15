package yugioh.logging.builtin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.json.JSONObject;

public class JsonStreamFileHandler extends Handler {
	private static final Path LOG_DIR = Paths.get("com/logging/logs");

	private BufferedWriter writer;
	private boolean firstEntry = true;

	public JsonStreamFileHandler() {
		try {
			Files.createDirectories(LOG_DIR);
			
			File logFile = LOG_DIR.resolve("javaLog_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".json").toFile();
			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write("[\n");

		} catch (IOException e) {
			reportError("Failed to initialize JsonStreamFileHandler", e, ErrorManager.OPEN_FAILURE);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public synchronized void publish(LogRecord recordToLog) {
		if (!isLoggable(recordToLog))
			return;

		try {
			JSONObject json = JsonFormatter.formatRecord(recordToLog);
			if (!firstEntry)
				writer.write(",\n");
			String prepass = json.toString();
			String postpass = prepass;
			while (prepass.contains("\\\\") || prepass.contains("/")) {
				prepass = prepass.replace("\\\\", "\\");
				prepass = prepass.replace("/", "\\");
				postpass = prepass;
			}
			writer.write(postpass);
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
