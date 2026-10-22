package yugioh.card.component;

public enum CardTypeComponent implements CardComponentInterface.SubInterface {
	MONSTER(0x1), SPELL(0x2), TRAP(0x4), TOKEN(0x4000);

	final int numericIden;
	public int getNumericIden() {
		return numericIden;
	}

	CardTypeComponent(final int numericIden) {
		this.numericIden = numericIden;
	}

	private final CardComponent cardComponent = CardComponent.CARD_TYPE;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
}

/*

 */
