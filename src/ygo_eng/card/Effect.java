package ygo_eng.card;
import java.util.ArrayList;

public class Effect implements EffectTarget{
	private ArrayList<TargetTypes> targets;
	
	public Effect() {
		targets = new ArrayList<>();
	}
	
	public ArrayList<TargetTypes> getTargetTypes() {
		return targets;
	}

	@Override
	public Object getEffectObject() {
		return this;
	}
}