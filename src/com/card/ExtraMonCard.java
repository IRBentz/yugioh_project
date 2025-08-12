package com.card;

public class ExtraMonCard extends MonCard implements CardInterfaces.ExtraCard {
	final String summonReq;

	public ExtraMonCard(String name, int index, MonComBlock mCB, String summonReq, String lore, int[] lAD) {
		super(name, index, mCB, lore, lAD[0], lAD[1], lAD[2]);
		this.summonReq = summonReq;
	}
	
	@Override
	public String getSumMonsterReq() {
		return summonReq;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + summonReq;
	}
}