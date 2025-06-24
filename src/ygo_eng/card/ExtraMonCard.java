package ygo_eng.card;

public class ExtraMonCard extends MonCard {
	final String SUMMON_REQ;

	public ExtraMonCard() {
		super();
		this.SUMMON_REQ = null;
	}

	public ExtraMonCard(String name, int index, MonAttribute mon_attri, MonType mon_type, Type[] types,
			String summon_req, String lore, int level_rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.SUMMON_REQ = summon_req;
	}

	public String getSummonReq() {
		return SUMMON_REQ;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + SUMMON_REQ;
	}
}