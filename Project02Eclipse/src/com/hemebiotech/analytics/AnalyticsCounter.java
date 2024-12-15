package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	protected ISymptomWriter writer;
	protected ISymptomReader reader;
	
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
	    this.reader = reader;
	    this.writer = writer;
	}
	    
	public List<String> getSymptoms() {
        List<String> listSymptom;
        listSymptom = this.reader.GetSymptoms();
        return listSymptom;
    }
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
	    
	    Map<String, Integer> symptomCount = new HashMap<String, Integer>();
	    symptoms.forEach((symptom) -> {System.out.println("symptom from file: " + symptom);
                                            if (symptomCount.containsKey(symptom)){
                                                symptomCount.replace(symptom, symptomCount.get(symptom) + 1);
                                            }
                                            else {
                                                symptomCount.put(symptom, 1);
                                            }                    
                                      });
	    return symptomCount;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
	   
	    return new TreeMap<>(symptoms);
	    
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) { 
	    // next generate output
        
        writer.writeSymptoms(symptoms);
	}
}
	
	

