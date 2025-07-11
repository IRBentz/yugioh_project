package ygo_eng.card.component;

public enum CardComponent implements CardComponentInterface {
	Type, Icon, LinkArrow, MonsterAttribute, MonsterType, CardType;

	@Override
	public String getComponentName() {
		return this.name();
	}
}