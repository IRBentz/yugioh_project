package com.card;

import java.util.Arrays;

import com.card.component.CardTypeComponent;
import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class MonsterCard extends Card {
	public class ExtraAttributes {
		public class LinkAttributes {
			private final LinkArrowComponent[] linkArrows;
			private final int linkRating;

			/**
			 *
			 * @param linkArrows
			 */
			public LinkAttributes(LinkArrowComponent[] linkArrows) {
				this.linkArrows = linkArrows;
				linkRating = linkArrows.length;
			}

			public LinkArrowComponent[] getLinkArrows() {
				return linkArrows;
			}

			public int getLinkRating() {
				return linkRating;
			}

			@Override
			public String toString() {
				var sb = new StringBuilder();
				for (LinkArrowComponent linkArrow : linkArrows) {
					sb.append(linkArrow.toString()).append(" ");
				}
				return " | " + linkRating + " | " + sb.toString().strip();
			}
		}

		public class XyzAttributes {
			private final int rank;

			/**
			 *
			 * @param rank
			 */
			public XyzAttributes(int rank) {
				this.rank = rank;
			}

			public int getRank() {
				return rank;
			}

			@Override
			public String toString() {
				return " | " + rank;
			}
		}

		private final String summonReq;

		/**
		 *
		 * @param summonReq
		 */
		public ExtraAttributes(String summonReq) {
			this.summonReq = summonReq;
		}

		public String getSummonReq() {
			return summonReq;
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

		/**
		 *
		 * @param monsterAttribute
		 * @param monsterType
		 * @param types
		 */
		public MonComBlock(MonsterAttributeComponent monsterAttribute, MonsterTypeComponent monsterType,
				TypeComponent[] types) {
			mAttribute = monsterAttribute;
			mType = monsterType;
			this.types = types;
		}

		@Override
		public String toString() {
			var sb = new StringBuilder();
			for (TypeComponent type : getTypes()) {
				sb.append(type.toString()).append(' ');
			}
			return " | " + mAttribute + " | " + mType + " | " + sb.toString().strip();
		}
	}

	public class PendAttributes {
		public final int pendLevel;
		public final String pendLore;

		/**
		 *
		 * @param pendLore
		 * @param pendLevel
		 */
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

	/**
	 *
	 * @param name
	 * @param index
	 * @param lore
	 * @param level
	 * @param attack
	 * @param defense
	 */
	public MonsterCard(String name, int index, String[] lore, int level, int attack, int defense) {
		super(name, index, CardTypeComponent.MONSTER, Arrays.asList(lore));
		this.level = level;
		this.attack = attack;
		this.defense = defense;
	}

	/**
	 *
	 * @return
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 *
	 * @return
	 */
	public MonsterAttributeComponent getAttribute() {
		return monComBlock.mAttribute;
	}

	/**
	 *
	 * @return
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 *
	 * @return
	 */
	public ExtraAttributes getExtraAttributes() {
		return extraAttributes;
	}

	/**
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return
	 */
	public ExtraAttributes.LinkAttributes getLinkAttributes() {
		return linkAttributes;
	}

	/**
	 * @return
	 */
	public MonComBlock getMonComBlock() {
		return monComBlock;
	}

	/**
	 * @return
	 */
	public MonsterTypeComponent getMonType() {
		return monComBlock.mType;
	}

	/**
	 * @return
	 */
	public PendAttributes getPendulumAttributes() {
		return pendulumAttributes;
	}

	/**
	 * @return
	 */
	public TypeComponent[] getTypes() {
		return monComBlock.types;
	}

	/**
	 * @return
	 */
	public ExtraAttributes.XyzAttributes getXyzAttributes() {
		return xyzAttributes;
	}

	/**
	 * @param extraAttributes
	 */
	public void setExtraAttributes(ExtraAttributes extraAttributes) {
		this.extraAttributes = extraAttributes;
	}

	/**
	 * @param linkAttributes
	 */
	public void setLinkAttributes(ExtraAttributes.LinkAttributes linkAttributes) {
		this.linkAttributes = linkAttributes;
	}

	/**
	 * @param monComBlock
	 */
	public void setMonComBlock(MonComBlock monComBlock) {
		this.monComBlock = monComBlock;
	}

	/**
	 * @param pendulumAttributes
	 */
	public void setPendAttributes(PendAttributes pendulumAttributes) {
		this.pendulumAttributes = pendulumAttributes;
	}

	/**
	 * @param xyzAttributes
	 */
	public void setXyzAttributes(ExtraAttributes.XyzAttributes xyzAttributes) {
		this.xyzAttributes = xyzAttributes;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder(
				super.toString() + monComBlock.toString() + " | " + level + " | " + attack + " | " + defense);
		if (pendulumAttributes != null) {
			sb.append(pendulumAttributes.toString());
		}
		if (extraAttributes != null) {
			sb.append(extraAttributes.toString());
		}
		if (xyzAttributes != null) {
			sb.append(xyzAttributes.toString());
		}
		if (linkAttributes != null) {
			sb.append(linkAttributes.toString());
		}

		return sb.toString();
	}
}
