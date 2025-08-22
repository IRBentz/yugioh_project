package com.card.component;

public enum TypeComponent implements CardComponentInterface.SubInterface {
	EFFECT, FLIP, FUSION, GEMINI, LINK, NORMAL, PENDULUM, RITUAL, SPIRIT, SYNCHRO, TOON, TUNER, UNION, XYZ;
	
	private final CardComponent cardComponent = CardComponent.TYPE;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}
