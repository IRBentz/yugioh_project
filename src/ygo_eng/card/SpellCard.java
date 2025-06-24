package ygo_eng.card;

public class SpellCard extends StCard {
	public SpellCard() {
		super();
	}

	public SpellCard(String name, int index, String lore, Icon st_icon) {
		super(name, index, CardType.SPELL, lore, st_icon);
	}
}