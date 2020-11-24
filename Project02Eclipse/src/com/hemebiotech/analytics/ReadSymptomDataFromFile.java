package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author 33641 moihkugjydchyjclo:u!hmouifvktydcjtrx
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	
	
	public List<Symptom> getSymptoms(String filepath) {
		
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
					}else {
						symptoms.add(new Symptom(line, 1));
=======
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	/**
	 * Sorts the specified Map in alphabetical order
	 * @author salima
	 * @param map : Map to sort
	 * @return result: sorted Map
	 */
	@Override	
	public Map<String, Integer> sortMap(Map<String, Integer> map) {
		
		Map<String, Integer> result = map.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByKey()) // Compare item keys
				  .collect(Collectors.toMap(
				    Map.Entry::getKey,
				    Map.Entry::getValue,
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		return result;
	}
	
	/**
	 *Read the file line by line, then use the following filter:
		if the row value is equal to the "symptom" property of an element object in the list,
		then, we increment the value of its "occurrence" property
		otherwise, we create an object for the new symptom and initialize its occurrence value to 1 and insert it in the list.
		@author Salima
		@param pathFile : source file path
		@return symptom : a result map 
		
	 */
	
	@Override
	public Map<String, Integer> addElementToMap(String pathFile) {
		
		Map<String, Integer> symptoms = new HashMap<String, Integer>();
			
			try (BufferedReader bd = new BufferedReader (new FileReader(pathFile))){ //(try-with-resources) The stream is automatically closed at the end of the try block	
				
				String symptom = bd.readLine();
				while (symptom != null) {
					if(symptoms.get(symptom) == null) {
						symptoms.put(symptom, 1);
					}else {
						symptoms.put(symptom, symptoms.get(symptom)+1 );
>>>>>>> finalVersion
					}
					line = reader.readLine();
				}
				
<<<<<<< HEAD
				reader.close();
			} catch (Exception e) {
=======
			} catch (IOException e) {
>>>>>>> finalVersion
				e.printStackTrace();
			}finally {
				//todo
			}
<<<<<<< HEAD
			Collections.sort(symptoms, Comparator.comparing(Symptom::getSymptom));
			symptoms.forEach(s->System.out.println(s.getSymptom()+ " = " +s.getOccurence()));
		return symptoms;
	}
	
	
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
		}

=======
			
		return sortMap(symptoms);
		
	}

	/**
	 * Method - writeAllListInFile () - which takes a Map as parameter,
	   and write the values and keys of its elements,
	   in a file
	   @author Salima
	   @param: a source map
	 * @param: result file path
	 */
	@Override
	public void writeAllMapInFile(Map<String,Integer> symptoms, String path_File) {
		
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path_File)))) {
			// Afficher les symptoms et ses occurences dans la console
			symptoms.entrySet().forEach(s->pw.println(s.getKey() +" = "+ s.getValue()));
			  
		} catch (IOException e1) {
			//Afficher les traces des exceptions
			e1.printStackTrace();
		}
	}

	
>>>>>>> finalVersion
}