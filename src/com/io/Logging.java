package com.io;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.card.Card;

public abstract class Logging {
	private static final Logger LOGGER = Logger.getLogger(Logging.class.getName());
	private Logging() throws UnsupportedOperationException {}
	public static void printToLog(String textToPrint) {
		LOGGER.log(Level.INFO, textToPrint);
	}
	
	public static void printToLog(List<Card> card) {
		printToLog(card.toString());
	}
}
