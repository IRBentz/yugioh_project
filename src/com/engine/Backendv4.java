package com.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.card.Card;
import com.card.MonsterCard;
import com.card.SpellTrapCard;
import com.engine.PathAndNameEnums.ClassPath;
import com.engine.PathAndNameEnums.FileName;
import com.engine.PathAndNameEnums.FolderPath;
import com.io.JSONCardObject;

public class Backendv4 {
	private static Logger logger = Logger.getLogger(Backendv4.class.toString());

	private static void bindCardEffects() {
		try {
			for (Card card : Global.getCardDb()) {
				for (Path path : (Iterable<Path>) Files.list(
						FileSystems.getDefault().getPath(FolderPath.COM.path + FolderPath.EFFECT_DB.path))::iterator) {
					if (path.getFileName().toString().replace(".java", "").replace("0", " ").equals(card.getName())) {
						card.setBoundClass(
								Class.forName(ClassPath.EFFECT_DB.path + configurePathToClassName(path.getFileName())));
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.log(Level.SEVERE, "An error occured", e);
		}
	}

	public static void buildDB() {
		JSONArray jsonArray;
		Path filePath = FileSystems.getDefault().getPath(FolderPath.COM.path + FolderPath.JSON.path);
		logger.log(Level.FINE, () -> "Successfully found designated file path: \"" + filePath + "\"");
		try {
			jsonArray = new JSONArray(
					concatStringArray(Files.readAllLines(filePath.resolve(FileName.CARD_JSON.nameWithExtension))));
			logger.log(Level.FINE,
					() -> "Successfully found file \""
							+ filePath.resolve(FileName.CARD_JSON.nameWithExtension).getFileName()
							+ "\" at the following file path: \""
							+ filePath.resolve(FileName.CARD_JSON.nameWithExtension) + "\"");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "An Exception Occured", e);
			jsonArray = new JSONArray();
		}
		for (Object cardGroup : jsonArray) {
			JSONObject jCardGroupObject = (JSONObject) cardGroup;
			logger.log(Level.FINE, () -> jCardGroupObject.getString(Json.CARD_TYPE.jkvName));
			for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
				JSONCardObject jCardObject = new JSONCardObject((JSONObject) card);
				Card builtCard = null;
				switch (jCardGroupObject.getString(Json.CARD_TYPE.jkvName)) {
				case "monster":
					builtCard = buildMonster(jCardObject);
					break;
				case "pendulumMonster":
					builtCard = buildPendulumMonster(jCardObject);
					break;
				case "fusionMonster", "synchroMonster":
					builtCard = buildExtraMonster(jCardObject);
					break;
				case "pendulumFusionMonster", "pendulumSynchroMonster":
					builtCard = buildPendulumExtraMonster(jCardObject);
					break;
				case "xyzMonster":
					builtCard = buildXyzMonster(jCardObject);
					break;
				case "pendulumXyzMonster":
					builtCard = buildPendulumXyzMonster(jCardObject);
					break;
				case "linkMonster":
					builtCard = buildLinkMonster(jCardObject);
					break;
				case "spell", "trap":
					builtCard = buildSpellTrap(jCardObject);
					break;
				default:
					logger.log(Level.FINE, () -> "Skipped: " + jCardGroupObject.getString(Json.CARD_TYPE.jkvName));
				}
				if (builtCard != null)
					Global.getCardDb().add(builtCard);
			}
		}
		bindCardEffects();
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildPendulumXyzMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = buildXyzMonster(jCardObject);
		monCard.setPendAttributes(monCard.new PendAttributes(jCardObject.getString(Json.PENDULUM_LORE.jkvName),
				jCardObject.getInt(Json.PENDULUM_LEVEL.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildPendulumExtraMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = buildExtraMonster(jCardObject);
		monCard.setPendAttributes(monCard.new PendAttributes(jCardObject.getString(Json.PENDULUM_LORE.jkvName),
				jCardObject.getInt(Json.PENDULUM_LEVEL.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildExtraMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = buildMonster(jCardObject);
		monCard.setExtraAttributes(monCard.new ExtraAttributes(jCardObject.getString(Json.SUMMON_REQUIREMENT.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildLinkMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = buildExtraMonster(jCardObject);
		monCard.setLinkAttributes(
				monCard.getExtraAttributes().new LinkAttributes(
						jCardObject.getLinkArrowArray(Json.LINK_ARROW.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = new MonsterCard(jCardObject.getString(Json.NAME.jkvName), jCardObject.getInt(Json.INDEX.jkvName),
				jCardObject.getString(Json.LORE.jkvName), jCardObject.getInt(Json.LEVEL.jkvName),
				jCardObject.getInt(Json.ATTACK.jkvName), jCardObject.getInt(Json.DEFENSE.jkvName));
		monCard.setMonComBlock(
				monCard.new MonComBlock(jCardObject.getMonsterAttributeComponent(Json.MONSTER_ATTRIBUTE.jkvName),
						jCardObject.getMonsterTypeComponent(Json.MONSTER_TYPE.jkvName),
						jCardObject.getTypeComponentArray(Json.TYPE.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildPendulumMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = buildMonster(jCardObject);
		monCard.setPendAttributes(monCard.new PendAttributes(jCardObject.getString(Json.PENDULUM_LORE.jkvName),
				jCardObject.getInt(Json.PENDULUM_LEVEL.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static SpellTrapCard buildSpellTrap(JSONCardObject jCardObject) {
		return new SpellTrapCard(jCardObject.getString(Json.NAME.jkvName), jCardObject.getInt(Json.INDEX.jkvName),
				jCardObject.getCardTypeComponent(Json.CARD_TYPE.jkvName), jCardObject.getString(Json.LORE.jkvName), jCardObject.getIconComponent(Json.ICON.jkvName));
	}

	/**
	 *
	 * @param jCardObject
	 */
	private static MonsterCard buildXyzMonster(JSONCardObject jCardObject) {
		MonsterCard monCard = buildExtraMonster(jCardObject);
		monCard.setXyzAttributes(
				monCard.getExtraAttributes().new XyzAttributes(
						jCardObject.getInt(Json.RANK.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param list
	 * @return concatenated String representation of list
	 */
	public static String concatStringArray(List<String> list) {
		StringBuilder string = new StringBuilder();
		for (String s : list)
			string.append(s);
		return string.toString();
	}

	/**
	 *
	 * @param pathToConfigure
	 * @return String formated for class name syntax.
	 */
	public static String configurePathToClassName(Path pathToConfigure) {
		return pathToConfigure.toString().replace(".java", "");
	}

	protected Backendv4() {
	}
}
