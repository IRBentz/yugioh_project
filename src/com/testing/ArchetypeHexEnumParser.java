package com.testing;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.card.component.ArchetypeComponent;

public class ArchetypeHexEnumParser {
	public static int archetypeHexParseInt(ArchetypeComponent.HexCode hexCode) {
		return Integer.parseInt(archetypeHexParseString(hexCode), 16);
	}
	
	public static String archetypeHexParseString(ArchetypeComponent.HexCode hexCode) {
		return hexCode.name().substring(4).replace("_", "");
	}
	
	public static void main(String[] args) {
		for(ArchetypeComponent a : ArchetypeComponent.class.getEnumConstants())
			Logger.getLogger(ArchetypeHexEnumParser.class.getName()).log(Level.INFO, () -> archetypeHexParseString(a.getHexCode()));
	}
	
	protected ArchetypeHexEnumParser() {
	}
}
