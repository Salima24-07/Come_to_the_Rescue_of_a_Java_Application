package com.hemebiotech.analytics;

import java.util.List;
/**
 * 
 * @author 33641 nassssiiimm
 *
 */

public interface ISymptomReader {
	
	List<Symptom> getSymptoms(String filepath);
	void writeAllListInFile(List<Symptom> symptoms_OCcurnce, String name_File);
	
}
