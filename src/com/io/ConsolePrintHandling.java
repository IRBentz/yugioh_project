package com.io;

import java.util.Arrays;

import com.engine.Global;

public abstract class ConsolePrintHandling {
	private static int callIndex = 1;
	public static void println(Object... stringToPrint) {
		callIndex++;
		print_("%-" + Global.padding + "s%s%n", stringToPrint);
	}

	public static void print(Object... stringToPrint) {
		callIndex++;
		print_("%-" + Global.padding + "s%s", stringToPrint);
	}

	public static void print_(String format, Object... stringToPrint) {
		callIndex++;
		printf(format, stringToPrint);
	}

	public static void printf(String format, Object... stringToPrint) {
		callIndex++;
		try {
			System.out.printf(format, '[' + Class.forName(Thread.currentThread().getStackTrace()[callIndex].getClassName()).getSimpleName() + ']',
					new StringBuilder(Arrays.asList(stringToPrint).toString()).replace(0, 1, "").reverse().replace(0, 1, "")
							.reverse().toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		callIndex = 1;
	}
}
