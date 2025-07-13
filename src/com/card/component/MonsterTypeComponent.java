package com.card.component;

import static com.card.component.CardComponent.MonsterType;

public enum MonsterTypeComponent implements CardSubcomponentInterface {
	Aqua, Beast, Beast_Warrior, Creator_God, Cyberse, Dinosaur, Divine_Beast, Dragon, Fairy, Fiend, Fish, Illusion,
	Insect, Machine, Plant, Psychic, Pyro, Reptile, Rock, Sea_Serpent, Spellcaster, Thunder, Warrior, Winged_Beast,
	Wyrm, Zombie;

	private final CardComponent cardComponent = MonsterType;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public String getName() {
		return this.name();
	}

	@Override
	public MonsterTypeComponent match(String name) {
		for (MonsterTypeComponent monsterTypeComponent : MonsterTypeComponent.class.getEnumConstants())
			if (monsterTypeComponent.name().equals(name))
				return monsterTypeComponent;
		return null;
	}
}