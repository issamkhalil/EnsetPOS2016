/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.beans.Constants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author elmottaki
 */
public class ConfigModel {
    private static Properties pro = null;
    public ConfigModel() {

    }
    public static void load(){
          try {
            if(pro==null){
             pro = new Properties();
            FileReader fr = new FileReader(Constants.CONFIG_FILE);
            pro.load(fr);
            fr.close();
          }
        } catch (Exception ex) {
            Logger.getLogger(ConfigModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String getProprety(String key){
        if(pro==null){
            load();
        }
        return pro.getProperty(key);
    }
    public static String getProprety(String key,String def){
        if(pro==null){
            load();
        }
        return pro.getProperty(key,def);
    }
    public static void setProprety(String key,String value){
        if(pro==null){
            load();
        }
        pro.setProperty(key, value);
    }
    public static void store(){
        try {
            FileOutputStream fos = new FileOutputStream(Constants.CONFIG_FILE);
            pro.store(fos, "************** Configuration File ************");
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(ConfigModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
