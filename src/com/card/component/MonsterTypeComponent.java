package com.card.component;

public enum MonsterTypeComponent implements CardComponentInterface.SubInterface {
	AQUA, BEAST, BEAST_WARRIOR, CREATOR_GOD, CYBERSE, DINOSAUR, DIVINE_BEAST, DRAGON, FAIRY, FIEND, FISH, ILLUSION,
	INSECT, MACHINE, PLANT, PSYCHIC, PYRO, REPTILE, ROCK, SEA_SERPENT, SPELLCASTER, THUNDER, WARRIOR, WINGED_BEAST,
	WYRM, ZOMBIE;

	private final CardComponent cardComponent = CardComponent.MONSTER_TYPE;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}
