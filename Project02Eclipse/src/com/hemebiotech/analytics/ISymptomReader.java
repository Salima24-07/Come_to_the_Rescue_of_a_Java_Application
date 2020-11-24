package com.hemebiotech.analytics;

import java.util.Map;

/** 
 * @author salima
 */

public interface ISymptomReader {
	Map<String, Integer> addElementToMap( String path_File );
	Map<String, Integer> sortMap(Map<String, Integer> map);
	void writeAllMapInFile (Map<String,Integer> map, String path_File);
}
