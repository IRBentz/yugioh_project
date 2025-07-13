package com.card;

import static com.card.component.CardTypeComponent.Trap;

import com.card.component.IconComponent;

public class TrapCard extends StCard {
	public TrapCard() {
		super();
	}

	public TrapCard(String name, int index, String lore, IconComponent st_icon) {
		super(name, index, Trap, lore, st_icon);
	}
}