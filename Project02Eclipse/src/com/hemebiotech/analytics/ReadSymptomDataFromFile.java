package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/*
 * Class - ReadSymptomDataFromFile - implémente l'interface - ISymptomReader- 
 * 
 **/
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	// Methode - GetSymptoms() - qui lit un ficher et insert des elements de type "Symptom" dans une liste 	
	@Override
	public Map<String, Integer> addElementToMap(String path_File) {
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		BufferedReader bd = null;
		FileReader file_Read = null;
		if (filepath != null) {
			try {
				/*
				 * lire le fichier ligne par ligne, puis on utilise le filtre suivant: 
				  si la valeur de ligne est égale à la propieté "symptom" d'un objet element dans la liste, 
				  alors, on incrémente la valeur de son propiété "occurence"
				  sinon, on crée un objet pour le nouveau symptom et initialise sa valeur d'occurence à 1 et on l'insert dans la liste.
				 */ 
		    	file_Read = new FileReader (path_File);
				bd = new BufferedReader (file_Read );
				String symptom = bd.readLine();	
				Integer occurence = 1;
				while (symptom != null) {
					if(map.get(symptom) == null) {
						map.put(symptom, 1);
					}else {
						map.put(symptom, map.get(symptom)+1 );
					}
					symptom = bd.readLine();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	    	    System.out.println(" ");
		return map;
		
	}

	/*
    	Methode - writeAllListInFile() - qui prend comme parametre une Map, 
		et ecrit les valeurs et clés de ses elements, 
		dans le fichier passé en parametre
	*/
	@Override
	public void writeAllMapInFile(Map<String,Integer> symptoms, String path_File) {
		
		try {
			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path_File)));
			symptoms.entrySet().forEach(s->pw.println(s.getKey() +" = "+ s.getValue()));
			pw.close();
			  
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}