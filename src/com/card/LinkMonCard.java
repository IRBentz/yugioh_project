package com.card;

import com.card.component.LinkArrowComponent;

public class LinkMonCard extends ExtraMonCard implements CardInterfaces.ExtraCard {
	private final LinkArrowComponent[] linkArrows;
	private final int linkRating;

	public LinkMonCard(String name, int index, MonComBlock mCB, String[] sumReqLore, int linkRating, int attack, LinkArrowComponent[] linkArrows) {
		super(name, index, mCB, sumReqLore[0], sumReqLore[1], new int[] {0, attack, 0});
		this.linkArrows = linkArrows;
		this.linkRating = linkRating;
	}

	public LinkArrowComponent[] getLinkArrows() {
		return linkArrows;
	}

	public int getLinkRating() {
		return linkRating;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (LinkArrowComponent linkArrow : linkArrows) {
			sb.append(linkArrow.toString()).append(" ");
		}
		return super.toString() + " | " + " | " + sb.toString().strip();
	}
}