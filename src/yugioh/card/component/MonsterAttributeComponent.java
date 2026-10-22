package yugioh.card.component;

public enum MonsterAttributeComponent implements CardComponentInterface.SubInterface {
	EARTH(0x1), WATER(0x2), FIRE(0x4), WIND(0x8), LIGHT(0x10), DARK(0x20), DIVINE(0x40);

	private final CardComponent cardComponent = CardComponent.MONSTER_ATTRIBUTE;

	final int numericIden;
	public int getNumericIden() {
		return numericIden;
	}

	MonsterAttributeComponent(final int numericIden) {
		this.numericIden = numericIden;
	}

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}

/*
ATTRIBUTE_EARTH  = 0x1
ATTRIBUTE_WATER  = 0x2
ATTRIBUTE_FIRE   = 0x4
ATTRIBUTE_WIND   = 0x8
ATTRIBUTE_LIGHT  = 0x10
ATTRIBUTE_DARK   = 0x20
ATTRIBUTE_DIVINE = 0x40
 */
