package com.logging.builtin;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.json.JSONObject;

public class JsonFormatter extends Formatter {

	protected JsonFormatter() {
	}

	public static JSONObject formatRecord(LogRecord logRecord) {
		JSONObject jsonObject = new JSONObject();
        
        // Add standard log record fields
        jsonObject.put("timestamp", logRecord.getMillis());
        jsonObject.put("level", logRecord.getLevel().getName());
        jsonObject.put("message", logRecord.getMessage());

        // Handle the exception (Throwable)
        Throwable thrown = logRecord.getThrown();
        if (thrown != null) {
            String stacktrace = getStackTraceAsString(thrown);
            // Add the full stack trace as a single string value to the JSON object
            jsonObject.put("stacktrace", stacktrace); 
            jsonObject.put("exception_type", thrown.getClass().getName());
        }

        return jsonObject;
	}

    private static String getStackTraceAsString(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw); 
        return sw.toString().replace(System.lineSeparator(), " | "); 
    }

	@Override
	public String format(LogRecord logRecord) {
		return formatRecord(logRecord).toString();
	}

}
