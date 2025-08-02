package com.card.component;

public enum CardTypeComponent implements CardComponentInterface.SubInterface {
	Monster, Spell, Token, Trap;

	private final CardComponent cardComponent = CardComponent.CardType;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}