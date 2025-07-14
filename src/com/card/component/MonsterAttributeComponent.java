package com.card.component;

import static com.card.component.CardComponent.MonsterAttribute;

public enum MonsterAttributeComponent implements CardSubcomponentInterface {
	Dark, Divine, Earth, Fire, Light, Water, Wind;

	private final CardComponent cardComponent = MonsterAttribute;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}