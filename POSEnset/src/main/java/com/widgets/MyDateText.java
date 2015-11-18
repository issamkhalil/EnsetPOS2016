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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.text.*;

public class MyDateText extends JFormattedTextField {

    public MyDateText() {
        super();
        try {
            Font myFont = new Font("Segoe UI", Font.BOLD, 14);
            setFont(myFont);
            Border border = UIManager.getBorder("TextField.border");
            Border Textborder = BorderFactory.createLineBorder(new Color(0xd4d4d4, false), 1);
            setBorder(BorderFactory.createCompoundBorder(Textborder,
                    BorderFactory.createEmptyBorder(0, 5 + getWidth(), 0, 0)));
            this.setBackground(new Color(255, 255, 255));
            this.setColumns(10);
            MaskFormatter dateMask = new MaskFormatter("##-##-####");
            dateMask.install(this);
            
//            this.setValue(new Date());
//            AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);
//            this.setBorder(brdr);
        } catch (ParseException ex) {
            Logger.getLogger(MyDateText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
