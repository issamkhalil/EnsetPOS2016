/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author EL MOTTAKI
 */
public class GRessource {
    
   public GRessource(){
       
   }
   public static ImageIcon getIcon(String name){
       try {
           BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"\\icons\\"+name));
           ImageIcon icon = new ImageIcon(image);
           return icon;
       } catch (IOException ex) {
           Logger.getLogger(GRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
       
   }
      public static ImageIcon getIcon(String name,int size){
       try {
           BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"//icons//"+name));
           ImageIcon icon = new ImageIcon(image.getScaledInstance(size,size,2));
           return icon;
       } catch (IOException ex) {
           Logger.getLogger(GRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
       
   }
      public static ImageIcon getIcon(String name,int size,int k){
       try {
           BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"//icons//"+name));
           ImageIcon icon = new ImageIcon(image.getScaledInstance(size,size,2));
          
           return icon;
       } catch (IOException ex) {
           Logger.getLogger(GRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
    
}
