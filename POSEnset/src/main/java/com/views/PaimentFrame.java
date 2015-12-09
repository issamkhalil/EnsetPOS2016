/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.views;
import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyRadioButton;
import com.widgets.TraiteWidget;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class PaimentFrame extends JDialog{
JLabel lblPrixHT,lblTotal;
JRadioButton btnChoixEspece,btnChoixCheque,btnChoixCarte,btnChoixTraite; 
ButtonGroup btnGroupChoix;
JLabel lblDonn,lblRest;
JButton btnValider,btnAnnuler;
JCheckBox checkRecu;
    private TraiteWidget panelTraite;
    private JPanel panelPayEsp;

public PaimentFrame(JFrame parent,boolean modal){
    super(parent,modal);
    init();
    pack();
    setLocationRelativeTo(null);
}
public void init(){
    LangueModel lm = new LangueModel();
    setLayout(new MigLayout());
    // partie sub qui contient infos
    JPanel panelTop = new JPanel(new MigLayout());
    lblPrixHT = new MyLabel(" ",14);
    lblTotal = new MyLabel(" ", 14);
    lblTotal.setOpaque(true);
    lblPrixHT.setOpaque(true);
    lblPrixHT.setBackground(Color.WHITE);
    lblTotal.setBackground(Color.white);
    panelTop.add(new MyLabel("Prix HT", 14));
    panelTop.add(lblPrixHT,"w 140px");
    panelTop.add(new MyLabel("Total", 14));
    panelTop.add(lblTotal,"w 140px");
    this.add(panelTop,"dock north");
    // partie qui contient selection de methode de paiment
    final JPanel panelCentre =new JPanel(new MigLayout());
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
            panelCentre.add(panelTraite,"dock center");
            panelCentre.revalidate();
            pack();
        }
    };
    ActionListener hideTraitePanel = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            panelCentre.add(panelPayEsp,"dock center");
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
    panelCentre.add(panelCentreTop,"dock north");
    panelPayEsp = new JPanel(new MigLayout());
    panelPayEsp.add(new MyLabel("Données", 14));
    lblDonn = new JLabel(" ");
    lblRest = new JLabel(" ");
    lblDonn.setBackground(Color.white);
    lblRest.setBackground(Color.white);
    lblDonn.setOpaque(true);
    lblRest.setOpaque(true);
    panelPayEsp.add(lblDonn,"w 120px,wrap");
    panelPayEsp.add(new MyLabel("Reste", 14));
    panelPayEsp.add(lblRest,"w 120px,wrap");
    panelTraite = new TraiteWidget(this, 1000);
    panelCentre.add(panelPayEsp,"dock center");
    //panelCentre.add(panelTraite,"dock center");
    this.add(panelCentre,"dock center");
    
    // les Bouttons
    JPanel panelSud = new JPanel(new MigLayout("center"));
    btnValider = new MyButton(lm.getString("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20, Color.black));
    btnAnnuler = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.CANCEL_ICON, 20, Color.black));
    checkRecu = new JCheckBox("reçu");
    panelSud.add(checkRecu);
    panelSud.add(btnAnnuler);
    panelSud.add(btnValider);
    this.add(panelSud,"dock south");
    
    
    
    
    
    

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
                new PaimentFrame(null,true).setVisible(true);
            }
        });
    }
}
