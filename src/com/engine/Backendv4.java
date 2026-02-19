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
import com.io.ImportCardInterface;
import com.wrapper.jsonobject.JSONCardObject;

public class Backendv4 implements DBBuilder {
	private static Logger logger = Logger.getLogger(Backendv4.class.toString());

	private void bindCardEffects() {
		try {
			for (Card card : Global.getCardDb()) {
				for (Path path : (Iterable<Path>) Files.list(
						FileSystems.getDefault().getPath(FolderPath.COM.path + FolderPath.EFFECT_DB.path))::iterator) {
					if (path.getFileName().toString().replace(".java", "").equals(card.getName())) {
						card.setBoundClass(
								Class.forName(ClassPath.EFFECT_DB.path + configurePathToClassName(path.getFileName())));
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.log(Level.SEVERE, "An error occured", e);
		}
	}

	public void buildDB() {
		JSONArray jsonArray;
		var filePath = FileSystems.getDefault().getPath(FolderPath.COM.path + FolderPath.JSON.path);
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
			var jCardGroupObject = (JSONObject) cardGroup;
			logger.log(Level.FINE,
					() -> "Found Card Type {" + jCardGroupObject.getString(Json.CARD_TYPE.jkvName) + "}");
			for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
				var jCardObject = new JSONCardObject((JSONObject) card);
				var builtCard = getBuiltCard(jCardGroupObject, jCardObject);
				if (builtCard != null) {
					Global.getCardDb().add(builtCard);
				}
			}
		}
		bindCardEffects();
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildExtraMonster(ImportCardInterface importCardObject) {
		var monCard = buildMonster(importCardObject);
		monCard.setExtraAttributes(monCard.new ExtraAttributes(importCardObject.getString(Json.SUMMON_REQUIREMENT.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildLinkMonster(ImportCardInterface importCardObject) {
		var monCard = buildExtraMonster(importCardObject);
		monCard.setLinkAttributes(monCard.getExtraAttributes().new LinkAttributes(
				importCardObject.getLinkArrowArray(Json.LINK_ARROW.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildMonster(ImportCardInterface importCardObject) {
		var monCard = new MonsterCard(importCardObject.getString(Json.NAME.jkvName), importCardObject.getInt(Json.INDEX.jkvName),
				importCardObject.getStringArray(Json.LORE.jkvName), importCardObject.getInt(Json.LEVEL.jkvName),
				importCardObject.getInt(Json.ATTACK.jkvName), importCardObject.getInt(Json.DEFENSE.jkvName));
		monCard.setMonComBlock(
				monCard.new MonComBlock(importCardObject.getMonsterAttributeComponent(Json.MONSTER_ATTRIBUTE.jkvName),
						importCardObject.getMonsterTypeComponent(Json.MONSTER_TYPE.jkvName),
						importCardObject.getTypeComponentArray(Json.TYPE.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param importCardObject
	 * @param monCard
	 */
	private static void buildPendulumAttributes(ImportCardInterface importCardObject, MonsterCard monCard) {
		monCard.setPendAttributes(monCard.new PendAttributes(importCardObject.getString(Json.PENDULUM_LORE.jkvName),
				importCardObject.getInt(Json.PENDULUM_LEVEL.jkvName)));
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildPendulumExtraMonster(ImportCardInterface importCardObject) {
		var monCard = buildExtraMonster(importCardObject);
		buildPendulumAttributes(importCardObject, monCard);
		return monCard;
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildPendulumMonster(ImportCardInterface importCardObject) {
		var monCard = buildMonster(importCardObject);
		buildPendulumAttributes(importCardObject, monCard);
		return monCard;
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildPendulumXyzMonster(ImportCardInterface importCardObject) {
		var monCard = buildXyzMonster(importCardObject);
		buildPendulumAttributes(importCardObject, monCard);
		return monCard;
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static SpellTrapCard buildSpellTrap(ImportCardInterface importCardObject) {
		return new SpellTrapCard(importCardObject.getString(Json.NAME.jkvName), importCardObject.getInt(Json.INDEX.jkvName),
				importCardObject.getCardTypeComponent(Json.CARD_TYPE.jkvName.toUpperCase()),
				importCardObject.getStringArray(Json.LORE.jkvName), importCardObject.getIconComponent(Json.ICON.jkvName));
	}

	/**
	 *
	 * @param importCardObject
	 */
	private static MonsterCard buildXyzMonster(ImportCardInterface importCardObject) {
		var monCard = buildExtraMonster(importCardObject);
		monCard.setXyzAttributes(monCard.getExtraAttributes().new XyzAttributes(importCardObject.getInt(Json.RANK.jkvName)));
		return monCard;
	}

	/**
	 *
	 * @param list
	 * @return concatenated String representation of list
	 */
	public String concatStringArray(List<String> list) {
		var string = new StringBuilder();
		for (String s : list) {
			string.append(s);
		}
		return string.toString();
	}

	/**
	 *
	 * @param pathToConfigure
	 * @return String formated for class name syntax.
	 */
	public String configurePathToClassName(Path pathToConfigure) {
		return pathToConfigure.toString().replace(".java", "");
	}

	/**
	 *
	 * @param jCardGroupObject
	 * @param jCardObject
	 * @return built <Card>
	 */
	private static Card getBuiltCard(JSONObject jCardGroupObject, JSONCardObject jCardObject) {
		return switch (jCardGroupObject.getString(Json.CARD_TYPE.jkvName)) {
		case "monster" -> buildMonster(jCardObject);
		case "pendulumMonster" -> buildPendulumMonster(jCardObject);
		case "fusionMonster", "synchroMonster" -> buildExtraMonster(jCardObject);
		case "pendulumFusionMonster", "pendulumSynchroMonster" -> buildPendulumExtraMonster(jCardObject);
		case "xyzMonster" -> buildXyzMonster(jCardObject);
		case "pendulumXyzMonster" -> buildPendulumXyzMonster(jCardObject);
		case "linkMonster" -> buildLinkMonster(jCardObject);
		case "spell", "trap" -> buildSpellTrap(jCardObject);
		default -> null;
		};
	}

	protected Backendv4() {
	}
	
	public Backendv4(int flag) {
		if(flag != 0) {
			System.exit(flag);
		}
	}
}
