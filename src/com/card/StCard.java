package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.IconComponent;

public abstract class StCard extends Card {
	private final IconComponent ICON;

	public StCard() {
		super();
		this.ICON = null;
	}

	public StCard(String name, int index, CardTypeComponent cardType, String lore, IconComponent st_icon) {
		super(name, index, cardType, lore);
		this.ICON = st_icon;
	}

	public IconComponent returnIcon() {
		return ICON;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + ICON;
	}
}