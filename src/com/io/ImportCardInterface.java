package com.io;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;
import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;


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
