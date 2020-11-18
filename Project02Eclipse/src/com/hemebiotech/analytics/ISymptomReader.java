package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomReader {
	Map<String, Integer> addElementToMap( String path_File );
	void writeAllMapInFile (Map<String,Integer> map, String path_File);
}
