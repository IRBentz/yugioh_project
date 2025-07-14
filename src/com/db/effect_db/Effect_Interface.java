package com.db.effect_db;

public interface Effect_Interface {
	public boolean[] check_conditions();
	public void execute_effect(int num);
	public int get_num_effect();
}
