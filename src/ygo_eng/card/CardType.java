package ygo_eng.card;

import java.awt.Color;

public enum CardType {
	MONSTER, SPELL(21, 148, 141), TOKEN(122, 116, 116), TRAP(21, 12, 116);

	public final Color bg_c;

	CardType() {
		bg_c = new Color(0, 0, 0);
	}

	CardType(Color c) {
		bg_c = c;
	}

	CardType(int r, int g, int b) {
		bg_c = new Color(r, g, b);
	}
}
