/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author elmottaki
 */
public class JTabLabel extends JLabel {

    public JTabLabel(String text, Icon icon) {
        this.setText(text);
        this.setIcon(icon);
        this.setIconTextGap(5);
        this.setHorizontalTextPosition(SwingConstants.RIGHT);
    }

}
