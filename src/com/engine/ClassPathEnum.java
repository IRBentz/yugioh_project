package com.engine;

public enum ClassPathEnum {
	EffectDB("com.db.effect_db."),  Component("com.card.component.");
	public final String path;
	private ClassPathEnum(String path) {
		this.path = path;
	}
}
