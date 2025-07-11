package ygo_eng.card.component;

enum TypeComponent implements CardComponentInterface, CardSubcomponentInterface {
	Effect(CardComponent.Type), Flip(CardComponent.Type), Fusion(CardComponent.Type), Gemini(CardComponent.Type), 
	Link(CardComponent.Type), Normal(CardComponent.Type), Pendulum(CardComponent.Type), Ritual(CardComponent.Type), 
	Spirit(CardComponent.Type), Synchro(CardComponent.Type), Toon(CardComponent.Type), Tuner(CardComponent.Type), 
	Union(CardComponent.Type), Xyz(CardComponent.Type);
	
	private final CardComponent cardComponent;
	
	private TypeComponent(CardComponent cardComponent) {
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