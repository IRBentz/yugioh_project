package com.wrapper.jsonobject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.card.component.CardComponent;
import com.card.component.CardComponentInterface;
import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;
import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;
import com.engine.PathAndNameEnums.ClassPath;

public class JSONCardObject {
	private static final String AN_EXCEPTION_OCCURED = "An Exception Occured";
	static Logger logger = Logger.getLogger(JSONCardObject.class.getName());

	/**
	 * @param inputString
	 * @return
	 */
	static CardComponentInterface stringToCardComponentInterface(String inputString) {
		try {
			for (CardComponent component : CardComponent.values())
				for (CardComponentInterface.SubInterface subcomponent : (CardComponentInterface.SubInterface[]) Class
						.forName(ClassPath.COMPONENT.path + component.getName() + "Component").getEnumConstants())
					if (subcomponent.match(inputString) != null)
						return subcomponent.match(inputString);
		} catch (SecurityException | ClassNotFoundException e) {
			logger.log(Level.SEVERE, AN_EXCEPTION_OCCURED, e);
		}
		logger.log(Level.SEVERE, () -> "Unmatched string: " + inputString);
		return null;
	}

	/**
	 * @param jsonArray
	 * @return
	 */
	static List<CardComponentInterface> stringToCardComponentInterfaceArrayList(JSONArray jsonArray) {
		ArrayList<CardComponentInterface> componentList = new ArrayList<>();
		jsonArray.forEach(json -> componentList.add(stringToCardComponentInterface((String) json)));
		return componentList;
	}

	JSONObject jsonObject;

	/**
	 * @param jsonObject
	 */
	public JSONCardObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	/**
	 * @param input
	 * @return
	 */
	public CardTypeComponent getCardTypeComponent(String input) {
		try {
			return (CardTypeComponent) stringToCardComponentInterface(jsonObject.getString(input));
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return null;
		}
	}

	public IconComponent getIconComponent(String input) {
		try {
			return (IconComponent) stringToCardComponentInterface(jsonObject.getString(input));
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return null;
		}
	}

	public int getInt(String jkvName) {
		try {
			return jsonObject.getInt(jkvName);
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return 0;
		}
	}

	public LinkArrowComponent[] getLinkArrowArray(String input) {
		try {
			return stringToCardComponentInterfaceArrayList(jsonObject.getJSONArray(input))
					.toArray(LinkArrowComponent[]::new);
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return new LinkArrowComponent[] {};
		}
	}

	public MonsterAttributeComponent getMonsterAttributeComponent(String input) {
		try {
			return (MonsterAttributeComponent) stringToCardComponentInterface(jsonObject.getString(input));
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return null;
		}
	}

	public MonsterTypeComponent getMonsterTypeComponent(String input) {
		try {
			return (MonsterTypeComponent) stringToCardComponentInterface(jsonObject.getString(input));
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return null;
		}
	}

	public String getString(String jkvName) {
		try {
			return jsonObject.getString(jkvName);
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return null;
		}
	}

	public TypeComponent[] getTypeComponentArray(String input) {
		try {
			return stringToCardComponentInterfaceArrayList(jsonObject.getJSONArray(input))
					.toArray(TypeComponent[]::new);
		} catch (JSONException e) {
			logger.log(Level.FINE, AN_EXCEPTION_OCCURED, e);
			return new TypeComponent[] {};
		}
	}
}
