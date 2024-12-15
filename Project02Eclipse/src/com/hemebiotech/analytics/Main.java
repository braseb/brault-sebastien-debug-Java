package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String args[]) {
        
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        
        AnalyticsCounter analyCount = new AnalyticsCounter(reader, writer);
        
        List<String> symptoms = analyCount.getSymptoms();
        
        Map<String, Integer> CountSymptoms = analyCount.countSymptoms(symptoms);
        
        CountSymptoms = analyCount.sortSymptoms(CountSymptoms);
                
        analyCount.writeSymptoms(CountSymptoms);
        

    }

}
