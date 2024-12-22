package com.hemebiotech.analytics;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.reader.ISymptomReader;
import com.hemebiotech.writer.ISymptomWriter;
/**
 * This class will allow you to count a list 
 * of identical symptoms and sort them in alphabetical order
 */
public class AnalyticsCounter {
    
    private ISymptomWriter symptomWriter;
    private ISymptomReader symptomReader;
	
     /**
     * Constructor of the class
     * 
     * @param reader take a IsymptomReader Interface
     * @param writer take a IsymptomWriter Interface
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
        this.symptomReader = reader;
        this.symptomWriter = writer;
    }
	
    /**
     * get the list of the symptoms
     * @return list of symptoms in the IsymptomReader
     */
    public List<String> getSymptoms() {
              
        return  this.symptomReader.getSymptoms();
    }
    /**
     * Count the number of symptoms
     * @param symptoms is a {@code List<String>} Interface
     * @return A {@code map<String, Integer>} (Symptom, Number of symptom)
     */
	
    public Map<String, Integer> countSymptoms(List<String> symptoms) { 
        Map<String, Integer> symptomCount = new HashMap<String, Integer>();
        symptoms.forEach((symptom) -> {
                                        if (symptomCount.containsKey(symptom)){
                                            symptomCount.replace(symptom, symptomCount.get(symptom) + 1);
                                        }
                                        else {
                                            symptomCount.put(symptom, 1);
                                        }                    
                                      });
        return symptomCount;
    }
    /**
     * Sort the {@code Map<String}, Integer> by alphabetic order
     * @param symptoms a {@code map<String, Integer>} (Symptom, Number of symptom)
     * @return The Map order by the String
     */
	
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
	   
        return new TreeMap<>(symptoms);
	    
    }
    /**
     *  write a {@code Map<String, Integer>} (Symptom, Number of symptom) in a file
     * @param symptoms is a {@code Map<String, Integer>} symptoms Interface
     */
    public void writeSymptoms(Map<String, Integer> symptoms) { 
	            
        this.symptomWriter.writeSymptoms(symptoms);
    }
}
	
	

