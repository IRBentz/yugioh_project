package com.engine;

import static com.engine.ClassPathEnum.Component;
import static com.engine.FileNameEnum.Card_json;
import static com.engine.FilePathEnum.ComPath;
import static com.engine.FilePathEnum.JsonPath;
import static com.engine.Global.card_db;
import static com.engine.Global.fal_list;
import static com.engine.JsonKeyValues.JKV_attack;
import static com.engine.JsonKeyValues.JKV_card_type;
import static com.engine.JsonKeyValues.JKV_cards;
import static com.engine.JsonKeyValues.JKV_defense;
import static com.engine.JsonKeyValues.JKV_icon;
import static com.engine.JsonKeyValues.JKV_index;
import static com.engine.JsonKeyValues.JKV_level;
import static com.engine.JsonKeyValues.JKV_linkArrow;
import static com.engine.JsonKeyValues.JKV_linkRating;
import static com.engine.JsonKeyValues.JKV_lore;
import static com.engine.JsonKeyValues.JKV_monsterAttribute;
import static com.engine.JsonKeyValues.JKV_monsterType;
import static com.engine.JsonKeyValues.JKV_name;
import static com.engine.JsonKeyValues.JKV_pendulumLevel;
import static com.engine.JsonKeyValues.JKV_pendulumLore;
import static com.engine.JsonKeyValues.JKV_rank;
import static com.engine.JsonKeyValues.JKV_summonRequirement;
import static com.engine.JsonKeyValues.JKV_type;

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
import com.card.component.CardSubcomponentInterface;
import com.card.component.IconComponent;
import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public abstract class Backend_v4 {
	private static JSONArray jsonArray;
	private static JSONObject jCardObject;
	@SuppressWarnings("unused")
	private static void assignFaL() {
		card_db.forEach(card -> fal_list.forEach(pair -> {
			if (card.getIndex() == pair[0]) {
				card.setAllowedCopies(pair[1]);
			}
		}));
	}

	public static void buildDB() {
		Path filePath = FileSystems.getDefault().getPath(ComPath.path + JsonPath.path);
		println("Successfully found designated file path: \"" + filePath + "\"");
		try {
			jsonArray = new JSONArray(Utils.concatStringArray(Files.readAllLines(filePath.resolve(Card_json.name))));
			println("Successfully found file \"" + filePath.resolve(Card_json.name).getFileName()
					+ "\" at the following file path: \"" + filePath.resolve(Card_json.name) + "\"");
		} catch (IOException e) {
			e.printStackTrace();
			jsonArray = new JSONArray();
		}
		for (Object cardGroup : jsonArray) {
			JSONObject jCardGroupObject = (JSONObject) cardGroup;
			switch (jCardGroupObject.getString(JKV_card_type.JKVname)) {
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
				System.out.println("Skipped: " + jCardGroupObject.getString(JKV_card_type.JKVname));
				break;
			}
		}
		System.out.println(Global.card_db);
	}

	private static void buildTrap(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			card_db.add(new TrapCard(jCardObject.getString(JKV_name.JKVname),
					jCardObject.getInt(JKV_index.JKVname), jCardObject.getString(JKV_lore.JKVname),
					strintToCardComponentInterface(jCardObject.getString(JKV_icon.JKVname)).castTo(IconComponent.class)));
		}
	}

	private static void buildSpell(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			card_db.add(new SpellCard(jCardObject.getString(JKV_name.JKVname),
					jCardObject.getInt(JKV_index.JKVname), jCardObject.getString(JKV_lore.JKVname),
					strintToCardComponentInterface(jCardObject.getString(JKV_icon.JKVname)).castTo(IconComponent.class)));
		}
	}

	private static void buildLinkMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(new LinkMonCard(jCardObject.getString(JKV_name.JKVname),
					jCardObject.getInt(JKV_index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(JKV_type.JKVname)).toArray(
							TypeComponent[]::new),
					jCardObject.getString(JKV_summonRequirement.JKVname),
					jCardObject.getString(JKV_lore.JKVname), jCardObject.getInt(JKV_linkRating.JKVname),
					jCardObject.getInt(JKV_attack.JKVname),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(JKV_linkArrow.JKVname))
							.toArray(LinkArrowComponent[]::new)));
		}
	}

	private static void buildXyzMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(new XyzMonCard(jCardObject.getString(JKV_name.JKVname),
					jCardObject.getInt(JKV_index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(JKV_type.JKVname)).toArray(
							TypeComponent[]::new),
					jCardObject.getString(JKV_summonRequirement.JKVname),
					jCardObject.getString(JKV_lore.JKVname), jCardObject.getInt(JKV_rank.JKVname),
					jCardObject.getInt(JKV_attack.JKVname), jCardObject.getInt(JKV_defense.JKVname)));
		}
	}

	private static void buildFusionOrSynchroMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(new ExtraMonCard(jCardObject.getString(JKV_name.JKVname),
					jCardObject.getInt(JKV_index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(JKV_type.JKVname)).toArray(
							TypeComponent[]::new),
					jCardObject.getString(JKV_summonRequirement.JKVname),
					jCardObject.getString(JKV_lore.JKVname), jCardObject.getInt(JKV_level.JKVname),
					jCardObject.getInt(JKV_attack.JKVname), jCardObject.getInt(JKV_defense.JKVname)));
		}
	}

	private static void buildPendulumMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(new PenMonCard(jCardObject.getString(JKV_name.JKVname),
					jCardObject.getInt(JKV_index.JKVname),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterAttribute.JKVname))
							.castTo((MonsterAttributeComponent.class)),
					strintToCardComponentInterface(jCardObject.getString(JKV_monsterType.JKVname))
							.castTo(MonsterTypeComponent.class),
					stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(JKV_type.JKVname))
							.toArray(TypeComponent[]::new),
					jCardObject.getString(JKV_pendulumLore.JKVname), jCardObject.getString(JKV_lore.JKVname),
					jCardObject.getInt(JKV_level.JKVname), jCardObject.getInt(JKV_pendulumLevel.JKVname),
					jCardObject.getInt(JKV_attack.JKVname), jCardObject.getInt(JKV_defense.JKVname)));
		}
	}

	private static void buildMonster(JSONObject jCardGroupObject) {
		for (Object card : jCardGroupObject.getJSONArray(JKV_cards.JKVname)) {
			jCardObject = (JSONObject) card;
			Global.card_db.add(
					new MonCard(jCardObject.getString(JKV_name.JKVname), jCardObject.getInt(JKV_index.JKVname),
							strintToCardComponentInterface(jCardObject.getString(JKV_monsterAttribute.JKVname))
									.castTo((MonsterAttributeComponent.class)),
							strintToCardComponentInterface(jCardObject.getString(JKV_monsterType.JKVname))
									.castTo(MonsterTypeComponent.class),
							stringToCardComponentInterfaceArrayList(jCardObject.getJSONArray(JKV_type.JKVname))
									.toArray(TypeComponent[]::new),
							jCardObject.getString(JKV_lore.JKVname), jCardObject.getInt(JKV_level.JKVname),
							jCardObject.getInt(JKV_attack.JKVname), jCardObject.getInt(JKV_defense.JKVname)));
		}
	}

	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v4:\t%s", stringToPrint + "\n");
	}

	public static CardComponentInterface strintToCardComponentInterface(String inputString) {
		try {
			for (CardComponent component : CardComponent.values())
				for (CardSubcomponentInterface subcomponent : (CardSubcomponentInterface[]) Class
						.forName(Component.path + component.name() + "Component").getEnumConstants())
					if (subcomponent.match(inputString) != null)
						return subcomponent.match(inputString);
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<CardComponentInterface> stringToCardComponentInterfaceArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(strintToCardComponentInterface(String.class.cast(json))));
		return componentList;
	}
}
