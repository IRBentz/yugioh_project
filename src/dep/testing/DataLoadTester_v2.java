package dep.testing;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
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
import com.engine.Utils;

@Deprecated
public abstract class DataLoadTester_v2 {

	public static void main(String[] args) {
		DataLoadTester_v2.run();
	}

	public static void run() {
		Scanner pointerFileScanner;
		Path pointerFilePath = FileSystems.getDefault().getPath("src//com//", "file_pointers_new.txt");
		try {
			pointerFileScanner = new Scanner(pointerFilePath);
			System.out.println("Successfully found file \"" + pointerFilePath.getFileName()
					+ "\" at the following file path: \"" + pointerFilePath + "\"");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Path filePath = FileSystems.getDefault().getPath(pointerFileScanner.nextLine());
		System.out.println("Successfully found designated file path: \"" + filePath + "\"");

		ArrayList<Scanner> fileScanners = new ArrayList<>();
		int numberOfFiles = 8;
		for (int i = 0; i < numberOfFiles; i++) {
			try {
				String fileLoc = pointerFileScanner.nextLine();
				fileScanners.add(new Scanner(filePath.resolve(fileLoc)));
				System.out.println("Successfully found file \"" + filePath.resolve(fileLoc).getFileName()
						+ "\" at the following file path: \"" + filePath.resolve(fileLoc) + "\"");
			} catch (IOException e) {
				e.printStackTrace();
				pointerFileScanner.close();
				if (i != 0) {
					for (int j = 0; j < i; j++) {
						fileScanners.get(j).close();
					}
				}
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
			cards.add(new MonCard());
			input.nextLine();
			baseStats = null;
		}
		input.close();
		
		// * Pendulum
		input = fileScanners.get(1);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new PenMonCard());
			input.nextLine();
			baseStats = null;
		}
		input.close();
		// *Fusion and Synchro Monster
		for (int i = 2; i < 4; i++) {
			input = fileScanners.get(i);
			while (input.hasNextLine()) {
				baseStats = Utils.pullMonBaseStats(input);
				cards.add(new ExtraMonCard());
				input.nextLine();
				baseStats = null;
			}
			input.close();
		}
		// * XYZ
		input = fileScanners.get(4);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new XyzMonCard());
			input.nextLine();
			baseStats = null;
		}
		input.close();
		// * Link
		input = fileScanners.get(5);
		while (input.hasNextLine()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new LinkMonCard());
			input.nextLine();
			baseStats = null;
		}
		input.close();
		// * Spell
		input = fileScanners.get(6);
		while (input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			cards.add(new SpellCard());
			input.nextLine();
			baseStats = null;
		}
		input.close();
		// * Trap
		input = fileScanners.get(7);
		while (input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			cards.add(new TrapCard());
			input.nextLine();
			baseStats = null;
		}
		input.close();
		for (Card card : cards) {
			System.out.println(card);
		}
	}

}
