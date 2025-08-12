package com.card;

public class XyzMonCard extends ExtraMonCard implements CardInterfaces.ExtraCard {
	private final int rank;
	public XyzMonCard(String name, int index, MonComBlock mCB, String summonReq, String lore, int[] rankAtkDef) {
		super(name, index, mCB, summonReq, lore, rankAtkDef);
		this.rank = rankAtkDef[0];
	}
	
	@Override
	public int getLevel() throws UnsupportedOperationException{
		return 0;
	}
	
	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}