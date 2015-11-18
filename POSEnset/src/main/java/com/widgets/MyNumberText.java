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

public class MyNumberText extends JTextField {

    public MyNumberText(String text) {
        super(text);
        Font myFont = new Font("Segoe UI", Font.BOLD, 14);
        setFont(myFont);
        Border border = UIManager.getBorder("TextField.border");
        Border Textborder = BorderFactory.createLineBorder(new Color(0xd4d4d4, false), 1);
        setBorder(BorderFactory.createCompoundBorder(Textborder,
                BorderFactory.createEmptyBorder(0, 5 + getWidth(), 0, 0)));
        this.setBackground(new Color(255, 255, 255));

    }
      @Override
    protected Document createDefaultModel() {
        return new UpperCaseDocument();
    }

    static class UpperCaseDocument extends PlainDocument {
        
        @Override
        public void insertString( int offs, String str, AttributeSet a )
                throws BadLocationException {

            if ( str == null ) {
                return;
            }
           
            char[] chars = str.toCharArray();
            boolean ok = true;
            for ( int i = 0; i < chars.length; i++ ) {
              if(chars[i]=='.'){
                 
              }
              else{
                try {
                    Integer.parseInt( String.valueOf( chars[i] ) );
                } catch ( NumberFormatException exc ) {
                    ok = false;
                    break;
                }
              }
            }
            
            if ( ok )
                super.insertString( offs, new String( chars ), a );

        }
    }



}
