package com.testing;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.card.component.ArchitypeComponent;

public abstract class ArchitypeHexEnumParser {
	public static int archtypeHexParseInt(ArchitypeComponent.HexCode hexCode) {
		return Integer.parseInt(archtypeHexParseString(hexCode), 16);
	}
	
	public static String archtypeHexParseString(ArchitypeComponent.HexCode hexCode) {
		return hexCode.name().substring(4).replace("_", "");
	}
	
	public static void main(String[] args) {
		for(ArchitypeComponent a : ArchitypeComponent.class.getEnumConstants())
			Logger.getLogger(ArchitypeHexEnumParser.class.getName()).log(Level.INFO, archtypeHexParseString(a.getHexCode()));
	}

}
