package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class MonsterCard extends Card {
	public class ExtraAttributes {
		public class LinkAttributes {
			public final LinkArrowComponent[] linkArrows;
			public final int linkRating;

			public LinkAttributes(LinkArrowComponent[] linkArrows) {
				this.linkArrows = linkArrows;
				this.linkRating = linkArrows.length;
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				for (LinkArrowComponent linkArrow : linkArrows) {
					sb.append(linkArrow.toString()).append(" ");
				}
				return " | " + linkRating + " | " + sb.toString().strip();
			}
		}

		public class XyzAttributes {
			public final int rank;

			public XyzAttributes(int rank) {
				this.rank = rank;
			}

			@Override
			public String toString() {
				return " | " + rank;
			}
		}

		public final String summonReq;

		public ExtraAttributes(String summonReq) {
			this.summonReq = summonReq;
		}

		@Override
		public String toString() {
			return " | " + summonReq;
		}
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

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (TypeComponent type : getTypes()) {
				sb.append(type.toString()).append(' ');
			}
			return " | " + mAttribute + " | " + mType + " | " + sb.toString().strip();
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

	private final int level;
	private final int attack;
	private final int defense;
	private MonComBlock monComBlock;
	private PendAttributes pendulumAttributes;
	private ExtraAttributes extraAttributes;
	private ExtraAttributes.XyzAttributes xyzAttributes;
	private ExtraAttributes.LinkAttributes linkAttributes;

	public MonsterCard(String name, int index, String lore, int level, int attack, int defense) {
		super(name, index, CardTypeComponent.MONSTER, lore);
		this.level = level;
		this.attack = attack;
		this.defense = defense;
	}

	public int getAttack() {
		return attack;
	}

	public MonsterAttributeComponent getAttribute() {
		return monComBlock.mAttribute;
	}

	public int getDefense() {
		return defense;
	}

	public ExtraAttributes getExtraAttributes() {
		return this.extraAttributes;
	}

	public int getLevel() {
		return level;
	}

	public ExtraAttributes.LinkAttributes getLinkAttributes() {
		return this.linkAttributes;
	}

	public MonComBlock getMonComBlock() {
		return this.monComBlock;
	}

	public MonsterTypeComponent getMonType() {
		return monComBlock.mType;
	}

	public PendAttributes getPendulumAttributes() {
		return this.pendulumAttributes;
	}

	public TypeComponent[] getTypes() {
		return monComBlock.types;
	}

	public ExtraAttributes.XyzAttributes getXyzAttributes() {
		return this.xyzAttributes;
	}

	public void setExtraAttributes(ExtraAttributes extraAttributes) {
		this.extraAttributes = extraAttributes;
	}

	public void setLinkAttributes(ExtraAttributes.LinkAttributes linkAttributes) {
		this.linkAttributes = linkAttributes;
	}

	public void setMonComBlock(MonComBlock monComBlock) {
		this.monComBlock = monComBlock;
	}

	public void setPendAttributes(PendAttributes pendulumAttributes) {
		this.pendulumAttributes = pendulumAttributes;
	}

	public void setXyzAttributes(ExtraAttributes.XyzAttributes xyzAttributes) {
		this.xyzAttributes = xyzAttributes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString() + monComBlock.toString() + " | " + level + " | " + attack + " | " + defense);
		if (pendulumAttributes != null)
			sb.append(pendulumAttributes.toString());
		if (extraAttributes != null)
			sb.append(extraAttributes.toString());
		if (xyzAttributes != null)
			sb.append(xyzAttributes.toString());
		if (linkAttributes != null)
			sb.append(linkAttributes.toString());
		
		return sb.toString();
	}
}
