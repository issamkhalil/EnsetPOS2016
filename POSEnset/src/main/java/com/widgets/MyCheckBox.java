/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.models.AwsomeIcon;
import javax.swing.JCheckBox;

/**
 *
 * @author KASPAROV
 */
public class MyCheckBox extends JCheckBox{
    public MyCheckBox(boolean etat){
        super();
        this.setSelected(etat);
        // Set default icon for checkbox
    this.setIcon(new AwsomeIcon(AwsomeIconConst.TOGGLEOFF_ICON, 30,25,Constants.TEXT_COLOR));
    // Set selected icon when checkbox state is selected
    this.setSelectedIcon(new AwsomeIcon(AwsomeIconConst.TOGGLEON_ICON,30, 25,Constants.TEXT_COLOR));
    // Set disabled icon for checkbox
    this.setDisabledIcon(new AwsomeIcon(AwsomeIconConst.TOGGLEOFF_ICON, 30,25,Constants.TEXT_COLOR));
    // Set disabled-selected icon for checkbox
    this.setDisabledSelectedIcon(new AwsomeIcon(AwsomeIconConst.TOGGLEON_ICON,30, 25,Constants.TEXT_COLOR));
    // Set checkbox icon when checkbox is pressed
    //this.setPressedIcon(new AwsomeIcon(AwsomeIconConst.CHECKED_ICON, 25,Constants.TEXT_COLOR));
    // Set icon when a mouse is over the checkbox
    this.setRolloverIcon(new AwsomeIcon(AwsomeIconConst.TOGGLEOFF_ICON, 30,25,Constants.TEXT_COLOR));
    // Set icon when a mouse is over a selected checkbox
    this.setRolloverSelectedIcon(new AwsomeIcon(AwsomeIconConst.TOGGLEON_ICON,30, 25,Constants.TEXT_COLOR));
    }
}
