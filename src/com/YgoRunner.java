package com;

import com.engine.Backendv4;
import com.engine.Global;
import com.io.Logging;

public class YgoRunner {
	public static void main(String[] args) {
		Backendv4.buildDB();
		Logging.printToLog(Global.getCardDb());
	}
}