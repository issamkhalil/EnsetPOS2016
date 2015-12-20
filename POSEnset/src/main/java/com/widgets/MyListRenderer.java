/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import com.beans.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

/**
 *
 * @author elmottaki
 */
public class MyListRenderer extends JLabel implements ListCellRenderer<Object> {

    public MyListRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        setText(value.toString().toUpperCase());

        Color background;
        Color foreground;

        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            background = Color.BLUE;
            foreground = Constants.TEXT_COLOR;

            // check if this cell is selected
        } else if (isSelected) {
            background = Constants.TEXT_COLOR;
            foreground = Color.WHITE;

            // unselected, and not the DnD drop location
        } else {
            background = Color.WHITE;
            foreground = Constants.TEXT_COLOR;
        };

        setBackground(background);
        setForeground(foreground);
        setFont(new Font("Monospaced", Font.BOLD, 16));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setPreferredSize(new Dimension((int) this.getSize().getWidth(), 30));
        return this;
    }

}
