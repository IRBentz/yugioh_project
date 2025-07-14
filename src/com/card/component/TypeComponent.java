package com.card.component;

import static com.card.component.CardComponent.Type;

public enum TypeComponent implements CardSubcomponentInterface {
	Effect, Flip, Fusion, Gemini, Link, Normal, Pendulum, Ritual, Spirit, Synchro, Toon, Tuner, Union, Xyz;
	
	private final CardComponent cardComponent = Type;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}