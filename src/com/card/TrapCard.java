package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public class TrapCard extends StCard {
	public TrapCard() {
		super();
	}

	public TrapCard(String name, int index, String lore, IconComponent st_icon) {
		super(name, index, CardTypeComponent.Trap, lore, st_icon);
	}
}