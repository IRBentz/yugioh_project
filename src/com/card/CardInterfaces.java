package com.card;

public abstract interface CardInterfaces {
	public interface PenCard {
		int getPendLevel();
		String getPendLore();
	}
	
	public interface ExtraCard {
		String getSumMonsterReq();
	}
}
