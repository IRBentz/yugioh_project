package com.testing;

import com.card.component.ArchitypeComponent;
import com.card.component.HexCode;

public abstract class ArchitypeHexEnumParser {
	public static int archtypeHexParseInt(HexCode hexCode) {
		return Integer.parseInt(archtypeHexParseString(hexCode), 16);
	}
	
	public static String archtypeHexParseString(HexCode hexCode) {
		return hexCode.name().substring(4).replace("_", "");
	}
	
	public static void main(String[] args) {
		for(ArchitypeComponent a : ArchitypeComponent.class.getEnumConstants())
			System.out.println(archtypeHexParseString(a.getHexCode()));
	}

}
