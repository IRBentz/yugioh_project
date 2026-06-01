package yugioh.card.component;

public class ArchetypeSetcodeComponent {
	String setName;
	HexComponent hexComponent;
	
	public ArchetypeSetcodeComponent(String setName, String hexComponent) {
		this.setName = setName;
		this.hexComponent = new HexComponent(hexComponent);
	}
	
	public String toString() {
		return setName + "0x" + hexComponent.getLiteralString();
	}
}
