package ygo_eng.card.component;

enum MonsterTypeComponent implements CardComponentInterface, CardSubcomponentInterface {
	Aqua(CardComponent.MonsterAttribute), Beast(CardComponent.MonsterAttribute), Beast_Warrior(CardComponent.MonsterAttribute), 
	Creator_God(CardComponent.MonsterAttribute), Cyberse(CardComponent.MonsterAttribute), Dinosaur(CardComponent.MonsterAttribute), 
	Divine_Beast(CardComponent.MonsterAttribute), Dragon(CardComponent.MonsterAttribute), Fairy(CardComponent.MonsterAttribute), 
	Fiend(CardComponent.MonsterAttribute), Fish(CardComponent.MonsterAttribute), Illusion(CardComponent.MonsterAttribute),
	Insect(CardComponent.MonsterAttribute), Machine(CardComponent.MonsterAttribute), Plant(CardComponent.MonsterAttribute), 
	Psychic(CardComponent.MonsterAttribute), Pyro(CardComponent.MonsterAttribute), Reptile(CardComponent.MonsterAttribute), 
	Rock(CardComponent.MonsterAttribute), Sea_Serpent(CardComponent.MonsterAttribute), Spellcaster(CardComponent.MonsterAttribute), 
	Thunder(CardComponent.MonsterAttribute), Warrior(CardComponent.MonsterAttribute), Winged_Beast(CardComponent.MonsterAttribute), 
	Wyrm(CardComponent.MonsterAttribute), Zombie(CardComponent.MonsterAttribute);

	private final CardComponent cardComponent;
	
	private MonsterTypeComponent(CardComponent cardComponent) {
		this.cardComponent = cardComponent;
	}
	
	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	@Override
	public String getName() {
		return this.name();
	}
}