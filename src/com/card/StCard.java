package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public abstract class StCard extends Card {
	private final IconComponent icon;

	protected StCard(String name, int index, CardTypeComponent cardType, String lore, IconComponent stIcon) {
		super(name, index, cardType, lore);
		this.icon = stIcon;
	}

	public IconComponent returnIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + icon;
	}
}