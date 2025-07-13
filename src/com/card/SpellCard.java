package com.card;

import static com.card.component.CardTypeComponent.Spell;

import com.card.component.IconComponent;

public class SpellCard extends StCard {
	public SpellCard() {
		super();
	}

	public SpellCard(String name, int index, String lore, IconComponent st_icon) {
		super(name, index, Spell, lore, st_icon);
	}
}