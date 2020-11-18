package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Class - ReadSymptomDataFromFile - impl�mente l'interface - ISymptomReader- 
 * 
 **/
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	// Methode - GetSymptoms() - qui lit un ficher et insert des elements de type "Symptom" dans une Map 	
	@Override
	public HashMap<String, Integer> addElementToMap(String path_File) {

		HashMap<String, Integer> map = new HashMap();
		BufferedReader bd = null;
		FileReader file_Read = null;
		
			try {
				/*
				 * lire le fichier ligne par ligne,
				  si la valeur de ligne est �gale � la cl� d'un �lement dans la Map, 
				  alors, on incr�mente sa valeur 
				  sinon, on rajoute un �lement qui prend la valeur de la ligne comme cl� et on initialise sa valeur � 1.
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
				// Affiche les valeur et les cl�s des elements du Map
				Set<String> set = map.keySet();
				Iterator<String> iterator = set.iterator();
				while(iterator.hasNext()) {
					String symptoms = iterator.next().toString();
					System.out.print(" " + symptoms+" --> " + map.get(symptoms));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return map;
		
	}

	/*
	    Methode - writeAllListInFile() - qui prend comme parametre une Map, 
		et ecrit les valeurs et cl�s de ses elements, 
		dans le fichier pass� en parametre, en utilisant les �t�rateurs
	 */
	@Override
	public void writeAllMapInFile(HashMap<String,Integer> map, String name_File) {
		
		FileWriter fw;
		try {
			
			fw = new FileWriter(name_File);
			PrintWriter pw = new PrintWriter(fw);
			Set<String> set = map.keySet();
			Iterator<String> iterator = set.iterator();
			while(iterator.hasNext()) {
				String symptoms = iterator.next().toString();
				pw.println(symptoms+" = "+ map.get(symptoms));
				System.out.print("writer"+symptoms+" --> "+ map.get(symptoms));	
			}
			fw.close();			
			pw.close();
			  
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
