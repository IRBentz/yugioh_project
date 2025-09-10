package com.card.component;

public enum IconComponent implements CardComponentInterface.SubInterface {
	CONTINUOUS, COUNTER, EQUIP, FIELD, NONE, QUICK_PLAY, RITUAL;

	private final CardComponent cardComponent = CardComponent.ICON;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}
