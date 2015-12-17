/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import com.models.FConnexion;
import com.widgets.MyButton;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author KASPAROV
 */
public class FacebookPanel extends JPanel implements MyPanel{
    private JTextArea txtStatus;
    private MyButton btnEnv;
   
    public FacebookPanel(){
        init();
    }
    public void init(){
        this.setLayout(new MigLayout("fillx"));
        txtStatus = new JTextArea();
        this.add(txtStatus,"w 100%,h 90px,wrap");
        btnEnv = new MyButton("Publier", new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 24));
        JPanel btnPanel = new JPanel(new MigLayout("rtl,fillx"));
        btnPanel.add(btnEnv);
        this.add(btnPanel,"growx");
        
        btnEnv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    final Facebook face = FConnexion.getInstance().getFacebook();
                    Thread th = new Thread(new Runnable() {

                        @Override
                        public void run()  {
                            try {
                                face.postStatusMessage(txtStatus.getText());
                                JOptionPane.showMessageDialog(null, "Message Bien Envoyer !!", "Message", JOptionPane.OK_OPTION,null);
                            } catch (FacebookException ex) {
                               JOptionPane.showMessageDialog(null, "Error : "+ex.getMessage(), "Error", JOptionPane.OK_OPTION);
                            }
                        }
                    });
                    th.run();

            }
        });
        
        
        
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
