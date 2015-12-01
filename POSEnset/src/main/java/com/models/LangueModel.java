/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.beans.Constants;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author elmottaki
 */
public class LangueModel {
    private static ResourceBundle bundle=null;
    public LangueModel(String lang){
        if(bundle==null){
          bundle = ResourceBundle.getBundle(Constants.LANGUE_FILE,new Locale(lang));
        }
    }
    public LangueModel(){
        if(bundle==null){
          bundle = ResourceBundle.getBundle(Constants.LANGUE_FILE);
        }
    }
    public String getString(String key){
        return bundle.getString(key);
    }
    public String getStringWithSpace(String key){
        return bundle.getString(key)+" ";
    }
    
}
