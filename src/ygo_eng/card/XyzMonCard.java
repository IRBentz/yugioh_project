package ygo_eng.card;

import java.util.ArrayList;

public class XyzMonCard extends ExtraMonCard {
	private ArrayList<Card> xyzMaterials = new ArrayList<>();

	public XyzMonCard() {
		super();
	}

	public XyzMonCard(String name, int index, MonAttribute mon_attri, MonType mon_type, Type[] types, String summon_req,
			String lore, int rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, rank, attack, defense);
	}

	public ArrayList<Card> getXyzMats() {
		return xyzMaterials;
	}

	@Override
	public String toString() {
		String xyzMats = "";
		for (Card mat : xyzMaterials)
			xyzMats += mat.toString() + " ";
		if (xyzMats.length() > 0)
			xyzMats = xyzMats.substring(0, xyzMats.length() - 1);
		return super.toString() + " | " + xyzMats;
	}
}