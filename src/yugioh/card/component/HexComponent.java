package yugioh.card.component;

import java.util.HexFormat;

public class HexComponent {
	private byte[] hexLiteral;
	
	public HexComponent(String hexLiteralString) {
		hexLiteralString = hexLiteralString.substring(2);
		if(hexLiteralString.length() % 2 != 0)
			hexLiteralString = "0" + hexLiteralString;
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
