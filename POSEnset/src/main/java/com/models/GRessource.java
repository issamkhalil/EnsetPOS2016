/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import sun.security.x509.OIDMap;

/**
 *
 * @author EL MOTTAKI
 */
public class GRessource {
    
   public GRessource(){
       
   }
   public static ImageIcon getIcon(String name){
       try {
           InputStream stream = GRessource.class.getClassLoader().getResourceAsStream("icons//"+name);
           BufferedImage image = ImageIO.read(stream);
           ImageIcon icon = new ImageIcon(image);
           return icon;
       } catch (IOException ex) {
           Logger.getLogger(GRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
      public static ImageIcon getIcon(String name,int size){
       try {
           InputStream stream = GRessource.class.getClassLoader().getResourceAsStream("icons//"+name);
           BufferedImage image = ImageIO.read(stream);
           ImageIcon icon = new ImageIcon(image.getScaledInstance(size,size,2));
           return icon;
       } catch (IOException ex) {
           Logger.getLogger(GRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
       
   }
      public static ImageIcon getIcon(String name,int size,int k){
       try {
           InputStream stream = GRessource.class.getClassLoader().getResourceAsStream("icons//"+name);
           BufferedImage image = ImageIO.read(stream);
           ImageIcon icon = new ImageIcon(image.getScaledInstance(size,k,2));
           return icon;
       } catch (IOException ex) {
           Logger.getLogger(GRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
      public static ImageIcon getImage(byte img[]){
       try {
           return new ImageIcon(ImageIO.read(new ByteArrayInputStream(img)));
       } catch (IOException ex) {
           return null;
       }
      }
      public static ImageIcon getImage(byte img[],int size){
       try {
           return new ImageIcon(ImageIO.read(new ByteArrayInputStream(img)).getScaledInstance(size, size, 2));
       } catch (IOException ex) {
           return null;
       }
      }
    
}
