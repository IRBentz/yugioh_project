package com.card;

import java.util.ArrayList;

import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class XyzMonCard extends ExtraMonCard {
	private ArrayList<Card> xyzMaterials = new ArrayList<>();

	public XyzMonCard() {
		super();
	}

	public XyzMonCard(String name, int index, MonsterAttributeComponent mon_attri, MonsterTypeComponent mon_type, TypeComponent[] types, String summon_req,
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