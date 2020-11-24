package com.hemebiotech.analytics;

import java.util.List;
/**
 * 
 * @author 33641 nassssiiimm
 *
 */

/** 
 * @author salima
 */

public interface ISymptomReader {
<<<<<<< HEAD
	
	List<Symptom> getSymptoms(String filepath);
	void writeAllListInFile(List<Symptom> symptoms_OCcurnce, String name_File);
	
=======
	Map<String, Integer> addElementToMap( String path_File );
	Map<String, Integer> sortMap(Map<String, Integer> map);
	void writeAllMapInFile (Map<String,Integer> map, String path_File);
>>>>>>> finalVersion
}
