package com.engine;

import java.nio.file.Path;
import java.util.List;

public interface DBBuilder {	
	void buildDB();
	String concatStringArray(List<String> list);
	String configurePathToClassName(Path pathToConfigure);
}