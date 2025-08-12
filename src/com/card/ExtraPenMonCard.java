package com.card;

public class ExtraPenMonCard extends ExtraMonCard implements CardInterfaces.PenCard, CardInterfaces.ExtraCard {
	private final PendAttributes pendulumAttributes;
	
	public ExtraPenMonCard(String name, int index, MonComBlock mCB, String[] sumReqlore, String pendulumLore, int[] levelAtkDef, int pendulumLevel) {
		super(name, index, mCB, sumReqlore[0], sumReqlore[1], levelAtkDef);
		this.pendulumAttributes = new PendAttributes(pendulumLore, pendulumLevel);
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
