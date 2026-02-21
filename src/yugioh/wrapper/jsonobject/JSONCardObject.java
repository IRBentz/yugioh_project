package yugioh.wrapper.jsonobject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import yugioh.card.component.CardComponent;
import yugioh.card.component.CardComponentInterface;
import yugioh.card.component.CardTypeComponent;
import yugioh.card.component.IconComponent;
import yugioh.card.component.LinkArrowComponent;
import yugioh.card.component.MonsterAttributeComponent;
import yugioh.card.component.MonsterTypeComponent;
import yugioh.card.component.TypeComponent;
import yugioh.engine.PathAndNameEnums.ClassPath;
import yugioh.io.ImportCardInterface;

public class JSONCardObject implements ImportCardInterface{
	private static final String AN_EXCEPTION_OCCURED = "An Exception Occured";
	static Logger logger = Logger.getLogger(JSONCardObject.class.getName());

	/**
	 * @param inputString
	 * @return
	 */
	static CardComponentInterface stringToCardComponentInterface(String inputString) {
		try {
			for (CardComponent component : CardComponent.values()) {
				for (CardComponentInterface.SubInterface subcomponent : (CardComponentInterface.SubInterface[]) Class
						.forName(ClassPath.COMPONENT.path + component.getName() + "Component").getEnumConstants()) {
					if (subcomponent.match(inputString) != null) {
						return subcomponent.match(inputString);
					}
				}
			}
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
		var componentList = new ArrayList<CardComponentInterface>();
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

	public int getInt(String input) {
		try {
			return jsonObject.getInt(input);
		} catch (JSONException e) {
			logger.log(Level.FINE, String.format("Unable to find int for %s", input), e);
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

	public String getString(String input) {
		try {
			return jsonObject.getString(input);
		} catch (JSONException e) {
			logger.log(Level.FINE, String.format("Unable to find String for %s", input), e);
			return null;
		}
	}
	
	public String[] getStringArray(String input) {
		try {
			return new String[] {jsonObject.getString(input)};
		} catch (JSONException e) {
			logger.log(Level.FINE, String.format("Unable to find String for %s",input), e);
			return new String[] {};
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
