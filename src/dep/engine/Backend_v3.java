package dep.engine;

import static com.engine.PathAndNameEnums.ClassPathEnum.Component;
import static com.engine.PathAndNameEnums.FileNameEnum.FaL_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Fusion_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Link_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Monster_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Pendulum_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Spell_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Synchro_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Trap_info;
import static com.engine.PathAndNameEnums.FileNameEnum.Xyz_info;
import static com.engine.PathAndNameEnums.FilePathEnum.DepPath;
import static com.engine.PathAndNameEnums.FilePathEnum.InfoPath;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import com.card.ExtraMonCard;
import com.card.LinkMonCard;
import com.card.MonCard;
import com.card.PenMonCard;
import com.card.SpellCard;
import com.card.TrapCard;
import com.card.XyzMonCard;
import com.card.component.CardComponent;
import com.card.component.CardComponentInterface;
import com.card.component.IconComponent;
import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;
import com.engine.Global;
import com.engine.PathAndNameEnums.FileNameEnum;

public abstract class Backend_v3 {
	private static void assignFaL() {
		Global.getCardDb().forEach(card -> Global.getFalList().forEach(pair -> {
			if (card.getIndex() == pair[0]) {
				card.setAllowedCopies(pair[1]);
			}
		}));
	}
	@Deprecated
	public static void buildDB() {
		Path filePath = FileSystems.getDefault().getPath(DepPath.path + InfoPath.path);
		println("Successfully found designated file path: \"" + filePath + "\"");

		ArrayList<ArrayList<String>> importedFiles = new ArrayList<>();
		Arrays.asList(FileNameEnum.values()).forEach(file -> {
			try {
				if(file.name.contains("_info")) {
					importedFiles.add(new ArrayList<>(Files.readAllLines(filePath.resolve(file.name))));
					println("Successfully found file \"" + filePath.resolve(file.name).getFileName()
							+ "\" at the following file path: \"" + filePath.resolve(file.name) + "\"");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		// * Monster
		ArrayList<String> currentFile = importedFiles.get(Monster_info.ordinal());
		for (int i = 0; i < currentFile.size(); i++) {
			Global.getCardDb().add(new MonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					stringConvertCCI(currentFile.get(i++)).castTo((MonsterAttributeComponent.class)),
					stringConvertCCI(currentFile.get(i++)).castTo(MonsterTypeComponent.class),
					stringToCCIArrayList(currentFile.get(i++)).toArray(TypeComponent[]::new), currentFile.get(i++),
					Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
					Integer.parseInt(currentFile.get(i++))));
		}

		// * Pendulum
		currentFile = importedFiles.get(Pendulum_info.ordinal());
		for (int i = 0; i < currentFile.size(); i++) {
			Global.getCardDb().add(new PenMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					stringConvertCCI(currentFile.get(i++)).castTo((MonsterAttributeComponent.class)),
					stringConvertCCI(currentFile.get(i++)).castTo(MonsterTypeComponent.class),
					stringToCCIArrayList(currentFile.get(i++)).toArray(TypeComponent[]::new), currentFile.get(i++),
					currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++)),
					Integer.parseInt(currentFile.get(i++))));
		}

		// * Fusion and Synchro
		for (FileNameEnum loc : new FileNameEnum[] { Fusion_info, Synchro_info }) {
			currentFile = importedFiles.get(loc.ordinal());
			for (int i = 0; i < currentFile.size(); i++) {
				Global.getCardDb().add(new ExtraMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						stringConvertCCI(currentFile.get(i++)).castTo((MonsterAttributeComponent.class)),
						stringConvertCCI(currentFile.get(i++)).castTo(MonsterTypeComponent.class),
						stringToCCIArrayList(currentFile.get(i++)).toArray(TypeComponent[]::new), currentFile.get(i++),
						currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
						Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
			}
		}

		// * XYZ
		currentFile = importedFiles.get(Xyz_info.ordinal());
		for (int i = 0; i < currentFile.size(); i++) {
			Global.getCardDb().add(new XyzMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					stringConvertCCI(currentFile.get(i++)).castTo((MonsterAttributeComponent.class)),
					stringConvertCCI(currentFile.get(i++)).castTo(MonsterTypeComponent.class),
					stringToCCIArrayList(currentFile.get(i++)).toArray(TypeComponent[]::new), currentFile.get(i++),
					currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					Integer.parseInt(currentFile.get(i++)), Integer.parseInt(currentFile.get(i++))));
		}

		// * Link
		currentFile = importedFiles.get(Link_info.ordinal());
		for (int i = 0; i < currentFile.size(); i++) {
			Global.getCardDb().add(new LinkMonCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					stringConvertCCI(currentFile.get(i++)).castTo((MonsterAttributeComponent.class)),
					stringConvertCCI(currentFile.get(i++)).castTo(MonsterTypeComponent.class),
					stringToCCIArrayList(currentFile.get(i++)).toArray(TypeComponent[]::new), currentFile.get(i++),
					currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					Integer.parseInt(currentFile.get(i++)),
					stringToCCIArrayList(currentFile.get(i++)).toArray(LinkArrowComponent[]::new)));
		}

		// * Spell
		currentFile = importedFiles.get(Spell_info.ordinal());
		for (int i = 0; i < currentFile.size(); i++) {
			Global.getCardDb().add(new SpellCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)),
					currentFile.get(i++), stringConvertCCI(currentFile.get(i++)).castTo(IconComponent.class)));
		}

		// * Trap
		currentFile = importedFiles.get(Trap_info.ordinal());
		for (int i = 0; i < currentFile.size(); i++) {
			Global.getCardDb().add(new TrapCard(currentFile.get(i++), Integer.parseInt(currentFile.get(i++)), currentFile.get(i++),
					stringConvertCCI(currentFile.get(i++)).castTo(IconComponent.class)));
		}

		// * FaL
		currentFile = importedFiles.get(FaL_info.ordinal());
		for (String pair : currentFile) {
			String[] pairs = pair.split(" ");
			Global.getFalList().add(new int[] { Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1]) });
		}

		assignFaL();
	}

	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v3:\t%s", stringToPrint + "\n");
	}

	private static CardComponentInterface stringConvertCCI(String inputString) {
		try {
			for (CardComponent component : CardComponent.values())
				for (CardComponentInterface.SubInterface subcomponent : (CardComponentInterface.SubInterface[]) Class
						.forName(Component.path + component.name() + "Component").getEnumConstants())
					if (subcomponent.match(inputString) != null)
						return subcomponent.match(inputString);
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<CardComponentInterface> stringToCCIArrayList(String target_string) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		Arrays.asList(target_string.split(" "))
				.forEach(splitString -> componentList.add(stringConvertCCI(splitString)));
		return componentList;
	}
}
