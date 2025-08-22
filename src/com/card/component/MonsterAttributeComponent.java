package com.card.component;

public enum MonsterAttributeComponent implements CardComponentInterface.SubInterface {
	DARK, DIVINE, EARTH, FIRE, LIGHT, WATER, WIND;

	private final CardComponent cardComponent = CardComponent.MONSTER_ATTRIBUTE;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}
