package com.card.component;

import static com.card.component.CardComponent.Icon;

public enum IconComponent implements CardSubcomponentInterface {
	Continuous, Counter, Equip, Field, None, QuickPlay, Ritual;
	
	private final CardComponent cardComponent = Icon;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public String getName() {
		return this.name();
	}
	
	@Override
	public IconComponent match(String name) {
		for (IconComponent iconComponent : IconComponent.class.getEnumConstants())
			if (iconComponent.name().equals(name))
				return iconComponent;
		return null;
	}
	
}