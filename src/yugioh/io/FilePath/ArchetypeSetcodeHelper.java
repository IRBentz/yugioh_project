package yugioh.io.FilePath;

import yugioh.card.component.ArchetypeSetcodeComponent;
import yugioh.engine.Global;
import yugioh.engine.HelperInterface;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchetypeSetcodeHelper implements HelperInterface {
    private static final Logger logger = Logger.getLogger(ArchetypeSetcodeHelper.class.toString());
    static Path archtypeSetcodeLuaPath = FileSystems.getDefault().getPath("CardScripts//archetype_setcode_constants.lua");
    @Override
    public void run() {
        ArrayList<String> importedLua;
        try {
            importedLua = new ArrayList<>(Files.readAllLines(archtypeSetcodeLuaPath));
            boolean flag = false;
            for(String line : importedLua) {
                if(line.startsWith("--[[") || line.startsWith("--]]")) {
                    flag = !flag;
                    continue;
                }
                if(!(flag || line.startsWith("--"))) { parseLineToArchetypeSetCode(line); }
            }
        } catch (IOException e) {
            ArchetypeSetcodeHelper.logger.log(Level.SEVERE, "An Exception Occurred", e);
        }
    }
    static void parseLineToArchetypeSetCode(String line) {
        String[] splitLine = line.split("\\= ");
        splitLine[0] = splitLine[0].strip();
        if(splitLine.length == 2)
            splitLine[1] = splitLine[1].strip();
        if((splitLine.length == 2))
            Global.getArchetypeSetcodeList().add(new ArchetypeSetcodeComponent(splitLine[0], Integer.decode(splitLine[1])));
    }
}
