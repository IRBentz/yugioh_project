package dep.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import com.card.ExtraMonCard;
import com.card.LinkMonCard;
import com.card.MonCard;
import com.card.PenMonCard;
import com.card.SpellCard;
import com.card.TrapCard;
import com.card.XyzMonCard;
import com.engine.Global;

@Deprecated
public class Backend_v2 {
	public static void buildDB(ArrayList<Scanner> fileScanners) {
		// TODO document why this method is empty
	}
	
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
		@SuppressWarnings("unused")
		Object[] baseStats;
		int ttl_count = 0;
		int cur_count = 0;
		//
		// * Monster
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			Global.getCardDb().add(new MonCard());
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
			Global.getCardDb().add(new PenMonCard());
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
				Global.getCardDb().add(new ExtraMonCard());
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
			Global.getCardDb().add(new XyzMonCard());
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
			Global.getCardDb().add(new LinkMonCard());
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
			Global.getCardDb().add(new SpellCard());
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
			Global.getCardDb().add(new TrapCard());
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
			Global.getFalList().add(new int[] { input_file.nextInt(), input_file.nextInt() });
		}
		input_file.close();
	}
	
	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v2:\t%s", stringToPrint + "\n");
	}
}
