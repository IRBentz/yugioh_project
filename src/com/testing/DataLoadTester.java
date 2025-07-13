package com.testing;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.card.Card;
import com.card.ExtraMonCard;
import com.card.LinkMonCard;
import com.card.MonCard;
import com.card.PenMonCard;
import com.card.SpellCard;
import com.card.TrapCard;
import com.card.XyzMonCard;
import com.card.enums.Icon;
import com.card.enums.MonAttribute;
import com.card.enums.MonType;
import com.card.enums.Type;
import com.engine.Utils;

public abstract class DataLoadTester {
	public static void main(String[] args) {
		DataLoadTester.run();
	}

	public static void run() {
		Scanner pointerFileScanner;
		try {
			pointerFileScanner = new Scanner(new File("src//com//file_pointers_new.txt"));
			System.out.println("Found file at: " + new File("src//com//file_pointers_new.txt").getPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		String filePath = pointerFileScanner.nextLine();
		System.out.println("Successfully found designated file path at: " + filePath.replace("//", "\\"));

		ArrayList<Scanner> fileScanners = new ArrayList<>();
		int numberOfFiles = 8;
		for (int i = 0; i < numberOfFiles; i++) {
			try {
				String fileLoc = filePath + pointerFileScanner.nextLine();
				System.out.println("Successfully found Target file: " + fileLoc.replace("//", "\\"));
				fileScanners.add(new Scanner(new File(fileLoc)));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				pointerFileScanner.close();
				return;
			}
		}
		pointerFileScanner.close();

		Scanner input = fileScanners.get(0);
		ArrayList<Card> cards = new ArrayList<>();
		Object[] baseStats;
		// * Monster
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new MonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Integer.parseInt(input.nextLine())));
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		// * Pendulum
		input = fileScanners.get(1);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new PenMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine())));
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		// *Fusion and Synchro Monster
		for (int i = 2; i < 4; i++) {
			input = fileScanners.get(i);
			while (input.hasNextLine()) {
				baseStats = Utils.pullMonBaseStats(input);
				cards.add(new ExtraMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
						(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
						input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
						Integer.parseInt(input.nextLine())));
				input.nextLine();
				baseStats = null;
			}
		}
		input.close();
		
		// * XYZ
		input = fileScanners.get(4);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new XyzMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Integer.parseInt(input.nextLine())));
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		// * Link
		input = fileScanners.get(5);
		while (input.hasNextLine()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new LinkMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Utils.pullNextLinkArrowBlock(input)));
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		// * Spell
		input = fileScanners.get(6);
		while (input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			cards.add(new SpellCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(String) baseStats[1], (Icon) baseStats[2]));
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		// * Trap
		input = fileScanners.get(7);
		while (input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			cards.add(new TrapCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(String) baseStats[1], (Icon) baseStats[2]));
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		for (Card card : cards) {
			System.out.println(card);
		}
	}

}
*/