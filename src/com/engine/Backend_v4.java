package com.engine;

import static com.engine.Global.card_db;
import static com.engine.Global.fal_list;
import static com.io.ConsolePrintHandling.println;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

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
import com.engine.FileEnums.FileNameEnum;
import com.engine.FileEnums.FilePathEnum;

public abstract class Backend_v4 {
	private static JSONObject jCardObject;
	private static JSONArray jsonArray;

	private static FileNameEnum card_json = FileNameEnum.Card_json;

	private static FilePathEnum comPath = FilePathEnum.ComPath, jsonPath = FilePathEnum.JsonPath;

	private static ClassPathEnum componentCPE = ClassPathEnum.Component;

	private static JsonKeyValues attack = JsonKeyValues.JKV_attack, card_type = JsonKeyValues.JKV_card_type,
			cards = JsonKeyValues.JKV_cards, defense = JsonKeyValues.JKV_defense, icon = JsonKeyValues.JKV_icon,
			index = JsonKeyValues.JKV_index, level = JsonKeyValues.JKV_level, linkArrow = JsonKeyValues.JKV_linkArrow,
			linkRating = JsonKeyValues.JKV_linkRating, lore = JsonKeyValues.JKV_lore,
			monsterAttribute = JsonKeyValues.JKV_monsterAttribute, monsterType = JsonKeyValues.JKV_monsterType,
			name = JsonKeyValues.JKV_name, pendulumLevel = JsonKeyValues.JKV_pendulumLevel,
			pendulumLore = JsonKeyValues.JKV_pendulumLore, rank = JsonKeyValues.JKV_rank,
			summonRequirement = JsonKeyValues.JKV_summonRequirement, type = JsonKeyValues.JKV_type;

	@SuppressWarnings("unused")
	private static void assignFaL() {
		card_db.forEach(card -> fal_list.forEach(pair -> {
			if (card.getIndex() == pair[0]) {
				card.setAllowedCopies(pair[1]);
			}
		}));
	}

	public static void buildDB() {

		Path filePath = FileSystems.getDefault().getPath(comPath.path + jsonPath.path);
		println("Successfully found designated file path: \"" + filePath + "\"");
		try {
			jsonArray = new JSONArray(Utils.concatStringArray(Files.readAllLines(filePath.resolve(card_json.name))));
			println("Successfully found file \"" + filePath.resolve(card_json.name).getFileName()
					+ "\" at the following file path: \"" + filePath.resolve(card_json.name) + "\"");
		} catch (IOException e) {
			e.printStackTrace();
			jsonArray = new JSONArray();
		}
		for (Object cardGroup : jsonArray) {
			JSONObject jCardGroupObject = (JSONObject) cardGroup;
			switch (jCardGroupObject.getString(card_type.JKVname)) {
			case "monster":
				buildMonster(jCardGroupObject);
				break;
			case "pendulumMonster":
				buildPendulumMonster(jCardGroupObject);
				break;
			case "fusionMonster":
			case "synchroMonster":
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
				println("Skipped: " + jCardGroupObject.getString(card_type.JKVname));
				break;
			}
		}
		// System.out.println(Global.card_db);
	}

	private static void buildFusionOrSynchroMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(new ExtraMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
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
			Global.card_db.add(new LinkMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
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
			Global.card_db.add(new MonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
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
			Global.card_db.add(new PenMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
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
			card_db.add(new SpellCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					jCardObject.getString(lore.JKVname),
					strintToCardComponentInterface(jCardObject.getString(icon.JKVname)).castTo(IconComponent.class)));
		}
	}

	private static void buildTrap(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			card_db.add(new TrapCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
					jCardObject.getString(lore.JKVname),
					strintToCardComponentInterface(jCardObject.getString(icon.JKVname)).castTo(IconComponent.class)));
		}
	}

	private static void buildXyzMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(new XyzMonCard(jCardObject.getString(name.JKVname), jCardObject.getInt(index.JKVname),
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

	public static ArrayList<CardComponentInterface> stringToCardComponentInterfaceArrayList(JSONArray jsonArray) {
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
		return null;
	}
}
