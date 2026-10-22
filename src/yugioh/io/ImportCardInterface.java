package yugioh.io;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;

import yugioh.card.component.CardComponent;
import yugioh.card.component.CardComponentInterface;
import yugioh.card.component.CardTypeComponent;
import yugioh.card.component.IconComponent;
import yugioh.card.component.LinkArrowComponent;
import yugioh.card.component.MonsterAttributeComponent;
import yugioh.card.component.MonsterTypeComponent;
import yugioh.card.component.TypeComponent;
import yugioh.engine.PathAndNameEnums.ClassPath;

public interface ImportCardInterface {
	Logger logger = Logger.getLogger(ImportCardInterface.class.getName());
	default CardComponentInterface stringToCardComponentInterface (String inputString) {
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
			logger.log(Level.SEVERE, "An JSONException, SQLException Occurred", e);
		}
		logger.log(Level.SEVERE, () -> "Unmatched string: " + inputString);
		return null;
	}
	
	CardTypeComponent getCardTypeComponent(String input) throws JSONException, SQLException;

	IconComponent getIconComponent(String input) throws JSONException, SQLException;

	int getInt(String input) throws JSONException, SQLException;

	LinkArrowComponent[] getLinkArrowArray(String input)throws JSONException, SQLException;

	MonsterAttributeComponent getMonsterAttributeComponent(String input) throws JSONException, SQLException;

	MonsterTypeComponent getMonsterTypeComponent(String input) throws JSONException, SQLException;

	String getString(String input) throws JSONException, SQLException;

	String[] getStringArray(String input) throws JSONException, SQLException;

	TypeComponent[] getTypeComponentArray(String input) throws JSONException, SQLException;
}
