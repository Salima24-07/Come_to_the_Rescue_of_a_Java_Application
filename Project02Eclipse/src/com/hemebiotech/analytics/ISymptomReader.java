package com.hemebiotech.analytics;

<<<<<<< Updated upstream
import java.util.List;

public interface ISymptomReader {
	
	List<Symptom> GetSymptoms(String filepath);
	void writeAllListInFile(List<Symptom> symptoms_OCcurnce, String name_File);
	
=======
import java.util.Map;

/** 
 * "ISymptomReader": An interface that defines the behavior of the class that implements it
 * @author salima
 */

public interface ISymptomReader {

	Map<String, Integer> addElementToMap( String pathFile );
	Map<String, Integer> sortMap(Map<String, Integer> map);
	void writeAllMapInFile (Map<String,Integer> map, String pathFile);
>>>>>>> Stashed changes
}
