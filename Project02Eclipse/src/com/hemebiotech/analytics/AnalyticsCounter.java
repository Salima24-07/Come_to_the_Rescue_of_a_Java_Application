package com.hemebiotech.analytics;
/**
 * 
 * @author 33641
 *
 */

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		
		String pathFileSymptoms = "symptoms.txt"; // chemin relatif de fichier qui contient les symptoms 
		String nameFileResults = "results.out"; // fichier resultat qui contient le nombre d'occurence de chaque symptom
		ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile();	
		//to do decomposer la ligne 
		readSymptoms.writeAllListInFile(readSymptoms.getSymptoms(pathFileSymptoms), nameFileResults);
	}
}