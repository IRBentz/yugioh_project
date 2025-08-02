package com.card;

import com.card.component.LinkArrowComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class LinkMonCard extends ExtraMonCard implements CardInterfaces.ExtraCard {
	final LinkArrowComponent[] LINK_ARROWS;

	public LinkMonCard() {
		super();
		this.LINK_ARROWS = null;
	}

	public LinkMonCard(String name, int index, MonsterAttributeComponent mon_attri, MonsterTypeComponent mon_type, TypeComponent[] types,
			String summon_req, String lore, int link_rating, int attack, LinkArrowComponent[] link_arrows) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, link_rating, attack, link_rating);
		this.LINK_ARROWS = link_arrows;
	}

	public LinkArrowComponent[] getLinkArrows() {
		return LINK_ARROWS;
	}

	@Override
	public String toString() {
		String link_arrows = "";
		for (LinkArrowComponent link_arrow : LINK_ARROWS) {
			link_arrows += link_arrow.toString() + " ";
		}
		link_arrows = link_arrows.substring(0, link_arrows.length() - 1);
		return super.toString() + " | " + link_arrows;
	}
}