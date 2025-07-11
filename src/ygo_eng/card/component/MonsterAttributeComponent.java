package ygo_eng.card.component;

enum MonsterAttributeComponent implements CardComponentInterface, CardSubcomponentInterface {
	Dark(CardComponent.MonsterAttribute), Divine(CardComponent.MonsterAttribute), Earth(CardComponent.MonsterAttribute), 
	Fire(CardComponent.MonsterAttribute), Light(CardComponent.MonsterAttribute), Water(CardComponent.MonsterAttribute), 
	Wind(CardComponent.MonsterAttribute);

	private final CardComponent cardComponent;
	
	private MonsterAttributeComponent(CardComponent cardComponent) {
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