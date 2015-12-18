/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyText;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class UserFr1 extends JFrame{
    private MyText txtSearch;
    private JTable table;
    private MyButton btnAjout;
    private MyButton btnMod;
    private MyButton btnSup;
    
    public void UserFr1(){
        System.out.println("teeeeeeeeeeeeeeeeeeeeeeeeest");
        init();
        pack();
    }
    public void init(){
        System.out.println("teeeeeeeeeeeeeeeeeeeeeeeeest");
        this.setLayout(new MigLayout());
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        JPanel topPanel = new JPanel(new MigLayout());
        txtSearch = new MyText("");
        topPanel.add(new MyLabel("Chercher"));
        topPanel.add(txtSearch,"w 120px");
        this.add(topPanel,"dock north");
        table = new JTable();
        this.add(new JScrollPane(table),"dock center");
        btnAjout = new MyButton("Ajouter");
        btnMod = new MyButton("Ajouter");
        btnSup = new MyButton("Ajouter");
        JPanel sudPanel = new JPanel(new MigLayout("rtl"));
        sudPanel.add(btnAjout);
        sudPanel.add(btnMod);
        sudPanel.add(btnSup);
        this.add(sudPanel,"dock south");
        
    }
     public static void main(String args[]) {
        // look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserFr1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFr1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFr1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFr1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserFr1().setVisible(true);
            }
        });
    }
}
