package com.widgets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.text.*;

public class MyTextArea extends JTextArea {

    public MyTextArea(String text) {
        super(text);
        Font myFont = new Font("Segoe UI", Font.CENTER_BASELINE, 14);
        setFont(myFont);
        Border border = UIManager.getBorder("TextField.border");
        Border Textborder = BorderFactory.createLineBorder(new Color(0xd4d4d4, false), 3);
        setBorder(BorderFactory.createCompoundBorder(Textborder,
                BorderFactory.createEmptyBorder(0, 5 + getWidth(), 0, 0)));
        this.setBackground(new Color(255, 255, 255));
//            AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);
//            this.setBorder(brdr);
    }
    public boolean isValide(){
        if(this.getText().isEmpty())
        {
            return false;
        }
        return true;
    }


}
