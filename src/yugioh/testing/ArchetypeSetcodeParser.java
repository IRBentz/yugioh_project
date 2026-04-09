package yugioh.testing;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import yugioh.card.component.HexComponent;

public class ArchetypeSetcodeParser {
	static ArrayList<ArchetypeSetcode> archetypeSetcodeArrayList = new ArrayList<>();
	public static void main(String[] args) {
		Path archtypeSetcodeLuaPath = FileSystems.getDefault().getPath("CardScripts//archetype_setcode_constants.lua");
		ArrayList<String> importedLua;
		try {
			importedLua = new ArrayList<>(Files.readAllLines(archtypeSetcodeLuaPath));
			boolean flag = false;
			for(String line : importedLua) {
				if(line.startsWith("--")) {
					flag = !flag;
					continue;
				}
				if(!flag) {
					//System.out.println(line);
					parseLineToArchetypeSetCode(line);
				}
			}
			
			archetypeSetcodeArrayList.forEach(obj -> Arrays.asList(obj).forEach(System.out::println));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void parseLineToArchetypeSetCode(String line) {
		String[] splitLines = line.split("\\= ");
		Arrays.asList(splitLines).forEach(String::strip);
		//Arrays.asList(splitLines).forEach(System.out::println);
		if((splitLines.length == 2)) 
			archetypeSetcodeArrayList.add(new ArchetypeSetcode(splitLines[0], splitLines[1]));
	}
}

class ArchetypeSetcode {
	String setName;
	HexComponent hexComponent;
	
	public ArchetypeSetcode(String setName, String hexComponent) {
		this.setName = setName;
		this.hexComponent = new HexComponent(hexComponent);
	}
	
	public String toString() {
		return setName + "0x" + hexComponent.getLiteralString();
	}
}
