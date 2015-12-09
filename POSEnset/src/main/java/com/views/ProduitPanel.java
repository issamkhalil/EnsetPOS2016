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
import com.widgets.MyDateText;
import com.widgets.MyLabel;
import com.widgets.MyText;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ProduitPanel  extends JFXPanel implements MyPanel{
    JTextField txtNameSearch,txtPrixAchatSearch,txtPrixVenteSearch;
    JComboBox<String> comboCatSearch;
    MyButton btnSearch;
    JButton btnSave,btnNew,btnDel;
    JList listProduit;
    JLabel imgPro ;
    JTextField txtRef,txtNom,txtPrixAchat,txtPrixVentre,txtTaxe,txtQte;
    JComboBox<String> comboCat;
    public ProduitPanel(){
        init();
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void init(){
        LangueModel lm = new LangueModel();
        this.setLayout(new MigLayout("fill"));
        btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(AwsomeIconConst.SAVE_ICON, 20));
        btnDel = new MyButton(lm.getString("SUPPRIMER"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20));
        btnNew = new MyButton(lm.getString("NOUVEAU"), new AwsomeIcon(AwsomeIconConst.NEW_ICON, 20));
        // partie de recherche 
        JPanel panelSearch = new JPanel(new MigLayout("insets 12px"));
        panelSearch.add(new MyLabel(lm.getString("nom")+" :",14));
        txtNameSearch = new MyText("");
        panelSearch.add(txtNameSearch,"w 200px,wrap");
        panelSearch.add(new MyLabel(lm.getString("prix_achat")+" :",14));
        txtPrixAchatSearch = new MyText("");
        panelSearch.add(txtPrixAchatSearch,"w 200px,wrap");
        panelSearch.add(new MyLabel(lm.getString("prix_vente")+" :",14));
        txtPrixVenteSearch = new MyText("");
        panelSearch.add(txtPrixVenteSearch,"w 200px,wrap");
        panelSearch.add(new MyLabel(lm.getString("categorie")+" :",14));
        comboCatSearch = new JComboBox<String>();
        panelSearch.add(comboCatSearch,"w 200px,wrap");
        // panel de btn
        JPanel panelBtnSearch = new JPanel(new MigLayout("fillx,rtl"));
        btnSearch = new MyButton(lm.getString("chercher"), new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20, Color.black));
        panelBtnSearch.add(btnSearch);
        panelSearch.add(panelBtnSearch,"dock south");
        this.add(panelSearch,"dock north");
        // les Button de controle 
        JPanel proPanel = new JPanel(new MigLayout("fill,insets 3px"));
        JPanel btnPanel = new JPanel(new MigLayout("rtl"));
        btnPanel.add(btnSave);
        btnPanel.add(btnDel);
        btnPanel.add(btnNew);
        proPanel.add(btnPanel,"dock north");
        listProduit = new JList();
        JPanel panelProInfo = new JPanel(new MigLayout("insets 5px"));
        proPanel.add(listProduit,"h 100%,w 25%");
        proPanel.add(panelProInfo,"h 100%,w 75%");
        // info de produit
        panelProInfo.setBorder(BorderFactory.createTitledBorder(lm.getString("product_info")));
        JPanel panelImg = new JPanel(new MigLayout());
        imgPro = new JLabel();
        imgPro.setBackground(Color.red);
        imgPro.setOpaque(true);
        panelImg.add(imgPro,"w 120px,h 120px");
        panelProInfo.add(panelImg,"dock north");
        panelProInfo.add(new MyLabel(lm.getString("reference")+" :",14));
        txtRef = new MyText("");
        panelProInfo.add(txtRef,"w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("nom")+" :",14));
        txtNom = new MyText("");
        panelProInfo.add(txtNom,"w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("prix_achat")+" :",14));
        txtPrixAchat = new MyText("");
        panelProInfo.add(txtPrixAchat,"w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("prix_vente")+" :",14));
        txtPrixVentre = new MyText("");
        panelProInfo.add(txtPrixVentre,"w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("taxe")+" :",14));
        txtTaxe = new MyText("");
        panelProInfo.add(txtTaxe,"split 2,w 150px");
        panelProInfo.add(new MyLabel("%",16),"w 50,wrap");
        panelProInfo.add(new MyLabel(lm.getString("qte_stock")+" :",14));
        txtQte = new MyText("");
        panelProInfo.add(txtQte,"w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("categorie")+" :",14));
        comboCat = new JComboBox<String>();
        panelProInfo.add(comboCat,"w 200px,wrap");
        this.add(proPanel,"dock center");
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchAction();
            }
        });
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveAction();
            }
        });
        btnDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAction();
            }
        });
        btnNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newAction();
            }
        });
        
        
        
    }
    
    // fonction qui se declanche quand on clique sur le boutton chercher
    private void searchAction(){
        // TODO implementer search action
    }
    // fonction qui se declanche quand on click sur le boutton enregistrer
    private void saveAction(){
        // TODO implementer save Action
    }
    // fonction qui se declanche quand on click sur le boutton supprimer
    private void deleteAction(){
        //TODO implementer delete Action
    }
    // fonction qui se declanche quand on click sur le boutton nouveau
    private void newAction(){
        //TODO implementer newAction
    }
    
}
