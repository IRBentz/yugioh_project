package com.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.card.Card;
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
import com.engine.PathAndNameEnums.ClassPath;
import com.engine.PathAndNameEnums.FileName;
import com.engine.PathAndNameEnums.FolderPath;

public abstract class Backendv4 {
	private static JSONObject jCardObject;
	private static Logger logger = Logger.getLogger(Backendv4.class.toString());

	private static void bindCardEffects() {
		try {
			for (Card card : Global.getCardDb()) {
				for (Path path : (Iterable<Path>) Files.list(
						FileSystems.getDefault().getPath(FolderPath.COM.path + FolderPath.EFFECT_DB.path))::iterator) {
					if (path.getFileName().toString().replace(".java", "").replace("0", " ").equals(card.getName())) {
						card.setBoundClass(Class.forName(
								FolderPath.EFFECT_DB.path + configurePathToClassName(path.getFileName())));
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void buildDB() {
		JSONArray jsonArray;
		Path filePath = FileSystems.getDefault().getPath(FolderPath.COM.path + FolderPath.JSON.path);
		logger.log(Level.INFO, () -> "Successfully found designated file path: \"" + filePath + "\"");
		try {
			jsonArray = new JSONArray(concatStringArray(Files.readAllLines(filePath.resolve(FileName.CARD_JSON.nameWithExtension))));
			logger.log(Level.INFO,
					() -> "Successfully found file \""
							+ filePath.resolve(FileName.CARD_JSON.nameWithExtension).getFileName()
							+ "\" at the following file path: \""
							+ filePath.resolve(FileName.CARD_JSON.nameWithExtension) + "\"");
		} catch (IOException e) {
			e.printStackTrace();
			jsonArray = new JSONArray();
		}
		for (Object cardGroup : jsonArray) {
			JSONObject jCardGroupObject = (JSONObject) cardGroup;
			switch (jCardGroupObject.getString(Json.CARD_TYPE.jkvName)) {
			case "monster":
				buildMonster(jCardGroupObject);
				break;
			case "pendulumMonster":
				buildPendulumMonster(jCardGroupObject);
				break;
			case "fusionMonster", "synchroMonster":
				buildFusionOrSynchroMonster(jCardGroupObject);
				break;
			case "xyzMonster":
				buildXyzMonster(jCardGroupObject);
				break;
			case "linkMonster":
				buildLinkMonster(jCardGroupObject);
				break;
			case "spell":
				buildSpell(jCardGroupObject);
				break;
			case "trap":
				buildTrap(jCardGroupObject);
				break;
			default:
				logger.log(Level.INFO, () -> "Skipped: " + jCardGroupObject.getString(Json.CARD_TYPE.jkvName));
				break;
			}
		}
		bindCardEffects();
	}

	private static void buildFusionOrSynchroMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new ExtraMonCard(jCardObject.getString(Json.NAME.jkvName),
					jCardObject.getInt(Json.INDEX.jkvName),
					stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_ATTRIBUTE.jkvName))
							.castTo(MonsterAttributeComponent.class),
					stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_TYPE.jkvName))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(Json.TYPE.jkvName))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(Json.SUMMON_REQUIREMENT.jkvName), jCardObject.getString(Json.LORE.jkvName),
					jCardObject.getInt(Json.LEVEL.jkvName), jCardObject.getInt(Json.ATTACK.jkvName),
					jCardObject.getInt(Json.DEFENSE.jkvName)));
		}
	}

	private static void buildLinkMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new LinkMonCard(jCardObject.getString(Json.NAME.jkvName),
					jCardObject.getInt(Json.INDEX.jkvName),
					stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_ATTRIBUTE.jkvName))
							.castTo(MonsterAttributeComponent.class),
					stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_TYPE.jkvName))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(Json.TYPE.jkvName))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(Json.SUMMON_REQUIREMENT.jkvName), jCardObject.getString(Json.LORE.jkvName),
					jCardObject.getInt(Json.LINK_RATING.jkvName), jCardObject.getInt(Json.ATTACK.jkvName),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(Json.LINK_ARROW.jkvName))
							.toArray(LinkArrowComponent[]::new)));
		}
	}

	private static void buildMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb()
					.add(new MonCard(jCardObject.getString(Json.NAME.jkvName), jCardObject.getInt(Json.INDEX.jkvName),
							stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_ATTRIBUTE.jkvName))
									.castTo(MonsterAttributeComponent.class),
							stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_TYPE.jkvName))
									.castTo(MonsterTypeComponent.class),
							stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(Json.TYPE.jkvName))
									.toArray(TypeComponent[]::new),
							jCardObject.getString(Json.LORE.jkvName), jCardObject.getInt(Json.LEVEL.jkvName),
							jCardObject.getInt(Json.ATTACK.jkvName), jCardObject.getInt(Json.DEFENSE.jkvName)));
		}
	}

	private static void buildPendulumMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb()
					.add(new PenMonCard(jCardObject.getString(Json.NAME.jkvName),
							jCardObject.getInt(Json.INDEX.jkvName),
							stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_ATTRIBUTE.jkvName))
									.castTo(MonsterAttributeComponent.class),
							stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_TYPE.jkvName))
									.castTo(MonsterTypeComponent.class),
							stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(Json.TYPE.jkvName))
									.toArray(TypeComponent[]::new),
							jCardObject.getString(Json.PENDULUM_LORE.jkvName), jCardObject.getString(Json.LORE.jkvName),
							jCardObject.getInt(Json.LEVEL.jkvName), jCardObject.getInt(Json.PENDULUM_LEVEL.jkvName),
							jCardObject.getInt(Json.ATTACK.jkvName), jCardObject.getInt(Json.DEFENSE.jkvName)));
		}
	}

	private static void buildSpell(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb()
					.add(new SpellCard(jCardObject.getString(Json.NAME.jkvName), jCardObject.getInt(Json.INDEX.jkvName),
							jCardObject.getString(Json.LORE.jkvName),
							stringToCardComponentInterface(jCardObject.getString(Json.ICON.jkvName))
									.castTo(IconComponent.class)));
		}
	}

	private static void buildTrap(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb()
					.add(new TrapCard(jCardObject.getString(Json.NAME.jkvName), jCardObject.getInt(Json.INDEX.jkvName),
							jCardObject.getString(Json.LORE.jkvName),
							stringToCardComponentInterface(jCardObject.getString(Json.ICON.jkvName))
									.castTo(IconComponent.class)));
		}
	}

	private static void buildXyzMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new XyzMonCard(jCardObject.getString(Json.NAME.jkvName),
					jCardObject.getInt(Json.INDEX.jkvName),
					stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_ATTRIBUTE.jkvName))
							.castTo((MonsterAttributeComponent.class)),
					stringToCardComponentInterface(jCardObject.getString(Json.MONSTER_TYPE.jkvName))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(Json.TYPE.jkvName))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(Json.SUMMON_REQUIREMENT.jkvName), jCardObject.getString(Json.LORE.jkvName),
					jCardObject.getInt(Json.RANK.jkvName), jCardObject.getInt(Json.ATTACK.jkvName),
					jCardObject.getInt(Json.DEFENSE.jkvName)));
		}
	}

	public static String concatStringArray(List<String> list) {
		StringBuilder string = new StringBuilder();
		for (String s : list)
			string.append(s);
		return string.toString();
	}

	public static String configurePathToClassName(Path pathToConfigure) {
		return pathToConfigure.toString().replace(".java", "");
	}

	public static CardComponentInterface stringToCardComponentInterface(String inputString) {
		try {
			for (CardComponent component : CardComponent.values())
				for (CardComponentInterface.SubInterface subcomponent : (CardComponentInterface.SubInterface[]) Class
						.forName(ClassPath.COMPONENT.path + component.name() + "Component").getEnumConstants())
					if (subcomponent.match(inputString) != null)
						return subcomponent.match(inputString);
		} catch (SecurityException | ClassNotFoundException e) {
			Logger.getLogger(Backendv4.class.getName()).log(Level.SEVERE, "An exception occured", e);
		}
		return CardComponentInterface.DEFAULT;
	}

	public static List<CardComponentInterface> stringToCardComponentInterfaceArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(stringToCardComponentInterface(String.class.cast(json))));
		return componentList;
	}

	private Backendv4() {
	}
}
