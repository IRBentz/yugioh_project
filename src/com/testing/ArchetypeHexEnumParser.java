package com.testing;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.card.component.ArchetypeComponent;

public abstract class ArchetypeHexEnumParser {
	public static int archtypeHexParseInt(ArchetypeComponent.HexCode hexCode) {
		return Integer.parseInt(archtypeHexParseString(hexCode), 16);
	}
	
	public static String archtypeHexParseString(ArchetypeComponent.HexCode hexCode) {
		return hexCode.name().substring(4).replace("_", "");
	}
	
	public static void main(String[] args) {
		for(ArchetypeComponent a : ArchetypeComponent.class.getEnumConstants())
			Logger.getLogger(ArchetypeHexEnumParser.class.getName()).log(Level.INFO, archtypeHexParseString(a.getHexCode()));
	}

}
