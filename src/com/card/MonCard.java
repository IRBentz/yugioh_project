package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class MonCard extends Card {
	private final int level;
	private final int attack;
	private final int defense;
	private MonComBlock monsterComponentBlock;

	public MonCard(String name, int index, MonComBlock mCB, String lore, int level, int attack, int defense) {
		super(name, index, CardTypeComponent.Monster, lore);
		this.monsterComponentBlock = mCB;
		this.level = level;
		this.attack = attack;
		this.defense = defense;
	}

	public int getAttack() {
		return attack;
	}

	public MonsterAttributeComponent getAttribute() {
		return monsterComponentBlock.mAttribute;
	}

	public int getDefense() {
		return defense;
	}

	public int getLevel() {
		return level;
	}

	public MonsterTypeComponent getMonType() {
		return monsterComponentBlock.mType;
	}

	public TypeComponent[] getTypes() {
		return monsterComponentBlock.types;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (TypeComponent type : getTypes()) {
			sb.append(type.toString()).append(' ');
		}

		return super.toString() + " | " + getAttribute() + " | " + getType() + " | " + sb.toString().strip() + " | " + level + " | "
				+ attack + " | " + defense;
	}
	
	public class MonComBlock {
		public final MonsterAttributeComponent mAttribute;
		public final MonsterTypeComponent mType;
		public final TypeComponent[] types;
		
		public MonComBlock(MonsterAttributeComponent mA, MonsterTypeComponent mT, TypeComponent[] types) {
			this.mAttribute = mA;
			this.mType = mT;
			this.types = types;
		}
	}
	
	public class PendAttributes {
		public final int pendLevel;
		public final String pendLore;
		
		public PendAttributes(String pendLore, int pendLevel) {
			this.pendLevel = pendLevel;
			this.pendLore = pendLore;
		}
		
		@Override
		public String toString() {
			return " | " + pendLevel + " | " + pendLore;
		}
	}
}