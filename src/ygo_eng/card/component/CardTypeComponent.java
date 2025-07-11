package ygo_eng.card.component;

enum CardTypeComponent implements CardComponentInterface, CardSubcomponentInterface {
	Monster(CardComponent.CardType), Spell(CardComponent.CardType), Token(CardComponent.CardType), Trap(CardComponent.CardType);

	private final CardComponent cardComponent;
	
	private CardTypeComponent(CardComponent cardComponent) {
		this.cardComponent = cardComponent;
	}
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	@Override
	public String getName() {
		return this.name();
	}
}