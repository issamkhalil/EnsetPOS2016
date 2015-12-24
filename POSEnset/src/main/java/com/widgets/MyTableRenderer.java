/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author EL MOTTAKI
 */
   public class MyTableRenderer extends DefaultTableCellRenderer {

        public MyTableRenderer() {

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(String.valueOf(value));
            setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 13));
            setHorizontalAlignment(0);
            if (isSelected) {
                setBackground(new Color(29, 116, 137));
            } else {
                if (row % 2 == 0) {
                    setBackground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(208, 238, 244));
                }
            }
            return this;

        }
    }