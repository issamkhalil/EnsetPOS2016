/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.widgets;

import com.beans.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author EL MOTTAKI
 */
public class MyButton extends JButton{

    public MyButton() {
        
    }

   public  MyButton(String str) {
        super(str);
        this.setBackground(new Color(59, 89, 182));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setFont(new Font("Tahoma", Font.BOLD, 12));
        
    }
       public MyButton(String str,Icon icon) {
        super(str,icon);
        this.setBackground(new Color(59, 89, 182));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setFont(new Font("Tahoma", Font.BOLD, 12));
        
    }

    


    
    
    
    
}
