package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//Class - ReadSymptomDataFromFile - implémente l'interface - ISymptomReader- 
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	
	// Methode - GetSymptoms() - qui lit un ficher et insert des elements de type "Symptom" dans une liste 	
	@Override
	public List<Symptom> GetSymptoms(String filepath) {
		
<<<<<<< Updated upstream
		List<Symptom> symptoms = null;
			try {
				/*
				 * lire le fichier ligne par ligne, puis on utilise le filtre suivant: 
				  si la valeur de ligne est égale à la propieté "symptom" d'un objet element dans la liste, 
				  alors, on incrémente la valeur de son propiété "occurence"
				  sinon, on crée un objet pour le nouveau symptom et initialise sa valeur d'occurence à 1 et on l'insert dans la liste.
				 */ 
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				symptoms = new ArrayList<Symptom>();
				String line = reader.readLine();
				
				while (line != null) {	
					String l = line;
					Symptom symptom = symptoms.stream()
		  					  .filter(s -> l.equals(s.getSymptom()))
		  		  			  .findAny().orElse(null);
					if(symptom != null) {
						symptom.setOccurence((symptom.getOccurence())+1);
=======
		Map<String, Integer> symptoms = new HashMap<String, Integer>();
			
			try (BufferedReader bd = new BufferedReader (new FileReader(pathFile))){ /* (try-with-resources) The stream is 
																				      
																				      automatically closed at the end of the try block */
				String symptom = bd.readLine();
				while (symptom != null) {
					if(symptoms.get(symptom) == null) {
						symptoms.put(symptom, 1);
>>>>>>> Stashed changes
					}else {
						symptoms.add(new Symptom(line, 1));
					}
<<<<<<< Updated upstream
					line = reader.readLine();
=======
					symptom = bd.readLine(); // get another symptom
>>>>>>> Stashed changes
				}
				
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Afficher les valeurs des prorietés des objets de type Sypmtom elements de la liste  
			symptoms.forEach(s->System.out.println(s.getSymptom()+ " = " +s.getOccurence()));
		return symptoms;
	}
<<<<<<< Updated upstream
	
	/* Méthode - writeAllListInFile() - qui prend comme paramètre une liste, 
		et écrit les valeurs des propriétés symptom et ocuurence de ses elements, dans un fichier passé en paramètre.
	*/
	@Override	
	public void writeAllListInFile(List<Symptom> symptoms, String name_File) {
			
			FileWriter fw;
			try {
				
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(name_File)));				 
				symptoms.forEach(s->pw.println(s.getSymptom()+" = "+ s.getOccurence()));
				pw.close();
				  
			} catch (Exception e1) {
				e1.printStackTrace();
			}
=======

	/**
	 * Method - writeAllListInFile () - which takes a Map as parameter,
	   and write the values and keys of its elements,
	   in the file
	   @author Salima
	   @param: a source map
	 * @param: result file path
	 */
	@Override
	public void writeAllMapInFile(Map<String,Integer> symptoms, String pathFile) {
		
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(pathFile)))) {
			// Afficher les symptoms et ses occurences dans la console
			symptoms.entrySet().forEach(s->pw.println(s.getKey() +" = "+ s.getValue()));
			  
		} catch (Exception e1) {
			//Afficher les traces des exceptions
			e1.printStackTrace();
>>>>>>> Stashed changes
		}

}