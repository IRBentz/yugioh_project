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

	/**
	 * @param name
	 * @param index
	 * @param type
	 * @param lore
	 */
	protected Card(String name, int index, CardTypeComponent type, String lore) {
		this.name = name;
		cardIndex = index;
		this.type = type;
		this.lore = lore;
	}

	/**
	 * @return
	 */
	public ArchetypeComponent[] getArchitype() {
		return archetype;
	}

	/**
	 * @return
	 */
	public Class<?> getBoundClass() {
		return boundEffectClass;
	}

	/**
	 * @return
	 */
	public int getIndex() {
		return cardIndex;
	}

	/**
	 * @return
	 */
	public String getLore() {
		return lore;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public CardTypeComponent getType() {
		return type;
	}

	/**
	 * @param archetype
	 */
	public void setArchitype(List<ArchetypeComponent> archetype) {
		this.archetype = archetype.toArray(ArchetypeComponent[]::new);
	}

	/**
	 * @param clazz
	 */
	public void setBoundClass(Class<?> clazz) {
		boundEffectClass = clazz;
	}

	@Override
	public String toString() {
		return String.format("%08d", cardIndex) + " | " + name + " | " + type + " | " + lore;
	}
}
