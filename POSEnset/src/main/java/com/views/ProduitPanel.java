/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.entities.Categorie;
import com.entities.Produit;
import com.models.AwsomeIcon;
import com.models.GRessource;
import com.models.LangueModel;
import com.models.OctiCon;
import com.widgets.MyButton;
import com.widgets.MyDateText;
import com.widgets.MyLabel;
import com.widgets.MyListModel;
import com.widgets.MyListProRroRenderer;
import com.widgets.MyText;
import com.widgets.ProduitWidget;
import controlors.StockControlor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.embed.swing.JFXPanel;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ProduitPanel extends JFXPanel implements MyPanel {

    JTextField txtNameSearch, txtPrixAchatSearch, txtPrixVenteSearch;
    JComboBox<Categorie> comboCatSearch;
    MyButton btnSearch;
    JButton btnSave, btnNew, btnDel;
    JList<Produit> listProduit;
    JLabel imgPro;
    JTextField txtRef, txtNom, txtPrixAchat, txtPrixVentre, txtTaxe, txtQte;
    JComboBox<Categorie> comboCat;
    byte image[] = null;
    Produit selProduit = null;
    List<Produit> list = null;

    public ProduitPanel() {
        init();
    }

    @Override
    public void refresh() {

        // change														// Templates.
    }

    public void init() {
        LangueModel lm = new LangueModel();
        this.setLayout(new MigLayout("fill"));
        btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(
                AwsomeIconConst.SAVE_ICON, 20));
        btnDel = new MyButton(lm.getString("SUPPRIMER"), new AwsomeIcon(
                AwsomeIconConst.DEL_ICON, 20));
        btnNew = new MyButton(lm.getString("NOUVEAU"), new AwsomeIcon(
                AwsomeIconConst.NEW_ICON, 20));
        // partie de recherche
        JPanel panelSearch = new JPanel(new MigLayout("insets 12px"));
        panelSearch.add(new MyLabel(lm.getString("nom") + " :", 14));
        txtNameSearch = new MyText("");
        panelSearch.add(txtNameSearch, "w 200px,wrap");
        panelSearch.add(new MyLabel(lm.getString("prix_achat") + " :", 14));
        txtPrixAchatSearch = new MyText("");
        panelSearch.add(txtPrixAchatSearch, "w 200px,wrap");
        panelSearch.add(new MyLabel(lm.getString("prix_vente") + " :", 14));
        txtPrixVenteSearch = new MyText("");
        panelSearch.add(txtPrixVenteSearch, "w 200px,wrap");
        panelSearch.add(new MyLabel(lm.getString("categorie") + " :", 14));
        comboCatSearch = new JComboBox<Categorie>();
        loadCatSearch();
        panelSearch.add(comboCatSearch, "w 200px,wrap");
        // panel de btn
        btnSearch = new MyButton(lm.getString("chercher"), new AwsomeIcon(
                AwsomeIconConst.SEARCH_ICON, 20, Color.black));
        panelSearch.add(btnSearch, "skip 2");
        this.add(panelSearch, "dock north");
        // les Button de controle
        JPanel proPanel = new JPanel(new MigLayout("fill,insets 3px"));
        JPanel btnPanel = new JPanel(new MigLayout("rtl"));
        btnPanel.add(btnSave);
        btnPanel.add(btnDel);
        btnPanel.add(btnNew);
        proPanel.add(btnPanel, "dock north");
        listProduit = new JList();
        listProduit.setCellRenderer(new MyListProRroRenderer());
        JPanel panelProInfo = new JPanel(new MigLayout("insets 5px"));
        JScrollPane proScr = new JScrollPane(listProduit);
        proScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        proPanel.add(proScr, "h 100%,w 300:300:300");
        proPanel.add(panelProInfo, "h 100%,w 100%");
        // info de produit
        panelProInfo.setBorder(BorderFactory
                .createLineBorder(Constants.TEXT_COLOR));
        JPanel panelImg = new JPanel(new MigLayout());
        imgPro = new JLabel();
        imgPro.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        setProduitImg();
        panelImg.add(imgPro, "span 2,wrap");
        panelProInfo.add(panelImg, "dock north");
        panelProInfo.add(new MyLabel(lm.getString("reference") + " :", 14));
        txtRef = new MyText("");
        panelProInfo.add(txtRef, "w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("nom") + " :", 14));
        txtNom = new MyText("");
        panelProInfo.add(txtNom, "w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("prix_achat") + " :", 14));
        txtPrixAchat = new MyText("");
        panelProInfo.add(txtPrixAchat, "w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("prix_vente") + " :", 14));
        txtPrixVentre = new MyText("");
        panelProInfo.add(txtPrixVentre, "w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("taxe") + " :", 14));
        txtTaxe = new MyText("");
        panelProInfo.add(txtTaxe, "split 2,w 150px");
        panelProInfo.add(new MyLabel("%", 16), "w 50,wrap");
        panelProInfo.add(new MyLabel(lm.getString("qte_stock") + " :", 14));
        txtQte = new MyText("");
        panelProInfo.add(txtQte, "w 200px,wrap");
        panelProInfo.add(new MyLabel(lm.getString("categorie") + " :", 14));
        comboCat = new JComboBox<Categorie>();
        loadCat();
        panelProInfo.add(comboCat, "w 200px,wrap");
        this.add(proPanel, "dock center");
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
        imgPro.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fch = new JFileChooser();
                fch.setMultiSelectionEnabled(false);
                fch.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fch.showOpenDialog(null);
                if (fch.getSelectedFile() != null) {
                    String type = new MimetypesFileTypeMap().getContentType(
                            fch.getSelectedFile()).split("/")[0];
                    if (type.equals("image")) {
                        try {
                            image = Files.readAllBytes(fch.getSelectedFile()
                                    .toPath());
                            setProduitImg();
                        } catch (IOException ex) {
                            Logger.getLogger(ProduitPanel.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        }

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        refrechList();

    }

    public void refrechList() {
        try {
            list = StockControlor.fetchAllProducts();
            addProds(list);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void addProds(List<Produit> produits) {
        listProduit.setModel(new MyListModel<Produit>(produits));
        listProduit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (listProduit.getSelectedIndex() != -1) {
                    prodClicked(listProduit.getModel().getElementAt(
                            listProduit.getSelectedIndex()));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void prodClicked(Produit prod) {
        selProduit = prod;
        txtRef.setText(prod.getReferance());
        txtNom.setText(prod.getDesigniation());
        txtPrixAchat.setText(prod.getPrixAchat() + "");
        txtPrixVentre.setText(prod.getPrixVente() + "");
        txtQte.setText(prod.getQuantiteEnStock() + "");
        txtTaxe.setText(prod.getTva() + "");
        image = prod.getImage();
        setProduitImg();

    }

    // fonction qui se declanche quand on clique sur le boutton chercher
    private void searchAction() {

        String pv = txtPrixVenteSearch.getText();
        if (pv.equals("")) {
            pv = "0";
        }

        String pa = txtPrixAchatSearch.getText();
        if (pa.equals("")) {
            pa = "0";
        }

        String name = txtNameSearch.getText();
        if (name.equals("")) {
            name = "0";
        }

        System.out.println(pv + " " + pa + " " + name);
        try {

            list = StockControlor.searchProduct(
                    name, pa,
                    pv,
                    (Categorie) comboCatSearch.getSelectedItem());
            refrechList();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // fonction qui se declanche quand on click sur le boutton enregistrer
    private void saveAction() {
        try {
            if (selProduit == null) {
                StockControlor.saveProduct(image, txtRef.getText(),
                        txtNom.getText(), txtPrixAchat.getText(), txtPrixVentre.getText(),
                        txtTaxe.getText(), txtQte.getText(),
                        (Categorie) comboCat.getSelectedItem());

            } else {
                StockControlor.updateProduct(listProduit.getModel()
                        .getElementAt(listProduit.getSelectedIndex()), image,
                        txtRef.getText(), txtNom.getText(), txtPrixAchat
                        .getText(), txtPrixVentre.getText(), txtTaxe
                        .getText(), txtQte.getText(),
                        (Categorie) comboCat.getSelectedItem());
            }
            refrechList();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // fonction qui se declanche quand on click sur le boutton supprimer
    private void deleteAction() {
        try {
            if (listProduit.getSelectedIndex() == -1) {
                throw new Exception("il faut selectionner un produit !");
            }
            StockControlor.deleteProduct(listProduit.getModel().getElementAt(
                    listProduit.getSelectedIndex()));
            refrechList();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // fonction qui se declanche quand on click sur le boutton nouveau
    private void newAction() {
        txtRef.setText("");
        txtNom.setText("");
        txtPrixAchat.setText("");
        txtPrixVentre.setText("");
        txtQte.setText("");
        txtTaxe.setText("");
        image = null;
        selProduit = null;
        setProduitImg();

    }

    private void setProduitImg() {
        if (image == null) {
            imgPro.setIcon(GRessource.getIcon("Product.png", 100));
        } else {
            imgPro.setIcon(GRessource.getImage(image, 100));

        }
    }

    private void loadCat() {
        try {
            List<Categorie> list = StockControlor.fetchAllCategories();
            Iterator<Categorie> it = list.iterator();
            while (it.hasNext()) {
                comboCat.addItem(it.next());
            }
        } catch (Exception ex) {
            Logger.getLogger(ProduitPanel.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    private void loadCatSearch() {
        try {
            List<Categorie> list = StockControlor.fetchAllCategories();
            Iterator<Categorie> it = list.iterator();
            while (it.hasNext()) {
                comboCatSearch.addItem(it.next());
            }
        } catch (Exception ex) {
            Logger.getLogger(ProduitPanel.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}
