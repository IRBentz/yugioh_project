package ygo_eng.card;

public enum CardComponent implements CardComponentInterface {
	Type, Architype, Icon, LinkArrow, MonsterAttribute, MonsterType, CardType;

	@Override
	public String getClassName() {
		return this.name();
	}

}

enum Component implements CardComponentInterface {
	Effect(CardComponent.Type), Flip(CardComponent.Type), Fusion(CardComponent.Type), Gemini(CardComponent.Type), 
	Link(CardComponent.Type), Normal(CardComponent.Type), Pendulum(CardComponent.Type), Ritual(CardComponent.Type), 
	Spirit(CardComponent.Type), Synchro(CardComponent.Type), Toon(CardComponent.Type), Tuner(CardComponent.Type), 
	Union(CardComponent.Type), Xyz(CardComponent.Type),
	
	
	;
	
	private final CardComponent cardComponent;
	enum hexCode {
		
	}
	private Component(CardComponent cardComponent) {
		this.cardComponent = cardComponent;
	}
	
	private Component(int hexCode, CardComponent cardComponent) {
		
	}
	
	public String getClassName() {
		return cardComponent.getClassName();
	}
	
	public String getComponentName() {
		return this.name();
	}
}
