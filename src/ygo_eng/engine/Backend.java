package ygo_eng.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import ygo_eng.card.Card;
import ygo_eng.card.ExtraMonCard;
import ygo_eng.card.Icon;
import ygo_eng.card.LinkMonCard;
import ygo_eng.card.MonAttribute;
import ygo_eng.card.MonCard;
import ygo_eng.card.MonType;
import ygo_eng.card.PenMonCard;
import ygo_eng.card.SpellCard;
import ygo_eng.card.TrapCard;
import ygo_eng.card.Type;
import ygo_eng.card.XyzMonCard;

public abstract class Backend {
	private static void assignFaL() {
		int num_assigned = 0;
		for (Card card : Global.card_db)
			for (int[] pair : Global.fal_list)
				if (card.getIndex() == pair[0]) {
					card.setAllowedCopies(pair[1]);
					num_assigned++;
				}
		println("Successfully assigned " + num_assigned + " cards their max allowed copies.");
	}

	private static void buildDB_v1(String pointerFileName) {
		switch (Global.back_ver) {
		case 1:
			println("Using Back-end v1.1");
			grabFileScanners_v1(pointerFileName + "file_pointers_new.txt");
			return;
		case 2:
			println("Using Back-end v1.2");
			grabFileScanners_v2(pointerFileName + "file_pointers_new.txt");
			return;
		case 3:
			Backend_v2.buildDB(pointerFileName + "file_pointers_new.txt");
			return;
		default:
			println("Using Back-end v1.0");
			pointerFileName += "file_pointers.txt";
		}
		Scanner pointerFileScanner;
		try {
			pointerFileScanner = new Scanner(new File(pointerFileName));
			println("Found file at: " + new File(pointerFileName).getPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		String filePath = pointerFileScanner.nextLine();
		println("Successfully found designated file path at: " + filePath.replace("//", "\\"));

		ArrayList<Scanner> fileScanners = new ArrayList<>();
		int numberOfFiles = 8;
		for (int i = 0; i < numberOfFiles; i++) {
			try {
				String fileLoc = filePath + pointerFileScanner.nextLine();
				println("Successfully found Target file: " + fileLoc.replace("//", "\\"));
				fileScanners.add(new Scanner(new File(fileLoc)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				pointerFileScanner.close();
				return;
			}
		}

		/*
		 * for(Scanner curScanner : fileScanners) { curScanner.useDelimiter(" ;");
		 * println(curScanner.toString() +
		 * curScanner.delimiter().toString()); }
		 */

		Scanner currScanner = fileScanners.get(0);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			Global.card_db.add(new MonCard((String) ((Object[]) returnedList[0])[0], (Integer) ((Object[]) returnedList[0])[1],
					(MonAttribute) returnedList[1], (MonType) returnedList[2], (Type[]) returnedList[3],
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
					(Integer) returnedList[6]));
		}

		currScanner = fileScanners.get(1);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			Global.card_db.add(new PenMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
					(MonType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], currScanner.nextInt(),
					(Integer) returnedList[5], (Integer) returnedList[6]));
		}

		currScanner = fileScanners.get(2);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			Global.card_db.add(new ExtraMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
					(MonType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
					(Integer) returnedList[6]));
		}

		currScanner = fileScanners.get(3);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			Global.card_db.add(new ExtraMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
					(MonType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
					(Integer) returnedList[6]));
		}

		currScanner = fileScanners.get(4);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			Global.card_db.add(
					new XyzMonCard((String) ((Object[]) returnedList[0])[0], (Integer) ((Object[]) returnedList[0])[1],
							(MonAttribute) returnedList[1], (MonType) returnedList[2], (Type[]) returnedList[3],
							Utils.pullNextTextBlock(currScanner, ";"), (String) ((Object[]) returnedList[0])[2],
							(Integer) returnedList[4], (Integer) returnedList[5], (Integer) returnedList[6]));
		}

		currScanner = fileScanners.get(5);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			Global.card_db.add(new LinkMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
					(MonType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[5], (Integer) returnedList[6],
					Utils.pullNextLinkArrowBlock(currScanner, ";")));
		}

		currScanner = fileScanners.get(6);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullSTBaseStats(currScanner, ";");

			Global.card_db.add(
					new SpellCard((String) ((Object[]) returnedList[0])[0], (Integer) ((Object[]) returnedList[0])[1],
							(String) ((Object[]) returnedList[0])[2], (Icon) returnedList[1]));
		}

		currScanner = fileScanners.get(7);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullSTBaseStats(currScanner, ";");

			Global.card_db.add(
					new TrapCard((String) ((Object[]) returnedList[0])[0], (Integer) ((Object[]) returnedList[0])[1],
							(String) ((Object[]) returnedList[0])[2], (Icon) returnedList[1]));
		}

		buildFaL_v1(pointerFileScanner.nextLine());

		pointerFileScanner.close();
		for (Scanner scanner : fileScanners) {
			scanner.close();
		}
		/**
		 * Scanner input_file; try { input_file = new Scanner(new File(fileName)); }
		 * catch (FileNotFoundException e) { e.printStackTrace(); return; }
		 * println("Successfully found file at: " + new
		 * File(fileName).getPath()); window.println("Successfully found file at: " +
		 * new File(fileName).getPath());
		 *
		 * while (input_file.hasNext()) { String type = input_file.next();
		 *
		 * Object[] returnedList = null;
		 *
		 * switch (type) { case "mon": returnedList = pullMonBaseStats(input_file, ";");
		 *
		 * card_db.add(new MonCard((String) ((Object[]) returnedList[0])[0], (Integer)
		 * ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1], (MonType)
		 * returnedList[2], (Type[]) returnedList[3], (String) ((Object[])
		 * returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
		 * (Integer) returnedList[6])); break; case "fus": case "syn": returnedList =
		 * pullMonBaseStats(input_file, ";");
		 *
		 * card_db.add(new ExtraMonCard((String) ((Object[]) returnedList[0])[0],
		 * (Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
		 * (MonType) returnedList[2], (Type[]) returnedList[3],
		 * pullNextTextBlock(input_file, ";"), (String) ((Object[]) returnedList[0])[2],
		 * (Integer) returnedList[4], (Integer) returnedList[5], (Integer)
		 * returnedList[6])); break; case "xyz": returnedList =
		 * pullMonBaseStats(input_file, ";");
		 *
		 * card_db.add(new XyzMonCard((String) ((Object[]) returnedList[0])[0],
		 * (Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
		 * (MonType) returnedList[2], (Type[]) returnedList[3],
		 * pullNextTextBlock(input_file, ";"), (String) ((Object[]) returnedList[0])[2],
		 * (Integer) returnedList[4], (Integer) returnedList[5], (Integer)
		 * returnedList[6])); break; case "pen": returnedList =
		 * pullMonBaseStats(input_file, ";");
		 *
		 * card_db.add(new PenMonCard((String) ((Object[]) returnedList[0])[0],
		 * (Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
		 * (MonType) returnedList[2], (Type[]) returnedList[3],
		 * pullNextTextBlock(input_file, ";"), (String) ((Object[]) returnedList[0])[2],
		 * (Integer) returnedList[4], input_file.nextInt(), (Integer) returnedList[5],
		 * (Integer) returnedList[6])); break; case "lnk": returnedList =
		 * pullMonBaseStats(input_file, ";");
		 *
		 * card_db.add(new LinkMonCard((String) ((Object[]) returnedList[0])[0],
		 * (Integer) ((Object[]) returnedList[0])[1], (MonAttribute) returnedList[1],
		 * (MonType) returnedList[2], (Type[]) returnedList[3],
		 * pullNextTextBlock(input_file, ";"), (String) ((Object[]) returnedList[0])[2],
		 * (Integer) returnedList[5], (Integer) returnedList[6], (linkArrow[])
		 * pullNextLinkArrowBlock(input_file, ";"))); break; case "spl": returnedList =
		 * pullSTBaseStats(input_file, ";");
		 *
		 * card_db.add(new SpellCard((String) ((Object[]) returnedList[0])[0], (Integer)
		 * ((Object[]) returnedList[0])[1], (String) ((Object[]) returnedList[0])[2],
		 * (Icon) returnedList[1])); break; case "trp": returnedList =
		 * pullSTBaseStats(input_file, ";");
		 *
		 * card_db.add(new TrapCard((String) ((Object[]) returnedList[0])[0], (Integer)
		 * ((Object[]) returnedList[0])[1], (String) ((Object[]) returnedList[0])[2],
		 * (Icon) returnedList[1])); break; default: new Error("Type: " + type + " not
		 * found.").printStackTrace(); break; } } input_file.close();
		 **/
	}


	private static void buildDB_v2(ArrayList<Scanner> fileScanners) {

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

	private static void buildFaL_v1(String fileName) {
		Scanner input_file;
		try {
			input_file = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		println("Successfully found file at: " + new File(fileName).getPath());
		// window.println("Successfully found file at: " + new
		// File(fileName).getPath());
		while (input_file.hasNext()) {
			Global.fal_list.add(new int[] { input_file.nextInt(), input_file.nextInt() });
		}
		input_file.close();
	}

	private static void buildFaL_v2(Path filePath) {
		Scanner input_file;
		try {
			input_file = new Scanner(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		println("Successfully found file \"" + filePath.getFileName() + "\" at the following file path: \""
				+ filePath + "\"");
		// window.println("Successfully found file \"" +
		// filePath.resolve(fileName).getFileName() + "\" at the following file path:
		// \"" + filePath.resolve(fileName) + "\"");
		while (input_file.hasNext()) {
			Global.fal_list.add(new int[] { input_file.nextInt(), input_file.nextInt() });
		}
		input_file.close();
	}

	private static void debugCheck() {
		Global.card_db.sort(Comparator.comparing(Card::getAllowedCopies));
		// Arrays.stream(card_db.toArray(Card[]::new)).forEach(card ->
		// println(card));

		// Arrays.stream(card_db.toArray(Card[]::new)).forEach(card ->
		// window.println(card.toString() + "\n"));
	}

	private static void grabFileScanners_v1(String pointerFileName) {
		Scanner pointerFileScanner;
		ArrayList<Scanner> fileScanners = new ArrayList<>();
		try {
			pointerFileScanner = new Scanner(new File(pointerFileName));
			println("Found file at: " + new File(pointerFileName).getPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		String filePath = pointerFileScanner.nextLine();
		println("Successfully found designated file path at: " + filePath.replace("//", "\\"));

		int numberOfFiles = 8;
		for (int i = 0; i < numberOfFiles; i++) {
			try {
				String fileLoc = filePath + pointerFileScanner.nextLine();
				println("Successfully found Target file: " + fileLoc.replace("//", "\\"));
				fileScanners.add(new Scanner(new File(fileLoc)));

			} catch (FileNotFoundException e) {
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
		buildFaL_v1(pointerFileScanner.nextLine());
		pointerFileScanner.close();
		buildDB_v2(fileScanners);
	}

	private static void grabFileScanners_v2(String pointerFileName) {
		Scanner pointerFileScanner;
		ArrayList<Scanner> fileScanners = new ArrayList<>();
		Path pointerFilePath = FileSystems.getDefault().getPath("src//ygo_eng//", "file_pointers_new.txt");
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
		buildFaL_v2(filePath.resolve(pointerFileScanner.nextLine()));
		pointerFileScanner.close();
		buildDB_v2(fileScanners);
	}
	
	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v1:\t%s", stringToPrint + "\n");
	}
	
	public static Card askUserSelection(ArrayList<Card> selectionList) {
		String inputText = "";
		int i = 0;
		for(Card card : selectionList)
			inputText += "\t" + Integer.toString(i++) + card.getName() + "\n";
		Character slotNumber = ' ';
		while(!Character.isDigit(slotNumber))
			slotNumber = Utils.askUser("Select 1 of the following cards: " + inputText);

		return selectionList.get(Integer.parseInt(slotNumber.toString()));
	}

	public static void start(String pointerFileName) {
		buildDB_v1(pointerFileName);
		assignFaL();
		debugCheck();
	}
}
