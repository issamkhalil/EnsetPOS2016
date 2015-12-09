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
import com.widgets.MyText;
import java.awt.Color;
import java.util.Properties;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import org.jdatepicker.impl.JDatePickerImpl;
import net.miginfocom.swing.MigLayout;
import org.jdatepicker.impl.*;

/**
 *
 * @author elmottaki
 */
public class ListVenteFrame extends JDialog{
    JTextField txtId,txtTotal;
    JDatePickerImpl dateDebut;
    JDatePickerImpl dateFin;
    JButton btnClientSearch,btnSearch;
    JLabel lblClient;
    JTable tableResult;
    String[] tableResultTilties;
    JButton btnValider,btnAnnuler;
    public ListVenteFrame(JFrame parent,boolean modal){
        super(parent,modal);
        init();
        pack();
        this.setLocationRelativeTo(null);
    }
    
    public void init(){
        LangueModel lm = new LangueModel();
        this.setLayout(new MigLayout());
        // partie de recherche
        JPanel panelSearch = new JPanel(new MigLayout());
        panelSearch.add(new MyLabel(lm.getStringWithSpace("id_client")+":",14));
        txtId = new MyText("");
        panelSearch.add(txtId,"w 220px,wrap");
        panelSearch.add(new MyLabel(lm.getStringWithSpace("total")+":",14));
        txtTotal = new MyText("");
        panelSearch.add(txtTotal,"w 220px,wrap");
        lblClient = new MyLabel(lm.getStringWithSpace("client")+"...", 14);
        panelSearch.add(lblClient);
        btnClientSearch = new MyButton(lm.getString("client"), new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20, Color.BLACK));
        panelSearch.add(btnClientSearch,"wrap");
        panelSearch.add(new MyLabel(lm.getStringWithSpace("date_debut")+":",14));
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        dateDebut = new JDatePickerImpl(new  JDatePanelImpl(new UtilDateModel(),p), new DateFormatter());
        panelSearch.add(dateDebut,"w 220px,wrap");
        panelSearch.add(new MyLabel(lm.getStringWithSpace("date_fin")+":",14));
        dateFin = new JDatePickerImpl(new  JDatePanelImpl(new UtilDateModel(),p), new DateFormatter());
        panelSearch.add(dateFin,"w 220px,wrap");
        btnSearch = new MyButton(lm.getString("client"), new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20, Color.BLACK));
        panelSearch.add(btnSearch,"skip 2");
        this.add(panelSearch,"dock north");
        // tableau de result 
        tableResultTilties = new String[]{lm.getString("id_client"),lm.getString("date"),lm.getString("total"),lm.getString("client")};
        tableResult = new JTable(new DefaultTableModel(new String[][]{}, tableResultTilties));
        this.add(new JScrollPane(tableResult),"dock center");
        // les button 
        JPanel panelSud = new JPanel(new MigLayout("center"));
        btnValider = new MyButton(lm.getString("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20, Color.black));
        btnAnnuler = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.CANCEL_ICON, 20, Color.black));
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
                new ListVenteFrame(null,true).setVisible(true);
            }
        });
    }
    
}
