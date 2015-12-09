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
import com.widgets.MyDateText;
import com.widgets.MyLabel;
import com.widgets.MyText;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ListClientFrame extends JDialog {
    JTextField txtId,txtNom,txtPrenom;
    JButton btnSearch;
    JTable tableResult;
    String tableResultTiltles[] ;
    JButton btnValider,btnAnnuler;
    public ListClientFrame(JFrame parent,boolean modal){
        super(parent,modal);
        init();
        pack();
        this.setLocationRelativeTo(null);
    }
    public void init(){
        this.setLayout(new MigLayout());
        LangueModel lm = new LangueModel();
        this.setLocationRelativeTo(null);
        this.tableResultTiltles = new String[]{lm.getString("id_client"),lm.getString("nom"),lm.getString("prenom")};
        // partie de recherche
        JPanel panelTop = new JPanel(new MigLayout());
        txtId = new MyText("");
        txtNom = new MyText("");
        txtPrenom = new MyText("");
        panelTop.add(new MyLabel(lm.getStringWithSpace("id_client")+":", 14));
        panelTop.add(txtId,"w 220px,wrap");
        panelTop.add(new MyLabel(lm.getStringWithSpace("nom_client")+":", 14));
        panelTop.add(txtNom,"w 220px,wrap");
        panelTop.add(new MyLabel(lm.getStringWithSpace("prenom_client")+":", 14));
        panelTop.add(txtPrenom,"w 220px,wrap");
        btnSearch = new MyButton(lm.getString("chercher"), new AwsomeIcon(AwsomeIconConst.SEARCH_PLUS_ICON, 20, Color.BLACK));
        panelTop.add(btnSearch,"push 2");
        this.add(panelTop,"dock north");
        // tableau qui contient result de recherche
        JPanel panelCentre = new JPanel(new MigLayout());
        tableResult = new JTable(new DefaultTableModel(null, tableResultTiltles));
        this.add(new JScrollPane(tableResult),"dock center");
        // les button
        JPanel panelSud = new JPanel(new MigLayout("center"));
        btnValider = new MyButton(lm.getString("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20, Color.black));
        btnAnnuler = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.CANCEL_ICON, 20, Color.black));
        panelSud.add(btnValider);
        panelSud.add(btnAnnuler);
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
                new ListClientFrame(null,true).setVisible(true);
            }
        });
    }
    
}
