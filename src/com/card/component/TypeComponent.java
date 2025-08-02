package com.card.component;

public enum TypeComponent implements CardComponentInterface.SubInterface {
	Effect, Flip, Fusion, Gemini, Link, Normal, Pendulum, Ritual, Spirit, Synchro, Toon, Tuner, Union, Xyz;
	
	private final CardComponent cardComponent = CardComponent.Type;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}