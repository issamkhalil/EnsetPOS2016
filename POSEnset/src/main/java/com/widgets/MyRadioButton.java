/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import javax.swing.Icon;
import javax.swing.JRadioButton;

/**
 *
 * @author elmottaki
 */
public class MyRadioButton extends JRadioButton{
    
    public MyRadioButton(String text){
        super(text);
        
    }
    public MyRadioButton(String text,Icon icon){
        super(text,icon);
    }
    
}
