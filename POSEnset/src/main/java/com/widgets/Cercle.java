/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author EL MOTTAKI
 */
public class Cercle extends JLabel {
    Color color;
     public Cercle(String str,int size,Color color){
        super(str);
        Font font  = new Font("Segoe UI", Font.BOLD, size);
        this.color = color;
        this.setFont(font);
        this.setForeground(Color.black);
        this.setHorizontalAlignment(0);
    }
 
 @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, getWidth(), getHeight());
        g.drawOval(0, 0, getWidth(), getHeight());
        ui.update(g, this);
    }
    
}
