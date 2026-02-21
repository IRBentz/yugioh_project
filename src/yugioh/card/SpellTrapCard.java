package yugioh.card;

import java.util.Arrays;

import yugioh.card.component.CardTypeComponent;
import yugioh.card.component.IconComponent;

public class SpellTrapCard extends Card {
	private final IconComponent icon;

	public SpellTrapCard(String name, int index, CardTypeComponent cardType, String[] lore, IconComponent stIcon) {
		super(name, index, cardType, Arrays.asList(lore));
		icon = stIcon;
	}

	public IconComponent returnIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + icon;
	}
}
