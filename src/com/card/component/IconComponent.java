package com.card.component;

import static com.card.component.CardComponent.Icon;

public enum IconComponent implements CardSubcomponentInterface {
	Continuous, Counter, Equip, Field, None, QuickPlay, Ritual;
	
	private final CardComponent cardComponent = Icon;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}