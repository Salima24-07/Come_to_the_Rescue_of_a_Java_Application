package com.hemebiotech.analytics;
/**
 * 
 * @author 33641
 *
 */

import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
<<<<<<< HEAD
		
		String pathFileSymptoms = "symptoms.txt"; // chemin relatif de fichier qui contient les symptoms 
		String nameFileResults = "results.out"; // fichier resultat qui contient le nombre d'occurence de chaque symptom
		ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile();	
		//to do decomposer la ligne 
		readSymptoms.writeAllListInFile(readSymptoms.getSymptoms(pathFileSymptoms), nameFileResults);
=======
		String pathFileSymptoms = "symptoms.txt"; // chemin relatif de fichier qui contient les symptoms 
		String nameFileResults = "results.out"; // fichier resultat qui contient le nombre d'occurence de chaque symptom
		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile();
		Map<String, Integer> symptoms = readSymptom.addElementToMap(pathFileSymptoms);
		readSymptom.writeAllMapInFile(symptoms, nameFileResults); 
>>>>>>> finalVersion
	}
}