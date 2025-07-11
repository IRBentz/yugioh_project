package ygo_eng.card.component;

enum IconComponent implements CardComponentInterface, CardSubcomponentInterface {
	Continuous(CardComponent.Icon), Counter(CardComponent.Icon), Equip(CardComponent.Icon), Field(CardComponent.Icon), Normal(CardComponent.Icon), QuickPlay(CardComponent.Icon), Ritual(CardComponent.Icon);
	
	private final CardComponent cardComponent;
	
	private IconComponent(CardComponent cardComponent) {
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