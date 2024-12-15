package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write the count of the symptoms
 *This class contains what is needed to write a Symptom Map to an output file
 * 
 * 
 */
public interface ISymptomWriter {
    /**
     * Write the result Map in a file,
     * throw a exception if fail
     * 
     * @param symptoms, a Map list with a String key and a Integer value
     */
    public void writeSymptoms(Map<String, Integer> symptoms) ;
}
