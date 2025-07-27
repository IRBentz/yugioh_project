package com.engine;

import static com.engine.ClassPathEnum.Component;
import static com.engine.FileNameEnum.Card_json;
import static com.engine.FilePathEnum.ComPath;
import static com.engine.FilePathEnum.JsonPath;
import static com.engine.Global.card_db;
import static com.engine.Global.fal_list;
import static com.engine.JsonKeyValues.attack;
import static com.engine.JsonKeyValues.card_type;
import static com.engine.JsonKeyValues.cards;
import static com.engine.JsonKeyValues.defense;
import static com.engine.JsonKeyValues.icon;
import static com.engine.JsonKeyValues.index;
import static com.engine.JsonKeyValues.level;
import static com.engine.JsonKeyValues.linkArrow;
import static com.engine.JsonKeyValues.linkRating;
import static com.engine.JsonKeyValues.lore;
import static com.engine.JsonKeyValues.monsterAttribute;
import static com.engine.JsonKeyValues.monsterType;
import static com.engine.JsonKeyValues.name;
import static com.engine.JsonKeyValues.pendulumLevel;
import static com.engine.JsonKeyValues.pendulumLore;
import static com.engine.JsonKeyValues.rank;
import static com.engine.JsonKeyValues.summonRequirement;
import static com.engine.JsonKeyValues.type;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
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
			JSONArray jsonArray = new JSONArray(Utils.concatStringArray(Files.readAllLines(filePath.resolve(Card_json.name))));
			println("Successfully found file \"" + filePath.resolve(Card_json.name).getFileName()
					+ "\" at the following file path: \"" + filePath.resolve(Card_json.name) + "\"");
			for (Object cardGroup : jsonArray) {
				JSONObject jCardGroupObject = (JSONObject) cardGroup;
				String card_typeName = jCardGroupObject.getString(card_type.name());
				if (card_typeName.equals("monster")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						Global.card_db.add(new MonCard(jCardObject.getString(name.name()), jCardObject.getInt(index.name()),
								stringConvertCCI(jCardObject.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jCardObject.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jCardObject.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jCardObject.getString(lore.name()), jCardObject.getInt(level.name()),
								jCardObject.getInt(attack.name()), jCardObject.getInt(defense.name())));
					}
				} else if (card_typeName.equals("pendulumMonster")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						Global.card_db.add(new PenMonCard(jCardObject.getString(name.name()),
								jCardObject.getInt(index.name()),
								stringConvertCCI(jCardObject.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jCardObject.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jCardObject.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jCardObject.getString(pendulumLore.name()), jCardObject.getString(lore.name()),
								jCardObject.getInt(level.name()), jCardObject.getInt(pendulumLevel.name()),
								jCardObject.getInt(attack.name()), jCardObject.getInt(defense.name())));
					}
				} else if (card_typeName.equals("fusionMonster") || card_typeName.equals("synchroMonster")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						Global.card_db.add(new ExtraMonCard(jCardObject.getString(name.name()),
								jCardObject.getInt(index.name()),
								stringConvertCCI(jCardObject.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jCardObject.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jCardObject.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jCardObject.getString(summonRequirement.name()), jCardObject.getString(lore.name()),
								jCardObject.getInt(level.name()), jCardObject.getInt(attack.name()),
								jCardObject.getInt(defense.name())));
					}
				} else if (card_typeName.equals("xyzMonster")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						Global.card_db.add(new XyzMonCard(jCardObject.getString(name.name()),
								jCardObject.getInt(index.name()),
								stringConvertCCI(jCardObject.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jCardObject.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jCardObject.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jCardObject.getString(summonRequirement.name()), jCardObject.getString(lore.name()),
								jCardObject.getInt(rank.name()), jCardObject.getInt(attack.name()),
								jCardObject.getInt(defense.name())));
					}
				} else if (card_typeName.equals("linkMonster")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						Global.card_db.add(new LinkMonCard(jCardObject.getString(name.name()),
								jCardObject.getInt(index.name()),
								stringConvertCCI(jCardObject.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jCardObject.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jCardObject.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jCardObject.getString(summonRequirement.name()), jCardObject.getString(lore.name()),
								jCardObject.getInt(linkRating.name()), jCardObject.getInt(attack.name()),
								stringToCCIArrayList(jCardObject.getJSONArray(linkArrow.name()))
										.toArray(LinkArrowComponent[]::new)));
					}
				} else if (card_typeName.equals("spell")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						card_db.add(new SpellCard(jCardObject.getString(name.name()), jCardObject.getInt(index.name()),
								jCardObject.getString(lore.name()),
								stringConvertCCI(jCardObject.getString(icon.name())).castTo(IconComponent.class)));
					}
				} else if (card_typeName.equals("trap")) {
					for (Object card : jCardGroupObject.getJSONArray(cards.name())) {
						JSONObject jCardObject = (JSONObject) card;
						card_db.add(new TrapCard(jCardObject.getString(name.name()), jCardObject.getInt(index.name()),
								jCardObject.getString(lore.name()),
								stringConvertCCI(jCardObject.getString(icon.name())).castTo(IconComponent.class)));
					}
				} else {
					System.out.println("Skipped: " + card_typeName);
				}
			}
			System.out.println(Global.card_db);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void println(String stringToPrint) {
		System.out.printf("Back-end_v4:\t%s", stringToPrint + "\n");
	}
	
	public static CardComponentInterface stringConvertCCI(String inputString) {
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

	public static ArrayList<CardComponentInterface> stringToCCIArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(stringConvertCCI(String.class.cast(json))));
		return componentList;
	}
}
