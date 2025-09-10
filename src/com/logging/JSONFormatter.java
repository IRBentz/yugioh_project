package com.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.json.JSONObject;
import org.json.JSONArray;

public class JSONFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		JSONObject json = new JSONObject();
        json.put("timestamp", record.getMillis());
        json.put("level", record.getLevel().getName());
        json.put("loggerName", record.getLoggerName());
        if(formatMessage(record).startsWith(" ", 0))
        	json.put("JSONArray", new JSONArray(formatMessage(record)));
        else
        	json.put("message", formatMessage(record));
        
        if (record.getThrown() != null) {
            json.put("exception", record.getThrown().toString());
        }
        return json.toString() + System.lineSeparator();
	}
	
}
