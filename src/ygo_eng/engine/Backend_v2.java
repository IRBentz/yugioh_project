package ygo_eng.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import ygo_eng.card.ExtraMonCard;
import ygo_eng.card.LinkMonCard;
import ygo_eng.card.MonAttribute;
import ygo_eng.card.MonCard;
import ygo_eng.card.MonType;
import ygo_eng.card.PenMonCard;
import ygo_eng.card.SpellCard;
import ygo_eng.card.TrapCard;
import ygo_eng.card.XyzMonCard;

public abstract class Backend_v2 {
	public static void buildDB(String pointerFileName) {
		println("Using Back-end V2.");
		Path pointerFilePath = FileSystems.getDefault().getPath("src//ygo_eng//", "file_pointers_new.txt");
		try {
			ArrayList<String> importFile = new ArrayList<>(Files.readAllLines(pointerFilePath));
			println("Successfully found file \"" + pointerFilePath.getFileName()
			+ "\" at the following file path: \"" + pointerFilePath + "\"");
			
			Path filePath = FileSystems.getDefault().getPath(importFile.getFirst());
			println("Successfully found designated file path: \"" + filePath + "\"");
			
			ArrayList<ArrayList<String>> importedFiles = new ArrayList<>();
			for(int i = 1; i < importFile.size() - 1; i++) {
				String fileLoc = importFile.get(i);
				importedFiles.add(new ArrayList<>(Files.readAllLines(filePath.resolve(fileLoc))));
				println("Successfully found file \"" + filePath.resolve(fileLoc).getFileName() + "\" at the following file path: \"" + filePath.resolve(fileLoc) + "\"");
			}
			
			// * Monster
			ArrayList<String> currentFile = importedFiles.getFirst();
			for(int i = 0; i < currentFile.size(); i++) {
				Global.card_db.add(new MonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
			
			// * Pendulum
			currentFile = importedFiles.get(1);
			for(int i = 0; i < currentFile.size(); i++) {
				Global.card_db.add(new PenMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
			
			// *Fusion and Synchro
			for (int i = 2; i < 4; i++) {
				currentFile = importedFiles.get(i);
				for(int ii = 0; ii < currentFile.size(); ii++) {
					Global.card_db.add(new ExtraMonCard(currentFile.get(ii++), Integer.parseInt(currentFile.get(ii++)), (MonAttribute) Utils.stringConvert(currentFile.get(ii++)), (MonType) Utils.stringConvert(currentFile.get(ii++)), Utils.stringToTypeArray(currentFile.get(ii++)), currentFile.get(ii++), currentFile.get(ii++), Integer.parseInt(currentFile.get(ii++)), Integer.parseInt(currentFile.get(ii++)), Integer.parseInt(currentFile.get(ii++))));
				}
			}
			
			// * XYZ
			currentFile = importedFiles.get(4);
			for (int i = 0; i < currentFile.size(); i++) {
				Global.card_db.add(new XyzMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
			
			// * Link
			currentFile = importedFiles.get(5);
			for (int i = 0; i < currentFile.size(); i++) {
				Global.card_db.add(new LinkMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Utils.stringToLinkArrowArray(currentFile.get(i++))));
			}
			
			// * Spell
			currentFile = importedFiles.get(6);
			for (int i = 0; i < currentFile.size(); i++) {
				Global.card_db.add(new SpellCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), currentFile.get(i++), Utils.stringToIcon(currentFile.get(i++))));
			}
			
			// * Trap
			currentFile = importedFiles.get(7);
			for (int i = 0; i < currentFile.size(); i++) {
				Global.card_db.add(new TrapCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), currentFile.get(i++), Utils.stringToIcon(currentFile.get(i++))));
			}
			buildFaL(filePath.resolve(importFile.getLast()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void buildFaL(Path filePath) {
		try {
			ArrayList<String> input_file = new ArrayList<>(Files.readAllLines(filePath));
			println("Successfully found file \"" + filePath.getFileName() + "\" at the following file path: \""
					+ filePath + "\"");
			for(String pair : input_file) {
				String[] pairs = pair.split(" ");
				Global.fal_list.add(new int[] {Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1])});
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v2:\t%s", stringToPrint + "\n");
	}
}
