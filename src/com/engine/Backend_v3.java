package com.engine;

import static com.engine.FileNameEnum.FaL;
import static com.engine.FileNameEnum.Fusion;
import static com.engine.FileNameEnum.Link;
import static com.engine.FileNameEnum.Monster;
import static com.engine.FileNameEnum.Pendulum;
import static com.engine.FileNameEnum.Spell;
import static com.engine.FileNameEnum.Synchro;
import static com.engine.FileNameEnum.Trap;
import static com.engine.FileNameEnum.Xyz;
import static com.engine.FilePathEnum.ComPath;
import static com.engine.FilePathEnum.InfoPath;
import static com.engine.Global.card_db;
import static com.engine.Global.fal_list;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.card.ExtraMonCard;
import com.card.LinkMonCard;
import com.card.MonCard;
import com.card.PenMonCard;
import com.card.SpellCard;
import com.card.TrapCard;
import com.card.XyzMonCard;
import com.card.component.IconComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;


public abstract class Backend_v3 {
	private static void assignFaL() {
		card_db.forEach(card -> fal_list.forEach(pair -> {
			if(card.getIndex() == pair[0]) {
				card.setAllowedCopies(pair[1]);
			}
		}));
	}

	public static void buildDB() {
		try {

			Path filePath = FileSystems.getDefault().getPath(ComPath.path + InfoPath.path);
			println("Successfully found designated file path: \"" + filePath + "\"");

			ArrayList<ArrayList<String>> importedFiles = new ArrayList<>();
			for (FileNameEnum file : FileNameEnum.values()) {
				importedFiles.add(new ArrayList<>(Files.readAllLines(filePath.resolve(file.name))));
				println("Successfully found file \"" + filePath.resolve(file.name).getFileName()
						+ "\" at the following file path: \"" + filePath.resolve(file.name) + "\"");
			}

			// * Monster
			ArrayList<String> currentFile = importedFiles.get(Monster.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new MonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonsterAttributeComponent) Utils.stringConvert(currentFile.get(i++)),
						(MonsterTypeComponent) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++))));
			}

			// * Pendulum
			currentFile = importedFiles.get(Pendulum.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new PenMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonsterAttributeComponent) Utils.stringConvert(currentFile.get(i++)),
						(MonsterTypeComponent) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}

			// *Fusion and Synchro
			for (FileNameEnum loc : new FileNameEnum[] {Fusion, Synchro}) {
				currentFile = importedFiles.get(loc.ordinal());
				for (int i = 0; i < currentFile.size(); i++) {
					card_db.add(new ExtraMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
							(MonsterAttributeComponent) Utils.stringConvert(currentFile.get(i++)),
							(MonsterTypeComponent) Utils.stringConvert(currentFile.get(i++)),
							Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++),
							currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
							Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
				}
			}

			// * XYZ
			currentFile = importedFiles.get(Xyz.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new XyzMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonsterAttributeComponent) Utils.stringConvert(currentFile.get(i++)),
						(MonsterTypeComponent) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++))));
			}

			// * Link
			currentFile = importedFiles.get(Link.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new LinkMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						(MonsterAttributeComponent) Utils.stringConvert(currentFile.get(i++)),
						(MonsterTypeComponent) Utils.stringConvert(currentFile.get(i++)),
						Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
						Utils.stringToLinkArrowArray(currentFile.get(i++))));
			}
			// * Spell
			currentFile = importedFiles.get(Spell.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new SpellCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						currentFile.get(i++), (IconComponent) Utils.stringConvert(currentFile.get(i++))));
			}

			// * Trap
			currentFile = importedFiles.get(Trap.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				card_db.add(new TrapCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						currentFile.get(i++), (IconComponent) Utils.stringConvert(currentFile.get(i++))));
			}

			currentFile = importedFiles.get(FaL.ordinal());
			for (String pair : currentFile) {
				String[] pairs = pair.split(" ");
				fal_list.add(new int[] { Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1]) });
			}
			
			assignFaL();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v3:\t%s", stringToPrint + "\n");
	}
}
