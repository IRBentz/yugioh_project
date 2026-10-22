package yugioh.card.component;

public class ArchetypeSetcodeComponent implements CardComponentInterface.SubInterface {
	private final CardComponent cardComponent = CardComponent.ARCHETYPE;
	String setName;
	int numericIden;
	
	public ArchetypeSetcodeComponent(String setName, int numericIden) {
		this.setName = setName;
		this.numericIden = numericIden;
	}

	@Override
	public String getComponentName() { return cardComponent.getComponentName(); }

	@Override
	public String toString() {
		return setName + " " + Integer.toHexString(numericIden);
	}
}
