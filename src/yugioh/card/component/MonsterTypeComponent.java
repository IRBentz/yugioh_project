package yugioh.card.component;

public enum MonsterTypeComponent implements CardComponentInterface.SubInterface {
	ALL(0x3ffffff), WARRIOR(0x1), SPELLCASTER(0x2), FAIRY(0x4), FIEND(0x8), ZOMBIE(0x16), MACHINE(0x20),
	AQUA(0x40), PYRO(0x80), ROCK(0x100), WINGED_BEAST(0x200), PLANT(0x400), INSECT(0x800), THUNDER(0x1000),
	DRAGON(0x2000), BEAST(0x4000), BEAST_WARRIOR(0x8000), DINOSAUR(0x10000), FISH(0x20000), SEA_SERPENT(0x40000),
	REPTILE(0x80000), PSYCHIC(0x100000), DIVINE(0x20000), CREATOR_GOD(0x400000), WYRM(0x800000), CYBERSE(0x1000000),
	ILLUSION(0x2000000), BEAST_B_WARRIOR_WING_B(0xc200);

	private final CardComponent cardComponent = CardComponent.MONSTER_TYPE;
	final int numericIden;
	public int getNumericIden() {
		return numericIden;
	}

	MonsterTypeComponent(final int numericIden) { this.numericIden = numericIden; }
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	public CardComponentInterface match(int numericIden) {
		for(MonsterTypeComponent mtc : MonsterTypeComponent.class.getEnumConstants()) {
			if(mtc.numericIden == numericIden) {
				return mtc;
			}
		} 
		return null;
	}
}
