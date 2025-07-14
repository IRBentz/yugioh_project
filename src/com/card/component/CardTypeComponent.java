package com.card.component;

import static com.card.component.CardComponent.CardType;

public enum CardTypeComponent implements CardSubcomponentInterface {
	Monster, Spell, Token, Trap;

	private final CardComponent cardComponent = CardType;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}