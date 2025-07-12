package com.card;

public abstract class StCard extends Card {
	private final Icon ICON;

	public StCard() {
		super();
		this.ICON = null;
	}

	public StCard(String name, int index, CardType cardType, String lore, Icon st_icon) {
		super(name, index, cardType, lore);
		this.ICON = st_icon;
	}

	public Icon returnIcon() {
		return ICON;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + ICON;
	}
}