package com.hemebiotech.analytics;

//Class "Symptom" pour instancier des objets contenants la valeur de symptom et son occurence
/**
 * 
 * @author 33641
 *
 */
/**
 * 
 * @author 33641 noio^ll nassim
 *
 */
public class Symptom {
	
	private String symptom;
	private int occurence;
	/**
	 * 
	 * @param symptom
	 * @param occurence: zoiueruhgiuoer
	 */
		
	public Symptom(String symptom, int occurence) {
		this.symptom = symptom;
		this.occurence = occurence;
	}
	// les accesseurs (les setters et les getters)
		
	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public int getOccurence() {
		return occurence;
	}

	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	
	
}