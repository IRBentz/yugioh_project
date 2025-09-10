package com.db.effect_db;

public interface EffectInterface {
	boolean[] checkConditions();

	void executeEffect(int num);

	int getNumEffect();
}
