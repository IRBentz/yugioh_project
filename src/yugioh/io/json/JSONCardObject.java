package yugioh.io.json;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import yugioh.card.component.CardComponentInterface;
import yugioh.card.component.CardTypeComponent;
import yugioh.card.component.IconComponent;
import yugioh.card.component.LinkArrowComponent;
import yugioh.card.component.MonsterAttributeComponent;
import yugioh.card.component.MonsterTypeComponent;
import yugioh.card.component.TypeComponent;
import yugioh.io.ImportCardInterface;

public class JSONCardObject implements ImportCardInterface{
	static Logger logger = Logger.getLogger(JSONCardObject.class.getName());

	List<CardComponentInterface> stringToCardComponentInterfaceArrayList(JSONArray jsonArray) {
		var componentList = new ArrayList<CardComponentInterface>();
		jsonArray.forEach(json -> componentList.add(stringToCardComponentInterface((String) json)));
		return componentList;
	}

	JSONObject jsonObject;

	public JSONCardObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public CardTypeComponent getCardTypeComponent(String input) throws JSONException {
		return (CardTypeComponent) stringToCardComponentInterface(jsonObject.getString(input));
	}

	public IconComponent getIconComponent(String input) throws JSONException {
		return (IconComponent) stringToCardComponentInterface(jsonObject.getString(input));
	}

	public int getInt(String input) throws JSONException {
		return jsonObject.getInt(input);
	}

	public LinkArrowComponent[] getLinkArrowArray(String input) throws JSONException {

		return stringToCardComponentInterfaceArrayList(jsonObject.getJSONArray(input))
					.toArray(LinkArrowComponent[]::new);

	}

	public MonsterAttributeComponent getMonsterAttributeComponent(String input) throws JSONException {
		return (MonsterAttributeComponent) stringToCardComponentInterface(jsonObject.getString(input));
	}

	public MonsterTypeComponent getMonsterTypeComponent(String input) throws JSONException {
		return (MonsterTypeComponent) stringToCardComponentInterface(jsonObject.getString(input));
	}

	public String getString(String input) throws JSONException {
			return jsonObject.getString(input);
	}
	
	public String[] getStringArray(String input) throws JSONException {
		return new String[] {jsonObject.getString(input)};
	}

	public TypeComponent[] getTypeComponentArray(String input) throws JSONException {
		return stringToCardComponentInterfaceArrayList(jsonObject.getJSONArray(input))
					.toArray(TypeComponent[]::new);
	}
}
