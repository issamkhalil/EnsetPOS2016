/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.models.OctiCon;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class VentePanel extends JPanel implements MyPanel{
    JLabel lblClient;
    JButton btnClient,btnValider,btnNew,btnMod,btnDel;
    JButton btnDelLigne,btnSearch;
    JTable tableProduct;
    String tableTitles[];
    JLabel lblTHT,lblTotal;
    JList<String> listProduct;
    JPanel panelProduct;
    public VentePanel(){
        init();
    }
    public void init(){
        this.setLayout(new MigLayout());
        LangueModel lm = new LangueModel();
        tableTitles = new String[]{lm.getStringWithSpace("produit"),lm.getStringWithSpace("prix"),lm.getStringWithSpace("qte"),lm.getStringWithSpace("taxe"),lm.getStringWithSpace("prix_ht"),lm.getStringWithSpace("total")};
        // top Panel 
        JPanel panelTop = new JPanel(new MigLayout());
        lblClient = new MyLabel(lm.getStringWithSpace("client")+"...",16);
       panelTop.add(lblClient);
       btnClient = new MyButton(lm.getStringWithSpace("client"));
       panelTop.add(btnClient);
       JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
       panelTop.add(sep1,"h 100%");
       btnValider = new MyButton(lm.getStringWithSpace("valider"));
       panelTop.add(btnValider);
       
        btnMod = new MyButton("", new AwsomeIcon(AwsomeIconConst.MOD_ICON, 24,Color.BLACK));
        btnDel = new MyButton("", new AwsomeIcon(AwsomeIconConst.DEL_ICON, 24,Color.BLACK));
        btnNew = new MyButton("", new AwsomeIcon(AwsomeIconConst.NEW_ICON, 24,Color.BLACK));
        JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
        panelTop.add(sep2,"h 100%");
        panelTop.add(btnNew);
        panelTop.add(btnMod);
        panelTop.add(btnDel);
        this.add(panelTop,"dock north,w 100%");
        
        // panel de centre 
        // top
        JPanel panelCentre = new JPanel(new MigLayout());
        JPanel panelCentreTop = new JPanel(new MigLayout());
        JPanel panelCentreTopSud = new JPanel(new MigLayout("rtl"));
        tableProduct = new JTable(new DefaultTableModel( new String[][]{},tableTitles));
        panelCentreTop.add(new JScrollPane(tableProduct),"w 75%");
        JPanel panelCentreTopBtn = new JPanel(new MigLayout());
        btnDelLigne = new MyButton(lm.getStringWithSpace("sup_line"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20, Color.BLACK));
        btnSearch = new MyButton(lm.getStringWithSpace("chercher"), new AwsomeIcon(AwsomeIconConst.SEARCH_PLUS_ICON, 20, Color.BLACK));
        panelCentreTopBtn.add(btnDelLigne,"wrap,w 200px");
        panelCentreTopBtn.add(btnSearch,"wrap,w 200px");
        panelCentreTop.add(panelCentreTopBtn,"W 25%");
        // sud
        lblTHT = new MyLabel(" ", 14);
        lblTHT.setBackground(Color.WHITE);
        lblTHT.setOpaque(true);
        panelCentreTopSud.add(lblTHT,"w 150px");
        panelCentreTopSud.add(new MyLabel(lm.getStringWithSpace("total_ht"),14));
        lblTotal = new MyLabel(" ", 14);
        lblTotal.setBackground(Color.white);
        lblTotal.setOpaque(true);
        panelCentreTopSud.add(lblTotal,"w 150px");
        panelCentreTopSud.add(new MyLabel(lm.getStringWithSpace("total"), 14));
        panelCentreTop.add(panelCentreTopSud,"dock south");
        panelCentre.add(panelCentreTop,"W 100%");
        this.add(panelCentre,"dock center");
        // panel sud
        JPanel panelCentreSud = new JPanel(new MigLayout("fill"));
        listProduct = new JList<String>();
        panelCentreSud.add(new JScrollPane(listProduct),"h 100%,w 25%");
        panelProduct = new JPanel(new MigLayout());
        panelProduct.setBorder(BorderFactory.createTitledBorder(lm.getStringWithSpace("produits")));
        panelCentreSud.add(panelProduct,"h 100%,w 75%");
        panelCentre.add(panelCentreSud,"dock south,h 100%");
        
        
        
        
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
