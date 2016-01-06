/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyNumberText;
import com.widgets.MyText;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class QuantiteFrame extends JDialog {

    private JButton btnValider;
    private JSpinner spinner;

    public QuantiteFrame(JFrame parent,boolean modal) {
        super(parent,modal);
        init();
        pack();
        setLocationRelativeTo(null);
    }

    public void init() {
        setLayout(new MigLayout(""));
        this.add(new MyLabel("Quantité"));
        spinner = new JSpinner();
        spinner.setFocusable(true);
        this.add(spinner,"wrap,w 120px");
        btnValider = new MyButton("Valider", new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 24));
        JPanel panel = new JPanel();
        panel.add(btnValider);
        this.add(panel, "span,growx");
        ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.err.println(e.getKeyChar());
                if (e.getKeyCode() == Event.ENTER) {
                    btnValider.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validerAction();
            }
        });
        
    }

    public void validerAction() {
        this.dispose();
    }

   

    public int getQuantite() {
       return  (Integer)spinner.getValue();
    }

}
