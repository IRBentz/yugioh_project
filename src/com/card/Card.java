package com.card;

import java.util.List;

import com.card.component.ArchetypeComponent;
import com.card.component.CardTypeComponent;

public class Card {
	private ArchetypeComponent[] archetype;
	private final int cardIndex;
	private final String name;
	private final String lore;
	private final CardTypeComponent type;
	private Class<?> boundEffectClass;

	protected Card(String name, int index, CardTypeComponent type, String lore) {
		this.name = name;
		this.cardIndex = index;
		this.type = type;
		this.lore = lore;
	}
	
	public ArchetypeComponent[] getArchitype() {
		return archetype;
	}
	
	public Class<?> getBoundClass() {
		return boundEffectClass;
	}

	public int getIndex() {
		return cardIndex;
	}

	public String getLore() {
		return lore;
	}

	public String getName() {
		return name;
	}

	public CardTypeComponent getType() {
		return type;
	}

	public void setArchitype(List<ArchetypeComponent> archetype) {
		this.archetype = archetype.toArray(ArchetypeComponent[]::new);
	}
	
	public void setBoundClass(Class<?> clazz) {
		this.boundEffectClass = clazz;
	}

	@Override
	public String toString() {
		return String.format("%08d", cardIndex) + " | " + name + " | " + type + " | "
				+ lore;
	}
}
