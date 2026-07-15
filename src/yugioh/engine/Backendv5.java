package yugioh.engine;

import yugioh.card.Card;
import yugioh.card.MonsterCard;
import yugioh.card.SpellTrapCard;

public class Backendv5 implements DBBuilderInterface {

	@Override
	public void buildDB() {
		final String databasePath = "jdbc:sqlite:BabelCDB/cards.cdb";
	}

	@Override
	public MonsterCard buildExtraMonster() {
		
		return null;
	}

	@Override
	public MonsterCard buildLinkMonster() {
		
		return null;
	}

	@Override
	public MonsterCard buildMonster() {
		
		return null;
	}

	@Override
	public void attachPendulumAttributes(MonsterCard monCard) {
		
		
	}

	@Override
	public MonsterCard buildPendulumExtraMonster() {
		
		return null;
	}

	@Override
	public MonsterCard buildPendulumMonster() {
		
		return null;
	}

	@Override
	public MonsterCard buildPendulumXyzMonster() {
		
		return null;
	}

	@Override
	public SpellTrapCard buildSpellTrap() {
		
		return null;
	}

	@Override
	public MonsterCard buildXyzMonster() {
		
		return null;
	}

	@Override
	public Card getBuiltCard() {
		
		return null;
	}

}
