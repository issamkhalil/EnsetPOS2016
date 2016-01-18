package com.views;


import com.models.GRessource;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyPassText;
import com.widgets.MyText;
import controlors.ComptesControlor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author EL MOTTAKI
 */
public class LoginFrame extends javax.swing.JFrame {

    MyButton btnok;
    MyButton btncancel;
    MyText txtcin;
    MyPassText txtpass; 
    MyLabel lblmessage ;
    public LoginFrame() {
        btnok = new MyButton("Connexion", GRessource.getIcon("39.png", 15));
        btncancel = new MyButton("Annuler", GRessource.getIcon("118.png", 15));
        txtcin = new MyText("");
        txtpass = new MyPassText("");
        lblmessage = new MyLabel("", 12);
        lblmessage.setForeground(Color.red);
        txtcin.setHorizontalAlignment(0);
        txtpass.setHorizontalAlignment(0);
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new MigLayout("fill"));
        setResizable(false);
        setTitle("ENSET Pos\'s");
        setIconImage(GRessource.getIcon("logo.png").getImage());
        // code begin
        // title panel
        JPanel titlePanel = new JPanel(new MigLayout());
        titlePanel.setBackground(new Color(128, 130, 230));
        MyLabel  lblttl = new MyLabel("Login ", 36, 0);
        lblttl.setIcon(GRessource.getIcon("49.png",60));
        titlePanel.add(lblttl);
        titlePanel.setOpaque(true);
        this.add(titlePanel, "dock north");
        // core panel
        JPanel corePanel = new JPanel(new MigLayout("insets 20 70 20 70","[]40[]"));

        corePanel.add(new MyLabel("Login ", 16, 0));
        corePanel.add(txtcin,"w 200,wrap");
        corePanel.add(new MyLabel("Mot de Passe ", 16, 0));
        corePanel.add(txtpass,"w 200,wrap");
        corePanel.add(lblmessage,"span 2,growx");
        this.add(corePanel,"dock center");
        // boutton panel
        JPanel btnPanel = new JPanel(new MigLayout("rtl"));
        btnPanel.add(btnok);
        btnPanel.add(btncancel);
        this.add(btnPanel,"dock south");
        // action
        btnok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                connectAction();
            }
        });
        btnok.setFocusable(true);
        btncancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAction();
            }
        });
        txtpass.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()=='\n'){
                    btnok.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        // code final

        
        pack();
        setLocationRelativeTo(null);
    }
    public void connectAction(){
        try{
            if(ComptesControlor.checkUser(txtcin.getText(),txtpass.getText())){
                this.dispose();
                new Main(ComptesControlor.fetchUser(txtcin.getText())).setVisible(true);
            }else{
                lblmessage.setText("* Login ou mot de passe n'est pas correcte !");
                this.pack();
            }
        }catch(Exception ex){
            lblmessage.setText("* "+ex.getMessage());
            this.pack();
        }
    }
    public void cancelAction(){
        this.dispose();
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
