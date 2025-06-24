package ygo_eng.card;

import java.awt.Color;

public enum Type {
	EFFECT(186, 99, 55), FLIP, FUSION(119, 60, 158), GEMINI, LINK(22, 108, 160), NORMAL(35, 35, 11), PENDULUM,
	RITUAL(17, 16, 46), SPIRIT, SYNCHRO(220, 215, 211), TOON, TUNER, UNION, XYZ(27, 27, 28);

	public final Color bg_c;

	Type() {
		bg_c = new Color(0, 0, 0);
	}

	Type(Color c) {
		bg_c = c;
	}

	Type(int r, int g, int b) {
		bg_c = new Color(r, g, b);
	}
}