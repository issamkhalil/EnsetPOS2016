/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.widgets;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author EL MOTTAKI
 */
public class MyLabel extends JLabel {
    Font font ;
    public MyLabel(String str,int size){
        super(str);
        font  = new Font("Segoe UI", Font.BOLD, size);
        this.setFont(font);
        this.setForeground(Color.black);
    }
     public MyLabel(String str,int size,int align){
        super(str);
        font  = new Font("Segoe UI", Font.BOLD, size);
        this.setFont(font);
        this.setForeground(Color.black);
        this.setHorizontalAlignment(align);
    }
      public MyLabel(Icon icon){
        super(icon);
    }
    
}
