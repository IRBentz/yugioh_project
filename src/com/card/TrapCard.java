package com.card;

public class TrapCard extends StCard {
	public TrapCard() {
		super();
	}

	public TrapCard(String name, int index, String lore, Icon st_icon) {
		super(name, index, CardType.TRAP, lore, st_icon);
	}
}