package com.card.component;

import static com.card.component.CardComponent.Type;

public enum TypeComponent implements CardSubcomponentInterface {
	Effect, Flip, Fusion, Gemini, Link, Normal, Pendulum, Ritual, Spirit, Synchro, Toon, Tuner, Union, Xyz;
	
	private final CardComponent cardComponent = Type;
	
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public String getName() {
		return this.name();
	}
	
	@Override
	public TypeComponent match(String name) {
		for (TypeComponent typeComponent : TypeComponent.class.getEnumConstants())
			if (typeComponent.name().equals(name))
				return typeComponent;
		return null;
	}
}