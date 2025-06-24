package ygo_eng.card;

public class LinkMonCard extends ExtraMonCard {
	final LinkArrow[] LINK_ARROWS;

	public LinkMonCard() {
		super();
		this.LINK_ARROWS = null;
	}

	public LinkMonCard(String name, int index, MonAttribute mon_attri, MonType mon_type, Type[] types,
			String summon_req, String lore, int link_rating, int attack, LinkArrow[] link_arrows) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, link_rating, attack, link_rating);
		this.LINK_ARROWS = link_arrows;
	}

	public LinkArrow[] getLinkArrows() {
		return LINK_ARROWS;
	}

	@Override
	public String toString() {
		String link_arrows = "";
		for (LinkArrow link_arrow : LINK_ARROWS) {
			link_arrows += link_arrow.toString() + " ";
		}
		link_arrows = link_arrows.substring(0, link_arrows.length() - 1);
		return super.toString() + " | " + link_arrows;
	}
}