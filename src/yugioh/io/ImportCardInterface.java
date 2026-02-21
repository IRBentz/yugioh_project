package yugioh.io;

import module yugioh;

public interface ImportCardInterface {
	CardTypeComponent getCardTypeComponent(String input);

	IconComponent getIconComponent(String input);

	int getInt(String input);

	LinkArrowComponent[] getLinkArrowArray(String input);

	MonsterAttributeComponent getMonsterAttributeComponent(String input);

	MonsterTypeComponent getMonsterTypeComponent(String input);

	String getString(String input);

	String[] getStringArray(String input);

	TypeComponent[] getTypeComponentArray(String input);
}
