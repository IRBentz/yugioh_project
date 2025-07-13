package com.card.component;

public enum CardComponent implements CardComponentInterface {
	Type, Icon, LinkArrow, MonsterAttribute, MonsterType, CardType, Architype;

	@Override
	public String getComponentName() {
		return this.name();
	}
	
	@Override
	public CardComponent match(String name) {
		for (CardComponent cardComponent : CardComponent.class.getEnumConstants())
			if (cardComponent.name().equals(name))
				return cardComponent;
		return null;
	}
}