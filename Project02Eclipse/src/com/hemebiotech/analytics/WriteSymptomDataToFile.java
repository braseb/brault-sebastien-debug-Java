package com.hemebiotech.analytics;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Managing the writing of the symptom counting text file
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
     
    private String filepath;
    /**
     * 
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    
    public WriteSymptomDataToFile(String filepath){
        this.filepath = filepath;
    }
    
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (this.filepath != null) {
            try {
                FileWriter writer = new FileWriter (this.filepath);
                
                //Set<String> symptomsKey = symptoms.keySet();
                /*for (String s : symptomsKey) {
                    Integer numbers = symptoms.get(s);
                    writer.write(s + ": " + numbers + "\n");
                }*/
                symptoms.forEach( (key, val) ->{
                                                     try {
                                                        writer.write(key + ": " + val + "\n");
                                                     } 
                                                     catch (IOException e) {
                                                         e.printStackTrace();
                                                     }
                                                 });
                writer.close();
            }
                
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    
    
}
