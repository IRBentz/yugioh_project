package com.card.component;

public enum MonsterAttributeComponent implements CardComponentInterface.SubInterface {
	Dark, Divine, Earth, Fire, Light, Water, Wind;

	private final CardComponent cardComponent = CardComponent.MonsterAttribute;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}