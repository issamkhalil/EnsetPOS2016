/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Icon;

/**
 *
 * @author elmottaki
 */
/*

 
 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Font;
 import java.awt.FontFormatException;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.RenderingHints;
 import java.awt.image.BufferedImage;
 import java.io.IOException;
 import java.io.InputStream;
 import javax.swing.Icon;
 
 /**
  * Creates an {@link Icon} from a give FontAwesome unicode identifier.
  * 
  * @see http://fortawesome.github.io/Font-Awesome/cheatsheet/
  */
 public class AwsomeIcon implements Icon {
 
     private static final String AWESOME_SET = "/font/fontawesome-webfont.ttf";
     
     private int size;
     private BufferedImage buffer;
     
     private char iconID;
     private static final Font awesome;
     private Color color;
     
     private Font font;
     
     static {
         try {
             InputStream stream =
                     AwsomeIcon.class.getResourceAsStream(AWESOME_SET);
             awesome = Font.createFont(Font.TRUETYPE_FONT, stream);
 
         } catch (Exception ex) {
             throw new RuntimeException(ex);
         }
     }
     
     public AwsomeIcon(char iconID, int size,Color color) {
         this.iconID = iconID;
         this.size = size;
         font = awesome.deriveFont(Font.PLAIN, size);
         this.color = color;
     }
     public AwsomeIcon(char iconID, int size) {
         this.iconID = iconID;
         this.size = size;
         font = awesome.deriveFont(Font.PLAIN, size);
         this.color = Color.black;
     }
 
     public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
         
         if (buffer == null) {
             buffer = new BufferedImage(getIconWidth(), getIconHeight(),
                                        BufferedImage.TYPE_INT_ARGB);
             
             Graphics2D graphics = (Graphics2D) buffer.getGraphics();
             graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                       RenderingHints.VALUE_ANTIALIAS_ON);
             
             graphics.setFont(font);
             graphics.setColor(color);
             
             int stringY = getIconHeight() - (getIconHeight()/4) + 3;
             graphics.drawString(String.valueOf(iconID), 0, stringY);
             
             graphics.dispose();
         }
         
         g.drawImage(buffer, x, y, null);
     }
 
     @Override
     public int getIconHeight() {
         return size;
     }
 
     @Override
     public int getIconWidth() {
         return size;
     }
 }