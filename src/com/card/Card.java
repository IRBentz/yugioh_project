package com.card;

import java.util.ArrayList;

import com.card.component.ArchitypeComponent;
import com.card.component.CardTypeComponent;

public abstract class Card {
	private ArchitypeComponent[] architype;
	private final int CARD_IND;
	private int max_copies_allowed = 3;
	private final String NAME, LORE;
	private final CardTypeComponent TYPE;
	private Class<?> boundClass;

	public Card() {
		this.NAME = null;
		this.TYPE = null;
		this.CARD_IND = 0;
		this.LORE = null;
		this.max_copies_allowed = 0;
	}

	public Card(String name, int index, CardTypeComponent type, String lore) {
		this.NAME = name;
		this.CARD_IND = index;
		this.TYPE = type;
		this.LORE = lore;
	}

	public int getAllowedCopies() {
		return max_copies_allowed;
	}

	public ArchitypeComponent[] getArchitype() {
		return architype;
	}
	
	public Class<?> getBoundClass() {
		return boundClass;
	}

	public int getIndex() {
		return CARD_IND;
	}

	public String getLore() {
		return LORE;
	}

	public String getName() {
		return NAME;
	}

	public CardTypeComponent getType() {
		return TYPE;
	}

	public void setAllowedCopies(int newAmount) {
		max_copies_allowed = newAmount;
	}

	public void setArchitype(ArrayList<ArchitypeComponent> architype) {
		this.architype = architype.toArray(ArchitypeComponent[]::new);
	}
	
	public void setBoundClass(Class<?> clazz) {
		this.boundClass = clazz;
	}

	@Override
	public String toString() {
		return String.format("%08d", CARD_IND) + " | " + max_copies_allowed + " | " + NAME + " | " + TYPE + " | "
				+ LORE;
	}
}