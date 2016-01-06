/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.models.AwsomeIcon;
import com.models.GRessource;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class MyListCompteRenderer extends JPanel implements ListCellRenderer<Object> {
    private final JLabel lblImg;
    private final MyLabel lblText;

    public MyListCompteRenderer() {
        setOpaque(true);
        this.setLayout(new MigLayout("fillx"));
         lblImg = new JLabel();
         lblText = new MyLabel("");
        this.add(lblImg,"w 30");
        this.add(lblText,"growx");
        lblImg.setOpaque(false);
        lblText.setOpaque(false);
    }

    public Component getListCellRendererComponent(JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        
        lblText.setText(value.toString().toUpperCase());
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
        this.setBackground(background);
        lblText.setForeground(foreground);
        lblText.setFont(new Font("Monospaced", Font.BOLD, 16));
        lblText.setPreferredSize(new Dimension(270,30));
        lblImg.setIcon(GRessource.getIcon("bussnessman.png",30));
        return this;
    }

}
