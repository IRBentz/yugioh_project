package yugioh.card.component;

public enum MonsterTypeComponent implements CardComponentInterface.SubInterface {
	ALL(0x3ffffff), AQUA(0x40), BEAST(0x4000), BEAST_WARRIOR(0x8000), BEAST_B_WARRIOR_WING_B(0xc200), CREATOR_GOD(0x400000), CYBERSE(0x1000000), DINOSAUR(0x10000), DIVINE(0x20000), DIVINE_BEAST(0x20000), DRAGON(0x2000), FAIRY(0x4), FIEND(0x8), FISH(0x20000), ILLUSION(0x2000000),
	INSECT(0x800), MACHINE(0x20), PLANT(0x400), PSYCHIC(0x100000), PYRO(0x80), REPTILE(0x80000), ROCK(0x100), SEA_SERPENT(0x40000), SPELLCASTER(0x2), THUNDER(0x1000), WARRIOR(0x1), WINGED_BEAST(0x200),
	WYRM(0x800000), ZOMBIE(0x16);

	private final CardComponent cardComponent = CardComponent.MONSTER_TYPE;
	private final int dec;
	
	MonsterTypeComponent(int dec) {
		this.dec = dec;
	}
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	public CardComponentInterface match(int dec) {
		for(MonsterTypeComponent mtc : MonsterTypeComponent.class.getEnumConstants()) {
			if(mtc.dec == dec) {
				return mtc;
			}
		} 
		return null;
	}
}
