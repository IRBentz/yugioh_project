package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public class TrapCard extends StCard {

	public TrapCard(String name, int index, String lore, IconComponent stIcon) {
		super(name, index, CardTypeComponent.Trap, lore, stIcon);
	}
}