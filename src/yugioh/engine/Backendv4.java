package yugioh.engine;

import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.logging.Level;

import yugioh.card.Card;
import yugioh.card.MonsterCard;
import yugioh.card.SpellTrapCard;
import yugioh.engine.PathAndNameEnums.FileName;
import yugioh.engine.PathAndNameEnums.FolderPath;
import yugioh.io.ImportCardInterface;
import yugioh.wrapper.jsonobject.JSONCardObject;

public class Backendv4 implements DBBuilderInterface {
	private static Logger logger = Logger.getLogger(Backendv4.class.toString());
	private JSONObject jCardGroupObject;
	private JSONCardObject jCardObject;
	private ImportCardInterface importCardObject;
	public MonsterCard buildExtraMonster() {
		var monCard = buildMonster();
		monCard.setExtraAttributes(
				monCard.new ExtraAttributes(importCardObject.getString(Json.SUMMON_REQUIREMENT.jkvName)));
		return monCard;
	}

	public MonsterCard buildLinkMonster() {
		var monCard = buildExtraMonster();
		monCard.setLinkAttributes(monCard.getExtraAttributes().new LinkAttributes(
				importCardObject.getLinkArrowArray(Json.LINK_ARROW.jkvName)));
		return monCard;
	}

	public MonsterCard buildMonster() {
		var monCard = new MonsterCard(importCardObject.getString(Json.NAME.jkvName),
				importCardObject.getInt(Json.INDEX.jkvName), importCardObject.getStringArray(Json.LORE.jkvName),
				importCardObject.getInt(Json.LEVEL.jkvName), importCardObject.getInt(Json.ATTACK.jkvName),
				importCardObject.getInt(Json.DEFENSE.jkvName));
		monCard.setMonComBlock(
				monCard.new MonComBlock(importCardObject.getMonsterAttributeComponent(Json.MONSTER_ATTRIBUTE.jkvName),
						importCardObject.getMonsterTypeComponent(Json.MONSTER_TYPE.jkvName),
						importCardObject.getTypeComponentArray(Json.TYPE.jkvName)));
		return monCard;
	}

	public void attachPendulumAttributes(MonsterCard monCard) {
		monCard.setPendAttributes(monCard.new PendAttributes(importCardObject.getString(Json.PENDULUM_LORE.jkvName),
				importCardObject.getInt(Json.PENDULUM_LEVEL.jkvName)));
	}

	public MonsterCard buildPendulumExtraMonster() {
		var monCard = buildExtraMonster();
		attachPendulumAttributes(monCard);
		return monCard;
	}

	public MonsterCard buildPendulumMonster() {
		var monCard = buildMonster();
		attachPendulumAttributes(monCard);
		return monCard;
	}

	public MonsterCard buildPendulumXyzMonster() {
		var monCard = buildXyzMonster();
		attachPendulumAttributes(monCard);
		return monCard;
	}

	public SpellTrapCard buildSpellTrap() {
		return new SpellTrapCard(importCardObject.getString(Json.NAME.jkvName),
				importCardObject.getInt(Json.INDEX.jkvName),
				importCardObject.getCardTypeComponent(Json.CARD_TYPE.jkvName.toUpperCase()),
				importCardObject.getStringArray(Json.LORE.jkvName),
				importCardObject.getIconComponent(Json.ICON.jkvName));
	}


	public MonsterCard buildXyzMonster() {
		var monCard = buildExtraMonster();
		monCard.setXyzAttributes(
				monCard.getExtraAttributes().new XyzAttributes(importCardObject.getInt(Json.RANK.jkvName)));
		return monCard;
	}

	public Card getBuiltCard() {
		importCardObject = jCardObject;
		return switch (jCardGroupObject.getString(Json.CARD_TYPE.jkvName)) {
		case "monster" -> buildMonster();
		case "pendulumMonster" -> buildPendulumMonster();
		case "fusionMonster", "synchroMonster" -> buildExtraMonster();
		case "pendulumFusionMonster", "pendulumSynchroMonster" -> buildPendulumExtraMonster();
		case "xyzMonster" -> buildXyzMonster();
		case "pendulumXyzMonster" -> buildPendulumXyzMonster();
		case "linkMonster" -> buildLinkMonster();
		case "spell", "trap" -> buildSpellTrap();
		default -> null;
		};
	}

	protected Backendv4() {
	}

	public Backendv4(int flag) {
		if (flag != 0) {
			System.exit(flag);
		}
	}

	@Override
	public void buildDB() {
		JSONArray jsonArray;
		var filePath = FileSystems.getDefault().getPath(FolderPath.YUGIOH.path + FolderPath.JSON.path);
		Backendv4.logger.log(Level.FINE, () -> "Successfully found designated file path: \"" + filePath + "\"");
		try {
			jsonArray = new JSONArray(
					this.concatStringArray(Files.readAllLines(filePath.resolve(FileName.CARD_JSON.nameWithExtension))));
			Backendv4.logger.log(Level.FINE,
					() -> "Successfully found file \""
							+ filePath.resolve(FileName.CARD_JSON.nameWithExtension).getFileName()
							+ "\" at the following file path: \""
							+ filePath.resolve(FileName.CARD_JSON.nameWithExtension) + "\"");
		} catch (final IOException e) {
			Backendv4.logger.log(Level.SEVERE, "An Exception Occured", e);
			jsonArray = new JSONArray();
		}
		for (Object cardGroup : jsonArray) {
			jCardGroupObject = (JSONObject) cardGroup;
			Backendv4.logger.log(Level.FINE,
					() -> "Found Card Type {" + jCardGroupObject.getString(Json.CARD_TYPE.jkvName) + "}");
			for (Object card : jCardGroupObject.getJSONArray(Json.CARDS.jkvName)) {
				jCardObject = new JSONCardObject((JSONObject) card);
				final var builtCard = getBuiltCard();
				if (builtCard != null) {
					Global.getCardDb().add(builtCard);
				}
			}
		}
		this.bindCardEffects();
	}
}
