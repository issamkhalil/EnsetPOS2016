/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.awt.Color;

/**
 *
 * @author elmottaki
 */
public class Constants {
   public static String CONFIG_FILE = "config";
   public static String FACE_ID = "config";
   public static String FACE_SECRET = "config";
   public static String FACE_TOKEN = "config";
   public static String LANGUE_FILE="langue";
   public static Color OFFICIAL_COLOR = new Color(156,209,253);
   public static Color TEXT_COLOR = new Color(69,153,239);
   public static enum TypeCompte{
       ADMIN("Admin"),USER("User");
       private final String text;
       private TypeCompte( String text) {
        this.text = text;
    }
        @Override
        public String toString() {
           return text;
        }
       
   }
   
}
