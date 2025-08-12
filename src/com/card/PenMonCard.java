package com.card;

public class PenMonCard extends MonCard implements CardInterfaces.PenCard {
	private final PendAttributes pendulumAttributes;

	public PenMonCard(String name, int index, MonComBlock mCB, String pendLore, String lore, int[] lAD, int pendLevel) {
		super(name, index, mCB, lore, lAD[0], lAD[1], lAD[2]);
		pendulumAttributes = new PendAttributes(pendLore, pendLevel);
	}

	@Override
	public int getPendLevel() {
		return pendulumAttributes.pendLevel;
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