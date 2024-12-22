package com.hemebiotech.writer;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Map;

/**
 * Managing the writing of the symptom counting text file
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
     
    private String filepath;
    /**
     * A class for create a result file of the symptom counting
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
                
                symptoms.forEach( (key, val) -> {
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
