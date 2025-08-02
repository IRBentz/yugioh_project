package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public class SpellCard extends StCard {
	public SpellCard() {
		super();
	}

	public SpellCard(String name, int index, String lore, IconComponent st_icon) {
		super(name, index, CardTypeComponent.Spell, lore, st_icon);
	}
}