package com.card.component;

public enum IconComponent implements CardComponentInterface.SubInterface {
	Continuous, Counter, Equip, Field, None, QuickPlay, Ritual;
	
	private final CardComponent cardComponent = CardComponent.Icon;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}