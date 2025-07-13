package com.card.component;

import static com.card.component.CardComponent.CardType;

public enum CardTypeComponent implements CardComponentInterface, CardSubcomponentInterface {
	Monster, Spell, Token, Trap;

	private final CardComponent cardComponent = CardType;
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public CardTypeComponent match(String name) {
		for (CardTypeComponent cardTypeComponent : CardTypeComponent.class.getEnumConstants())
			if (cardTypeComponent.name().equals(name))
				return cardTypeComponent;
		return null;
	}

	@Override
	public String getName() {
		return this.name();
	}
}