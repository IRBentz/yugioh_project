package com.engine;

import static com.engine.Global.card_db;
import static com.engine.Global.fal_list;
import static com.engine.GlobalEnums.Fusion;
import static com.engine.GlobalEnums.Link;
import static com.engine.GlobalEnums.Monster;
import static com.engine.GlobalEnums.Pendulum;
import static com.engine.GlobalEnums.Spell;
import static com.engine.GlobalEnums.Synchro;
import static com.engine.GlobalEnums.Trap;
import static com.engine.GlobalEnums.Xyz;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.card.ExtraMonCard;
import com.card.LinkMonCard;
import com.card.MonAttribute;
import com.card.MonCard;
import com.card.MonType;
import com.card.PenMonCard;
import com.card.SpellCard;
import com.card.TrapCard;
import com.card.XyzMonCard;


public abstract class Backend_v3 {
	public static void buildDB(String pointerFileName) {
		Path pointerFilePath = FileSystems.getDefault().getPath("src//com//", "file_pointers_new.txt");
		try {
			ArrayList<String> importFile = new ArrayList<>(Files.readAllLines(pointerFilePath));
			println("Successfully found file \"" + pointerFilePath.getFileName() + "\" at the following file path: \""
					+ pointerFilePath + "\"");

			Path filePath = FileSystems.getDefault().getPath(importFile.getFirst());
			println("Successfully found designated file path: \"" + filePath + "\"");

			ArrayList<ArrayList<String>> importedFiles = new ArrayList<>();
			for (int i = 1; i < importFile.size() - 1; i++) {
				String fileLoc = importFile.get(i);
				importedFiles.add(new ArrayList<>(Files.readAllLines(filePath.resolve(fileLoc))));
				println("Successfully found file \"" + filePath.resolve(fileLoc).getFileName()
						+ "\" at the following file path: \"" + filePath.resolve(fileLoc) + "\"");
			}

			// * Monster
			ArrayList<String> currentFile = importedFiles.get(Monster.index);
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new MonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonAttribute) Utils.stringConvert(currentFile.get(i++)),
						(MonType) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++))));
			}

			// * Pendulum
			currentFile = importedFiles.get(Pendulum.index);
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new PenMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonAttribute) Utils.stringConvert(currentFile.get(i++)),
						(MonType) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}

			// *Fusion and Synchro
			for (GlobalEnums loc : new GlobalEnums[] {Fusion, Synchro}) {
				currentFile = importedFiles.get(loc.index);
				for (int i = 0; i < currentFile.size(); i++) {
					card_db.add(new ExtraMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
							(MonAttribute) Utils.stringConvert(currentFile.get(i++)),
							(MonType) Utils.stringConvert(currentFile.get(i++)),
							Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++),
							currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
							Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
				}
			}

			// * XYZ
			currentFile = importedFiles.get(Xyz.index);
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new XyzMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonAttribute) Utils.stringConvert(currentFile.get(i++)),
						(MonType) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++))));
			}

			// * Link
			currentFile = importedFiles.get(Link.index);
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new LinkMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonAttribute) Utils.stringConvert(currentFile.get(i++)),
						(MonType) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Utils.stringToLinkArrowArray(currentFile.get(i++))));
			}

			// * Spell
			currentFile = importedFiles.get(Spell.index);
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new SpellCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						currentFile.get(i++), Utils.stringToIcon(currentFile.get(i++))));
			}

			// * Trap
			currentFile = importedFiles.get(Trap.index);
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new TrapCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						currentFile.get(i++), Utils.stringToIcon(currentFile.get(i++))));
			}

			ArrayList<String> input_file = new ArrayList<>(Files.readAllLines(filePath.resolve(importFile.getLast())));
			println("Successfully found file \"" + filePath.getFileName() + "\" at the following file path: \""
					+ filePath + "\"");
			for (String pair : input_file) {
				String[] pairs = pair.split(" ");
				fal_list.add(new int[] { Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1]) });
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v3:\t%s", stringToPrint + "\n");
	}
}
