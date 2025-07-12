package com.engine;

enum GlobalEnums {
	Monster(0), Pendulum(1), Fusion(2), Synchro(3), Xyz(4), Link(5), Spell(6), Trap(7);
	public final int index;
	GlobalEnums(int index) {
		this.index = index;
	}
}