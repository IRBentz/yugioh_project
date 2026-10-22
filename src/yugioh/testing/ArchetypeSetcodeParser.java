package yugioh.testing;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import yugioh.card.component.ArchetypeSetcodeComponent;

public class ArchetypeSetcodeParser {
	static ArrayList<ArchetypeSetcodeComponent> archetypeSetcodeArrayList = new ArrayList<>();
	public static void main(String[] args) {
		Path archtypeSetcodeLuaPath = FileSystems.getDefault().getPath("CardScripts//archetype_setcode_constants.lua");
		ArrayList<String> importedLua;
		try {
			importedLua = new ArrayList<>(Files.readAllLines(archtypeSetcodeLuaPath));
			boolean flag = false;
			for(String line : importedLua) {
				if(line.startsWith("--[[") || line.startsWith("--]]")) {
					flag = !flag;
					continue;
				}
				if(!(flag || line.startsWith("--"))) {
					//System.out.println(line);
					parseLineToArchetypeSetCode(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void parseLineToArchetypeSetCode(String line) {
		String[] splitLine = line.split("\\= ");
		splitLine[0] = splitLine[0].strip();
		if(splitLine.length == 2)
			splitLine[1] = splitLine[1].strip();
		if((splitLine.length == 2))
			archetypeSetcodeArrayList.add(new ArchetypeSetcodeComponent(splitLine[0], Integer.decode(splitLine[1])));
	}
}
