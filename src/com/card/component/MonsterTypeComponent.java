package com.card.component;

public enum MonsterTypeComponent implements CardComponentInterface.SubInterface {
	Aqua, Beast, Beast_Warrior, Creator_God, Cyberse, Dinosaur, Divine_Beast, Dragon, Fairy, Fiend, Fish, Illusion,
	Insect, Machine, Plant, Psychic, Pyro, Reptile, Rock, Sea_Serpent, Spellcaster, Thunder, Warrior, Winged_Beast,
	Wyrm, Zombie;

	private final CardComponent cardComponent = CardComponent.MonsterType;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}