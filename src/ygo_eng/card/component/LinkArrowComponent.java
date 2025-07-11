package ygo_eng.card.component;

enum LinkArrowComponent implements CardComponentInterface, CardSubcomponentInterface {
	Down(CardComponent.LinkArrow), DownLeft(CardComponent.LinkArrow), DownRight(CardComponent.LinkArrow), Left(CardComponent.LinkArrow), 
	Right(CardComponent.LinkArrow), Up(CardComponent.LinkArrow), UpLeft(CardComponent.LinkArrow), UpRight(CardComponent.LinkArrow);

	LinkArrowComponent(CardComponent cardComponent) {
		this.cardComponent = cardComponent;
	}
	
	private final CardComponent cardComponent;

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}
	
	@Override
	public String getName() {
		return this.name();
	}
}