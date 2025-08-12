package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public class SpellCard extends StCard {

	public SpellCard(String name, int index, String lore, IconComponent stIcon) {
		super(name, index, CardTypeComponent.Spell, lore, stIcon);
	}
}