package com.testing;

import static com.engine.ClassPathEnum.Component;
import static com.engine.Global.card_db;
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
import com.engine.Global;
import com.engine.Utils;

public class JsonImporting {

	public static void main(String[] args) {

		Path filePath = FileSystems.getDefault().getPath("src/com/db/_json/card.json");
		try {
			JSONArray jsonArray = new JSONArray(Utils.concatStringArray(Files.readAllLines(filePath)));
			for (Object obj : jsonArray) {
				JSONObject jObject = (JSONObject) obj;
				String card_typeName = jObject.getString(card_type.name());
				if (card_typeName.equals("monster")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						Global.card_db.add(new MonCard(jObject2.getString(name.name()), jObject2.getInt(index.name()),
								stringConvertCCI(jObject2.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jObject2.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jObject2.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jObject2.getString(lore.name()), jObject2.getInt(level.name()),
								jObject2.getInt(attack.name()), jObject2.getInt(defense.name())));
					}
				} else if (card_typeName.equals("pendulumMonster")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						Global.card_db.add(new PenMonCard(jObject2.getString(name.name()),
								jObject2.getInt(index.name()),
								stringConvertCCI(jObject2.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jObject2.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jObject2.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jObject2.getString(pendulumLore.name()), jObject2.getString(lore.name()),
								jObject2.getInt(level.name()), jObject2.getInt(pendulumLevel.name()),
								jObject2.getInt(attack.name()), jObject2.getInt(defense.name())));
					}
				} else if (card_typeName.equals("fusionMonster") || card_typeName.equals("synchroMonster")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						Global.card_db.add(new ExtraMonCard(jObject2.getString(name.name()),
								jObject2.getInt(index.name()),
								stringConvertCCI(jObject2.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jObject2.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jObject2.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jObject2.getString(summonRequirement.name()), jObject2.getString(lore.name()),
								jObject2.getInt(level.name()), jObject2.getInt(attack.name()),
								jObject2.getInt(defense.name())));
					}
				} else if (card_typeName.equals("xyzMonster")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						Global.card_db.add(new XyzMonCard(jObject2.getString(name.name()),
								jObject2.getInt(index.name()),
								stringConvertCCI(jObject2.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jObject2.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jObject2.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jObject2.getString(summonRequirement.name()), jObject2.getString(lore.name()),
								jObject2.getInt(rank.name()), jObject2.getInt(attack.name()),
								jObject2.getInt(defense.name())));
					}
				} else if (card_typeName.equals("linkMonster")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						Global.card_db.add(new LinkMonCard(jObject2.getString(name.name()),
								jObject2.getInt(index.name()),
								stringConvertCCI(jObject2.getString(monsterAttribute.name()))
										.castTo((MonsterAttributeComponent.class)),
								stringConvertCCI(jObject2.getString(monsterType.name()))
										.castTo(MonsterTypeComponent.class),
								stringToCCIArrayList(jObject2.getJSONArray(type.name())).toArray(TypeComponent[]::new),
								jObject2.getString(summonRequirement.name()), jObject2.getString(lore.name()),
								jObject2.getInt(linkRating.name()), jObject2.getInt(attack.name()),
								stringToCCIArrayList(jObject2.getJSONArray(linkArrow.name()))
										.toArray(LinkArrowComponent[]::new)));
					}
				} else if (card_typeName.equals("spell")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						card_db.add(new SpellCard(jObject2.getString(name.name()), jObject2.getInt(index.name()),
								jObject2.getString(lore.name()),
								stringConvertCCI(jObject2.getString(icon.name())).castTo(IconComponent.class)));
					}
				} else if (card_typeName.equals("trap")) {
					for (Object obj2 : jObject.getJSONArray(cards.name())) {
						JSONObject jObject2 = (JSONObject) obj2;
						card_db.add(new TrapCard(jObject2.getString(name.name()), jObject2.getInt(index.name()),
								jObject2.getString(lore.name()),
								stringConvertCCI(jObject2.getString(icon.name())).castTo(IconComponent.class)));
					}
				} else {
					System.out.println("Skipped: " + card_typeName);
				}
			}
			System.out.println(Global.card_db);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static CardComponentInterface stringConvertCCI(String inputString) {
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

	private static ArrayList<CardComponentInterface> stringToCCIArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(stringConvertCCI(String.class.cast(json))));
		return componentList;
	}
}
