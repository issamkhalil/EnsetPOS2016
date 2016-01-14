
package com.views;
import com.models.GRessource;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;


/**
 *
 * @author EL MOTTAKI
 */
public class ProposFrame extends javax.swing.JDialog {
    


    public ProposFrame(JFrame parent,boolean modal) {
        super(parent,modal);
        initComponents();
    }                  
    private void initComponents() {
        setLayout(new MigLayout("fillx, insets 5 5 5 5"));
       // setPreferredSize(new Dimension(500,300));
      
        MyLabel title = new MyLabel("POSEnset", 20,0);
        title.setBackground(new Color(220,220,200));
        title.setIcon(GRessource.getIcon("logo.png",60));
        title.setOpaque(true);
        this.add(title,"dock north,growx,h 100,wrap");
        this.add(new MyLabel("POSEnset est une application conçu spécialement pour ENSET de Mohammedia ", 14),"al center,wrap");
        this.add(new MyLabel("Version 1, Juillet 2016  ", 12),"al center,wrap");
        this.add(new MyLabel("Developpé par Abdelilah EL MOTTAKI,Issam KHALIL ", 12),"al center,wrap");
        this.add(new MyLabel("Copyright (C) 2016  ", 12),"al center,wrap");
        this.add(new MyLabel("www.POSEnset.net", 12),"al center,wrap");
        MyButton btnCancel = new MyButton("Fermer",GRessource.getIcon("118.png",20));
        this.add(btnCancel,"al center");
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAction();
            }
        });
        pack();
        setLocationRelativeTo(null);
    }                     

    
    public void cancelAction() {
        this.dispose();
    }
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProposFrame(new JFrame(),true).setVisible(true);
            }
        });
    }                
}
