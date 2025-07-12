package com.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import com.card.ExtraMonCard;
import com.card.Icon;
import com.card.LinkMonCard;
import com.card.MonAttribute;
import com.card.MonCard;
import com.card.MonType;
import com.card.PenMonCard;
import com.card.SpellCard;
import com.card.TrapCard;
import com.card.Type;
import com.card.XyzMonCard;

public class Backend_v2 {
	public static void buildDB(String pointerFileName) {
		Scanner pointerFileScanner;
		ArrayList<Scanner> fileScanners = new ArrayList<>();
		Path pointerFilePath = FileSystems.getDefault().getPath("src//com//", "file_pointers_new.txt");
		try {
			pointerFileScanner = new Scanner(pointerFilePath);
			println("Successfully found file \"" + pointerFilePath.getFileName()
					+ "\" at the following file path: \"" + pointerFilePath + "\"");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Path filePath = FileSystems.getDefault().getPath(pointerFileScanner.nextLine());
		println("Successfully found designated file path: \"" + filePath + "\"");

		int numberOfFiles = 8;
		for (int i = 0; i < numberOfFiles; i++) {
			try {
				String fileLoc = pointerFileScanner.nextLine();
				fileScanners.add(new Scanner(filePath.resolve(fileLoc)));
				println("Successfully found file \"" + filePath.resolve(fileLoc).getFileName()
						+ "\" at the following file path: \"" + filePath.resolve(fileLoc) + "\"");
			} catch (IOException e) {
				e.printStackTrace();
				pointerFileScanner.close();
				if (i != 0) {
					for (Scanner scanner : fileScanners) {
						scanner.close();
					}
				}
				return;
			}
		}
		buildFaL(filePath.resolve(pointerFileScanner.nextLine()));
		pointerFileScanner.close();
		
		Scanner input = fileScanners.get(0);
		Object[] baseStats;
		int ttl_count = 0;
		int cur_count = 0;
		//
		// * Monster
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			Global.card_db.add(new MonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Integer.parseInt(input.nextLine())));
			input.nextLine();
			baseStats = null;
			cur_count++;
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		//
		// * Pendulum
		input = fileScanners.get(1);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			Global.card_db.add(new PenMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine())));
			input.nextLine();
			baseStats = null;
			cur_count++;
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		//
		// *Fusion and Synchro Monster
		for (int i = 2; i < 4; i++) {
			input = fileScanners.get(i);
			while (input.hasNextLine()) {
				baseStats = Utils.pullMonBaseStats(input);
				Global.card_db.add(new ExtraMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
						(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
						input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
						Integer.parseInt(input.nextLine())));
				input.nextLine();
				baseStats = null;
				cur_count++;
			}
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		//
		// * XYZ
		input = fileScanners.get(4);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			Global.card_db.add(new XyzMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Integer.parseInt(input.nextLine())));
			input.nextLine();
			baseStats = null;
			cur_count++;
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		//
		// * Link
		input = fileScanners.get(5);
		while (input.hasNextLine()) {
			baseStats = Utils.pullMonBaseStats(input);
			Global.card_db.add(new LinkMonCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(MonAttribute) baseStats[1], (MonType) baseStats[2], (Type[]) baseStats[3], input.nextLine(),
					input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()),
					Utils.pullNextLinkArrowBlock(input)));
			input.nextLine();
			baseStats = null;
			cur_count++;
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		//
		// * Spell
		input = fileScanners.get(6);
		while (input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			Global.card_db.add(new SpellCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(String) baseStats[1], (Icon) baseStats[2]));
			input.nextLine();
			baseStats = null;
			cur_count++;
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		//
		// * Trap
		input = fileScanners.get(7);
		while (input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			Global.card_db.add(new TrapCard((String) ((Object[]) baseStats[0])[0], (int) ((Object[]) baseStats[0])[1],
					(String) baseStats[1], (Icon) baseStats[2]));
			input.nextLine();
			baseStats = null;
			cur_count++;
		}
		input.close();
		ttl_count += cur_count;
		println("Created " + cur_count + " cards.");
		cur_count = 0;
		println("Created " + ttl_count + " cards in total.");
	}
	
	public static void buildDB(ArrayList<Scanner> fileScanners) {
		
	}
	
	private static void buildFaL(Path filePath) {
		Scanner input_file;
		try {
			input_file = new Scanner(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		println("Successfully found file \"" + filePath.getFileName() + "\" at the following file path: \""
				+ filePath + "\"");
		while (input_file.hasNext()) {
			Global.fal_list.add(new int[] { input_file.nextInt(), input_file.nextInt() });
		}
		input_file.close();
	}
	
	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v2:\t%s", stringToPrint + "\n");
	}
}
