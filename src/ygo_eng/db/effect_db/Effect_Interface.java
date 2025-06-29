package ygo_eng.db.effect_db;

public interface Effect_Interface {
	public boolean check_conditions(int num);
	public void execute_effect(int num);
	public int get_num_effect();
}
