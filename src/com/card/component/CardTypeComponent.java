package com.card.component;

public enum CardTypeComponent implements CardComponentInterface.SubInterface {
	MONSTER, SPELL, TOKEN, TRAP;

	private final CardComponent cardComponent = CardComponent.CARD_TYPE;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}
