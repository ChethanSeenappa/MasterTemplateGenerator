/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chethan Seenappa
 */
public class MasterGenerator {
    String filePath;
    
    private void setFilePath(String filePath){
        this.filePath = filePath;
    }
    
    private String getFilePath(){
        return this.filePath;
    }
    
    public static void main(String[] args){
        MasterGenerator masterGenerator = new MasterGenerator();
        masterGenerator.setFilePath("C:\\Users\\priyanka.a.venkatesh\\Desktop\\MasterSegementDetail.txt");
        try {
            masterGenerator.readFile();
        } catch (IOException ex) {
            Logger.getLogger(MasterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(this.getFilePath())));
        String value;
        while((value = br.readLine())!= null){
            String[] mshValues = value.split("	");
            String fieldName = "";
            ArrayList<String> cardinalityAndDescription = new ArrayList();
            for(int i = 0; i<mshValues.length; i++){
                if(i == 0){
                    fieldName = mshValues[i];
                }else{
                    cardinalityAndDescription.add(mshValues[i]);
                }
            }
            String values = "";
            for (int i =0 ; i< cardinalityAndDescription.size(); i++) {
                if(i == cardinalityAndDescription.size()-1){
                    values += ("\""+cardinalityAndDescription.get(i)+"\"");
                }else {
                    values += ("\""+cardinalityAndDescription.get(i)+"\""+" ,");
                }
                
            }
            System.out.println("this.setIN1FieldValuePair(\""+fieldName+"\", "+values+");");
        }
    }
    
}
