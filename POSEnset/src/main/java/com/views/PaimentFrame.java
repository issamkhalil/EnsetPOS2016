/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.entities.Client;
import com.entities.PaymentType;
import com.entities.Produit;
import com.entities.Vente;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.models.PdfFactory;
import com.widgets.GFile;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyRadioButton;
import com.widgets.MyText;
import com.widgets.TraiteWidget;
import controlors.SalesControlor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class PaimentFrame extends JDialog {

    JLabel lblPrixHT, lblTotal;
    JRadioButton btnChoixEspece, btnChoixCheque, btnChoixCarte, btnChoixTraite;
    ButtonGroup btnGroupChoix;
    JTextField lblDonn, lblRest;
    JButton btnValider, btnAnnuler;
    JCheckBox checkRecu;
    private TraiteWidget panelTraite;
    private JPanel panelPayEsp;
    private Map<Produit, Integer> listProduit;
    private double tht;
    private double total;
    private Client client;
    private boolean done = false;

    public PaimentFrame(JFrame parent, boolean modal, Map<Produit, Integer> listProduit) {
        super(parent, modal);
        this.listProduit = listProduit;
        init();
        pack();
        calculTotal();
        setLocationRelativeTo(null);
        this.client = null;
    }

    PaimentFrame(JFrame parent, boolean modal, Map<Produit, Integer> listProduit, Client client) {
        super(parent, modal);
        this.listProduit = listProduit;
        init();
        pack();
        calculTotal();
        this.client = client;
        setLocationRelativeTo(null);
    }

    public void init() {
        LangueModel lm = new LangueModel();
        setLayout(new MigLayout());
        // partie sub qui contient infos
        JPanel panelTop = new JPanel(new MigLayout());
        lblPrixHT = new MyLabel(" ", 14);
        lblTotal = new MyLabel(" ", 14);
        lblTotal.setOpaque(true);
        lblPrixHT.setOpaque(true);
        lblPrixHT.setBackground(Color.WHITE);
        lblTotal.setBackground(Color.white);
        panelTop.add(new MyLabel("Prix HT", 14));
        panelTop.add(lblPrixHT, "w 140px");
        panelTop.add(new MyLabel("Total", 14));
        panelTop.add(lblTotal, "w 140px");
        this.add(panelTop, "dock north");
        // partie qui contient selection de methode de paiment
        final JPanel panelCentre = new JPanel(new MigLayout());
        JPanel panelCentreTop = new JPanel(new MigLayout());
        btnChoixEspece = new MyRadioButton("Par Espéce");
        btnChoixEspece.setSelected(true);
        btnChoixCheque = new MyRadioButton("Par Cheque");
        btnChoixCarte = new MyRadioButton("Par Carte");
        btnChoixTraite = new MyRadioButton("Par Traite");
        btnGroupChoix = new ButtonGroup();
        btnGroupChoix.add(btnChoixEspece);
        btnGroupChoix.add(btnChoixCheque);
        btnGroupChoix.add(btnChoixCarte);
        btnGroupChoix.add(btnChoixTraite);
        ActionListener afficheTraitePanel = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panelCentre.remove(panelPayEsp);
                panelCentre.add(panelTraite, "dock center");
                panelCentre.revalidate();
                pack();
            }
        };
        ActionListener hideTraitePanel = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panelCentre.add(panelPayEsp, "dock center");
                panelCentre.remove(panelTraite);
                panelCentre.revalidate();
                pack();
            }
        };
        btnChoixCarte.addActionListener(hideTraitePanel);
        btnChoixEspece.addActionListener(hideTraitePanel);
        btnChoixCheque.addActionListener(hideTraitePanel);
        btnChoixTraite.addActionListener(afficheTraitePanel);
        panelCentreTop.add(btnChoixEspece);
        panelCentreTop.add(btnChoixCheque);
        panelCentreTop.add(btnChoixCarte);
        panelCentreTop.add(btnChoixTraite);
        panelCentre.add(panelCentreTop, "dock north");
        panelPayEsp = new JPanel(new MigLayout());
        panelPayEsp.add(new MyLabel("Données", 14));
        lblDonn = new MyText("0.00");
        lblRest = new MyText("0.00");
        lblRest.setEditable(false);
        lblDonn.setBackground(Color.white);
        lblRest.setBackground(Color.white);
        lblDonn.setOpaque(true);
        lblRest.setOpaque(true);
        panelPayEsp.add(lblDonn, "w 120px,wrap");
        panelPayEsp.add(new MyLabel("Reste", 14));
        panelPayEsp.add(lblRest, "w 120px,wrap");
        panelTraite = new TraiteWidget(this, 1000);
        panelCentre.add(panelPayEsp, "dock center");
        //panelCentre.add(panelTraite,"dock center");
        this.add(panelCentre, "dock center");

        // les Bouttons
        JPanel panelSud = new JPanel(new MigLayout("center"));
        btnValider = new MyButton(lm.getString("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20, Color.black));
        btnAnnuler = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.CANCEL_ICON, 20, Color.black));
        checkRecu = new JCheckBox("reçu");
        panelSud.add(checkRecu);
        panelSud.add(btnAnnuler);
        panelSud.add(btnValider);
        this.add(panelSud, "dock south");
        btnAnnuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                annulerAction();
            }
        });
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validerAction();
            }
        });
        lblDonn.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }
          
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    double val = Double.parseDouble(lblDonn.getText());
                    if (total <= val) {
                        setRest(val - total);
                    }
                } catch (Exception ex) {
                    setDonne(0);
                    setRest(0);
                }
            }
        });

    }

    public void validerAction() {
        try {
//             if(Double.parseDouble(lblRest.getText())>0 && !btnChoixTraite.isSelected()){
//                 throw new Exception("le Rest doit etre egal a 0 !");
//             }
            Vente vente = null;
            if (btnChoixCarte.isSelected()) {
                vente = SalesControlor.validerVente(listProduit, PaymentType.parCarte, client);
            } else if (btnChoixCheque.isSelected()) {
                vente = SalesControlor.validerVente(listProduit, PaymentType.cheque, client);
            } else if (btnChoixEspece.isSelected()) {
                vente = SalesControlor.validerVente(listProduit, PaymentType.espece, client);
            } else {
                vente = SalesControlor.validerVente(listProduit, panelTraite.getTraites(), client);
            }

            done = true;

            try {
                if (checkRecu.isSelected() && !btnChoixTraite.isSelected()) {
                    PdfFactory.createRecu(vente, new File("recu.pdf"));
                    try{
                    java.awt.Desktop.getDesktop().open(new File("recu.pdf"));
                    }
                    catch(Exception ex){
                        
                    }
                   finally{
                        GFile.open(new File("recu.pdf"));
                    }
                }
            } catch (Exception ex) {
                if (ex instanceof FileNotFoundException) {
                    JOptionPane.showMessageDialog(this, "Fermer PDF ListLettre.pdf !");
                } else {
                    Logger.getLogger(PaimentFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }

    public void annulerAction() {
        this.dispose();
    }

    public void calculTotal() {
        ArrayList<Produit> pro = new ArrayList<Produit>(listProduit.keySet());
        tht = 0;
        total = 0;
        for (int i = 0; i < pro.size(); i++) {
            tht += pro.get(i).getPrixVente() * listProduit.get(pro.get(i));
            total += pro.get(i).getPrixVente() * (listProduit.get(pro.get(i)) * (1 + pro.get(i).getTva() / 100));
        }
        lblPrixHT.setText(String.format("%.2f", tht));
        lblTotal.setText(String.format("%.2f", total));
        panelTraite.setTotal(total);
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaimentFrame(null, true, null).setVisible(true);
            }
        });
    }

    public void setTotal(double val) {
        lblTotal.setText(String.format("%.2f", val));
    }

    public void setPrixHT(double val) {
        lblPrixHT.setText(String.format("%.2f", val));
    }

    public void setDonne(double val) {
        lblDonn.setText(String.format("%.2f", val));
    }

    public void setRest(double val) {
        lblRest.setText(String.format("%.2f", val));
    }

    public boolean isDone() {
        return done;
    }
}
