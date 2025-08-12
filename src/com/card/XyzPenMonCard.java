package com.card;

public class XyzPenMonCard extends XyzMonCard implements CardInterfaces.ExtraCard, CardInterfaces.PenCard {
	private final PendAttributes pendulumAttributes;

	public XyzPenMonCard(String name, int index, MonComBlock mCB, String summonReq, String lore, int[] rankAtkDef, PendAttributes pA) {
		super(name, index, mCB, summonReq, lore, rankAtkDef);
		this.pendulumAttributes = pA;
	}

	@Override
	public int getPendLevel() {
		return this.pendulumAttributes.pendLevel;
	}
	
	@Override
	public String getPendLore() {
		return this.pendulumAttributes.pendLore;
	}
	
	@Override
	public String toString() {
		return super.toString() + pendulumAttributes.toString();
	}
}
