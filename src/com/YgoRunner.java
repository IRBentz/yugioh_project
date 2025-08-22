package com;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.engine.Backendv4;
import com.engine.Global;

public class YgoRunner {
	public static void main(String[] args) {
		Backendv4.buildDB();
		Logger.getGlobal().log(Level.INFO, Global.getCardDb()::toString);
	}
}
