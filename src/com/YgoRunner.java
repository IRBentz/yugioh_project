package com;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.engine.Backendv4;
import com.engine.Global;
import com.logging.Logging;

public class YgoRunner {
	public static void main(String[] args) {
		Logging.setupLogging();
		Backendv4.buildDB();
		Logger.getGlobal().log(Level.FINE, Global.getCardDb()::toString);
	}
}
