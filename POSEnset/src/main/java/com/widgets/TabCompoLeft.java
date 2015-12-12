/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import javax.swing.*;

/**
 *
 * @author KASPAROV
 */
public class TabCompoLeft extends JLabel {
    
    public TabCompoLeft(String text,Icon icon){
        super(icon);
        setText(text);
        this.setHorizontalTextPosition(JLabel.TRAILING);
    }
    
}
