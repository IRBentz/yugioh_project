package ygo_eng.testing;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import ygo_eng.card.Card;
import ygo_eng.card.ExtraMonCard;
import ygo_eng.card.LinkMonCard;
import ygo_eng.card.MonAttribute;
import ygo_eng.card.MonCard;
import ygo_eng.card.MonType;
import ygo_eng.card.PenMonCard;
import ygo_eng.card.SpellCard;
import ygo_eng.card.TrapCard;
import ygo_eng.card.XyzMonCard;
import ygo_eng.engine.Utils;

public abstract class DataLoadTester_v3 {
	
	public static void main(String[] args) {
		DataLoadTester_v3.run();
	}

	public static void run() {
		Path pointerFilePath = FileSystems.getDefault().getPath("src//ygo_eng//", "file_pointers_new.txt");
		ArrayList<Card> cards = new ArrayList<>();
		try {
			ArrayList<String> importFile = new ArrayList<>(Files.readAllLines(pointerFilePath));
			System.out.println("Successfully found file \"" + pointerFilePath.getFileName()
			+ "\" at the following file path: \"" + pointerFilePath + "\"");
			
			Path filePath = FileSystems.getDefault().getPath(importFile.getFirst());
			System.out.println("Successfully found designated file path: \"" + filePath + "\"");
			
			ArrayList<ArrayList<String>> importedFiles = new ArrayList<>();
			for(int i = 1; i < importFile.size() - 1; i++) {
				String fileLoc = importFile.get(i);
				importedFiles.add(new ArrayList<>(Files.readAllLines(filePath.resolve(fileLoc))));
				System.out.println("Successfully found file \"" + filePath.resolve(fileLoc).getFileName() + "\" at the following file path: \"" + filePath.resolve(fileLoc) + "\"");
			}
			
			// * Monster
			ArrayList<String> currentFile = importedFiles.getFirst();
			for(int i = 0; i < currentFile.size(); i++) {
				cards.add(new MonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
			
			// * Pendulum
			currentFile = importedFiles.get(1);
			for(int i = 0; i < currentFile.size(); i++) {
				cards.add(new PenMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
			
			// *Fusion and Synchro
			for (int i = 2; i < 4; i++) {
				currentFile = importedFiles.get(i);
				for(int ii = 0; ii < currentFile.size(); ii++) {
					cards.add(new ExtraMonCard(currentFile.get(ii++), Integer.parseInt(currentFile.get(ii++)), (MonAttribute) Utils.stringConvert(currentFile.get(ii++)), (MonType) Utils.stringConvert(currentFile.get(ii++)), Utils.stringToTypeArray(currentFile.get(ii++)), currentFile.get(ii++), currentFile.get(ii++), Integer.parseInt(currentFile.get(ii++)), Integer.parseInt(currentFile.get(ii++)), Integer.parseInt(currentFile.get(ii++))));
				}
			}
			
			// * XYZ
			currentFile = importedFiles.get(4);
			for (int i = 0; i < currentFile.size(); i++) {
				cards.add(new XyzMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
			
			// * Link
			currentFile = importedFiles.get(5);
			for (int i = 0; i < currentFile.size(); i++) {
				cards.add(new LinkMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), (MonAttribute) Utils.stringConvert(currentFile.get(i++)), (MonType) Utils.stringConvert(currentFile.get(i++)), Utils.stringToTypeArray(currentFile.get(i++)), currentFile.get(i++), currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)), Utils.stringToLinkArrowArray(currentFile.get(i++))));
			}
			
			// * Spell
			currentFile = importedFiles.get(6);
			for (int i = 0; i < currentFile.size(); i++) {
				cards.add(new SpellCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), currentFile.get(i++), Utils.stringToIcon(currentFile.get(i++))));
			}
			
			// * Trap
			currentFile = importedFiles.get(7);
			for (int i = 0; i < currentFile.size(); i++) {
				cards.add(new TrapCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), currentFile.get(i++), Utils.stringToIcon(currentFile.get(i++))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
