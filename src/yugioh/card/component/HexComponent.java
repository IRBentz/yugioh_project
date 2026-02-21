package yugioh.card.component;

import java.util.HexFormat;

public class HexComponent {
	private byte[] hexLiteral;
	
	public HexComponent(String hexLiteralString) {
		hexLiteral = HexFormat.of().parseHex(hexLiteralString);
	}
	
	public int getInt() {
		return Integer.parseInt(getLiteralString(), 16);
	}
	
	public String getLiteralString() {
		return HexFormat.of().formatHex(hexLiteral);
	}
	
	public byte[] getRawBytes() {
		return hexLiteral;
	}
}
