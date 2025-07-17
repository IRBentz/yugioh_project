package com.testing;

import static com.engine.ClassPathEnum.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.card.MonCard;
import com.card.component.CardComponent;
import com.card.component.CardComponentInterface;
import com.card.component.CardSubcomponentInterface;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;
import com.engine.Global;
import com.engine.Utils;

public class JsonImporting {

	public static void main(String[] args) {

		Path filePath = FileSystems.getDefault().getPath("src/com/db/_json/monster.json");
		try {
			JSONArray jsonArray = new JSONArray(Utils.concatStringArray(Files.readAllLines(filePath)));
			for(Object obj : jsonArray) {
				JSONObject jObject = (JSONObject) obj;
				Global.card_db.add(new MonCard(
						jObject.getString("name"),
						jObject.getInt("index"),
						stringConvertCCI(jObject.getString("monsterAttribute")).castTo((MonsterAttributeComponent.class)),
						stringConvertCCI(jObject.getString("monsterType")).castTo(MonsterTypeComponent.class),
						stringToCCIArrayList(jObject.getJSONArray("type")).toArray(TypeComponent[]::new),
						jObject.getString("lore"),
						jObject.getInt("level"),
						jObject.getInt("attack"),
						jObject.getInt("defense")
						));
			}
			System.out.println(Global.card_db);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<CardComponentInterface> stringToCCIArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(stringConvertCCI(String.class.cast(json))));
		return componentList;
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
}
