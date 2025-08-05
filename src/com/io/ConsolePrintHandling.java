package com.io;


import java.util.Arrays;

import com.engine.Global;

public abstract class ConsolePrintHandling {
	private static int callIndex = 1;
	private static String prevCallClass = "";
	
	private ConsolePrintHandling() {}
	
	public static void println(Object... stringToPrint) {
		callIndex++;
		printfa("%-" + Global.padding + "s%s%n", stringToPrint);
	}

	public static void print(Object... stringToPrint) {
		callIndex++;
		printfa("%-" + Global.padding + "s%s", stringToPrint);
	}

	public static void printfa(String format, Object... stringToPrint) {
		callIndex++;
		printf(format, stringToPrint);
	}

	public static void printf(String format, Object... stringToPrint) {
		callIndex++;
		String callHeader1 = "";
		try {
			callHeader1 = '[' + Class.forName(Thread.currentThread().getStackTrace()[callIndex].getClassName()).getSimpleName().strip() + ']';
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(prevCallClass.equals(callHeader1)) {
			callHeader1 = "|";
		}
		prevCallClass = callHeader1;
		System.out.printf(format, callHeader1,
				new StringBuilder(Arrays.asList(stringToPrint).toString()).replace(0, 1, "").reverse()
						.replace(0, 1, "").reverse().toString()).toString();
		callIndex = 1;
	}
}
