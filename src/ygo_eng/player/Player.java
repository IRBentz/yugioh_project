package ygo_eng.player;
import ygo_eng.card.EffectTarget;

public class Player implements EffectTarget{

	public Player() {
		
	}

	@Override
	public Object getEffectObject() {
		return this;
	}

}
