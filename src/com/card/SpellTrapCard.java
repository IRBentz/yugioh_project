package com.card;

import java.util.Arrays;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public class SpellTrapCard extends Card {
	private final IconComponent icon;

	public SpellTrapCard(String name, int index, CardTypeComponent cardType, String[] lore, IconComponent stIcon) {
		super(name, index, cardType, Arrays.asList(lore));
		icon = stIcon;
	}

	public IconComponent returnIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + icon;
	}
}
