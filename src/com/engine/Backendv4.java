package com.engine;

import static com.io.ConsolePrintHandling.println;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
import com.engine.PathAndNameEnums.ClassPathEnum;
import com.engine.PathAndNameEnums.FileNameEnum;
import com.engine.PathAndNameEnums.FilePathEnum;

public abstract class Backendv4 {
	private static JSONObject jCardObject;
	

	private static FileNameEnum cardJson = FileNameEnum.Card_json;

	private static FilePathEnum comPath = FilePathEnum.ComPath;
	private static FilePathEnum  jsonPath = FilePathEnum.JsonPath;
	private static FilePathEnum  effectDBPath = FilePathEnum.EffectDBPath;

	private static ClassPathEnum componentCPE = ClassPathEnum.Component;
	private static ClassPathEnum  effectDBCPE = ClassPathEnum.EffectDB;

	private static JsonKeyValues attack = JsonKeyValues.JKV_attack;
	private static JsonKeyValues  cardType = JsonKeyValues.JKV_card_type;
	private static JsonKeyValues  cards = JsonKeyValues.JKV_cards;
	private static JsonKeyValues  defense = JsonKeyValues.JKV_defense;
	private static JsonKeyValues  icon = JsonKeyValues.JKV_icon;
	private static JsonKeyValues  index = JsonKeyValues.JKV_index;
	private static JsonKeyValues  level = JsonKeyValues.JKV_level;
	private static JsonKeyValues  linkArrow = JsonKeyValues.JKV_linkArrow;
	private static JsonKeyValues  linkRating = JsonKeyValues.JKV_linkRating;
	private static JsonKeyValues  lore = JsonKeyValues.JKV_lore;
	private static JsonKeyValues  monsterAttribute = JsonKeyValues.JKV_monsterAttribute;
	private static JsonKeyValues  monsterType = JsonKeyValues.JKV_monsterType;
	private static JsonKeyValues  name = JsonKeyValues.JKV_name;
	private static JsonKeyValues  pendulumLevel = JsonKeyValues.JKV_pendulumLevel;
	private static JsonKeyValues  pendulumLore = JsonKeyValues.JKV_pendulumLore;
	private static JsonKeyValues  rank = JsonKeyValues.JKV_rank;
	private static JsonKeyValues  summonRequirement = JsonKeyValues.JKV_summonRequirement;
	private static JsonKeyValues  type = JsonKeyValues.JKV_type;
	
	private Backendv4() {}

	@SuppressWarnings("unused")
	private static void assignFaL() {
		Global.getCardDb().forEach(card -> Global.getFalList().forEach(pair -> {
			if (card.getIndex() == pair[0]) {
				card.setAllowedCopies(pair[1]);
			}
		}));
	}
	
	private static void bindCardEffects() {
		try {
			for(Card card : Global.getCardDb()) {
				for(Path path : (Iterable<Path>) Files.list(FileSystems.getDefault().getPath(comPath.path + effectDBPath.path))::iterator) {
					if(path.getFileName().toString().replace(".java", "").replace("0", " ").equals(card.getName())) {
						card.setBoundClass(Class.forName(effectDBCPE.path + Utils.configurePathToClassName(path.getFileName())));
					}
				}
			}
		} catch (IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}

	public static void buildDB() {
  JSONArray jsonArray;
		Path filePath = FileSystems.getDefault().getPath(comPath.path + jsonPath.path);
		println("Successfully found designated file path: \"" + filePath + "\"");
		try {
			jsonArray = new JSONArray(Utils.concatStringArray(Files.readAllLines(filePath.resolve(cardJson.name))));
			println("Successfully found file \"" + filePath.resolve(cardJson.name).getFileName()
					+ "\" at the following file path: \"" + filePath.resolve(cardJson.name) + "\"");
		} catch (IOException e) {
			e.printStackTrace();
			jsonArray = new JSONArray();
		}
		for (Object cardGroup : jsonArray) {
			JSONObject jCardGroupObject = (JSONObject) cardGroup;
			switch (jCardGroupObject.getString(cardType.JKVname)) {
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
				println("Skipped: " + jCardGroupObject.getString(cardType.JKVname));
				break;
			}
		}
		bindCardEffects();
	}

	private static void buildFusionOrSynchroMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new ExtraMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo(MonsterAttributeComponent.class),
					strintToCardComponentInterface(jCardObject.getString(monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(type.JKVname))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(summonRequirement.JKVname), jCardObject.getString(lore.JKVname),
					jCardObject.getInt(level.JKVname), jCardObject.getInt(attack.JKVname),
					jCardObject.getInt(defense.JKVname)));
		}
	}

	private static void buildLinkMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new LinkMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo(MonsterAttributeComponent.class),
					strintToCardComponentInterface(jCardObject.getString(monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(type.JKVname))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(summonRequirement.JKVname), jCardObject.getString(lore.JKVname),
					jCardObject.getInt(linkRating.JKVname), jCardObject.getInt(attack.JKVname),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(linkArrow.JKVname))
							.toArray(LinkArrowComponent[]::new)));
		}
	}

	private static void buildMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new MonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo(MonsterAttributeComponent.class),
					strintToCardComponentInterface(jCardObject.getString(monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(type.JKVname))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(lore.JKVname), jCardObject.getInt(level.JKVname),
					jCardObject.getInt(attack.JKVname), jCardObject.getInt(defense.JKVname)));
		}
	}

	private static void buildPendulumMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new PenMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo(MonsterAttributeComponent.class),
					strintToCardComponentInterface(jCardObject.getString(monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(type.JKVname))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(pendulumLore.JKVname), jCardObject.getString(lore.JKVname),
					jCardObject.getInt(level.JKVname), jCardObject.getInt(pendulumLevel.JKVname),
					jCardObject.getInt(attack.JKVname), jCardObject.getInt(defense.JKVname)));
		}
	}

	private static void buildSpell(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new SpellCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					jCardObject.getString(lore.JKVname),
					strintToCardComponentInterface(jCardObject.getString(icon.JKVname)).castTo(IconComponent.class)));
		}
	}

	private static void buildTrap(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new TrapCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					jCardObject.getString(lore.JKVname),
					strintToCardComponentInterface(jCardObject.getString(icon.JKVname)).castTo(IconComponent.class)));
		}
	}

	private static void buildXyzMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.getCardDb().add(new XyzMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
					strintToCardComponentInterface(jCardObject.getString(monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(type.JKVname))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(summonRequirement.JKVname), jCardObject.getString(lore.JKVname),
					jCardObject.getInt(rank.JKVname), jCardObject.getInt(attack.JKVname),
					jCardObject.getInt(defense.JKVname)));
		}
	}

	public static List<CardComponentInterface> stringToCardComponentInterfaceArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(strintToCardComponentInterface(String.class.cast(json))));
		return componentList;
	}

	public static CardComponentInterface strintToCardComponentInterface(String inputString) {
		try {
			for (CardComponent component : CardComponent.values())
				for (CardComponentInterface.SubInterface subcomponent : (CardComponentInterface.SubInterface[]) Class
						.forName(componentCPE.path + component.name() + "Component").getEnumConstants())
					if (subcomponent.match(inputString) != null)
						return subcomponent.match(inputString);
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(1);
		return null;
	}
}
