package com.card.component;

import static com.card.component.CardComponent.MonsterAttribute;

public enum MonsterAttributeComponent implements CardComponentInterface, CardSubcomponentInterface {
	Dark, Divine, Earth, Fire, Light, Water, Wind;

	private final CardComponent cardComponent = MonsterAttribute;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public MonsterAttributeComponent match(String name) {
		for (MonsterAttributeComponent monsterAttributeComponent : MonsterAttributeComponent.class.getEnumConstants())
			if (monsterAttributeComponent.name().equals(name))
				return monsterAttributeComponent;
		return null;
	}

	@Override
	public String getName() {
		return this.name();
	}
}