package com.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.json.JSONObject;

public class JsonFormatter extends Formatter {
	public static JSONObject formatRecord(LogRecord record) {
		JSONObject json = new JSONObject();
		json.put("level", record.getLevel().toString());
		json.put("message", record.getMessage());
		json.put("timestamp", record.getMillis());
		json.put("logger", record.getLoggerName());

		Throwable thrown = record.getThrown();
		if (thrown != null) {
			StringWriter sw = new StringWriter();
			thrown.printStackTrace(new PrintWriter(sw));
			json.put("error", sw.toString());
		}

		return json;
	}

	@Override
	public String format(LogRecord record) {
		return formatRecord(record).toString();
	}
}
