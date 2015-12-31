/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.entities.Categorie;
import com.entities.Client;
import com.entities.ClientParticulier;
import com.entities.Produit;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.models.OctiCon;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.widgets.CatWidget;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyListCatRenderer;
import com.widgets.MyListModel;
import com.widgets.ProduitWidget;

import controlors.SalesControlor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class VentePanel extends JPanel implements MyPanel {

    JLabel lblClient;
    JButton btnClient, btnValider, btnNew, btnSave, btnDel;
    JButton btnDelLigne, btnSearch;
    JTable tableProduct;
    String tableTitles[];
    JLabel lblTHT, lblTotal;
    JPanel panelProduct;
    Client client;
    private JPanel catPanel;
    static int val = 0;
    private JList<Categorie> listCat;
    Map<Produit, Integer> listProduit;

    public VentePanel() {
        this.listProduit = new HashMap<Produit, Integer>();
        init();
    }

    public void init() {
        this.setLayout(new MigLayout());
        LangueModel lm = new LangueModel();
        tableTitles = new String[]{lm.getStringWithSpace("produit"), lm.getStringWithSpace("prix"), lm.getStringWithSpace("qte"), lm.getStringWithSpace("taxe"), lm.getStringWithSpace("prix_ht"), lm.getStringWithSpace("total")};
        // top Panel 
        JPanel panelTop = new JPanel(new MigLayout());
        lblClient = new MyLabel(lm.getStringWithSpace("client") + "...", 12);
        lblClient.setFont(new Font("Arial",Font.ITALIC,12));
        panelTop.add(lblClient);
        btnClient = new MyButton(lm.getStringWithSpace("client"), new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20));
        panelTop.add(btnClient);
        JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
        panelTop.add(sep1, "h 100%");
        btnValider = new MyButton(lm.getStringWithSpace("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20));
        panelTop.add(btnValider);

        btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(AwsomeIconConst.SAVE_ICON, 20));
        btnDel = new MyButton(lm.getString("SUPPRIMER"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20));
        btnNew = new MyButton(lm.getString("NOUVEAU"), new AwsomeIcon(AwsomeIconConst.NEW_ICON, 20));
        JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
        panelTop.add(sep2, "h 100%");
        panelTop.add(btnNew);
        panelTop.add(btnSave);
        panelTop.add(btnDel);
        this.add(panelTop, "dock north");

        // panel de centre 
        // top
        JPanel panelCentre = new JPanel(new MigLayout());
        JPanel panelCentreTop = new JPanel(new MigLayout());
        JPanel panelCentreTopSud = new JPanel(new MigLayout("rtl"));
        tableProduct = new JTable(new TModel(new HashMap<Produit,Integer>()));
        panelCentreTop.add(new JScrollPane(tableProduct), "w 75%");
        JPanel panelCentreTopBtn = new JPanel(new MigLayout());
        btnDelLigne = new MyButton(lm.getStringWithSpace("sup_line"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20, Color.BLACK));
        btnSearch = new MyButton(lm.getStringWithSpace("chercher"), new AwsomeIcon(AwsomeIconConst.SEARCH_PLUS_ICON, 20, Color.BLACK));
        panelCentreTopBtn.add(btnDelLigne, "wrap,w 200px");
        panelCentreTopBtn.add(btnSearch, "wrap,w 200px");
        panelCentreTop.add(panelCentreTopBtn, "W 25%");
        // sud
        lblTHT = new MyLabel(" ", 14);
        lblTHT.setBackground(Color.WHITE);
        lblTHT.setOpaque(true);
        panelCentreTopSud.add(lblTHT, "w 150px");
        panelCentreTopSud.add(new MyLabel(lm.getStringWithSpace("total_ht"), 14));
        lblTotal = new MyLabel(" ", 14);
        lblTotal.setBackground(Color.white);
        lblTotal.setOpaque(true);
        panelCentreTopSud.add(lblTotal, "w 150px");
        panelCentreTopSud.add(new MyLabel(lm.getStringWithSpace("total"), 14));
        panelCentreTop.add(panelCentreTopSud, "dock south");
        panelCentre.add(panelCentreTop, "W 100%");
        this.add(panelCentre, "dock center");
        // panel sud
        JPanel panelCentreSud = new JPanel(new MigLayout("fill"));
        listCat = new JList<Categorie>();
        listCat.setCellRenderer(new MyListCatRenderer());
        JScrollPane catScr = new JScrollPane(listCat);
        catScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelCentreSud.add(catScr, "h 92%,w 300:300:300");
        panelProduct = new JPanel(new MigLayout("insets 4 4 4 4"));
        JScrollPane proScr = new JScrollPane(panelProduct);
        proScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelCentreSud.add(proScr, "h 92%,w 100%");
        panelCentre.add(panelCentreSud, "dock south,h 100%");

        // test 
        btnClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ListClientFrame fr = new ListClientFrame(null, true);
                fr.setVisible(true);
                if (fr.getList().size() > 0) {
                    client = fr.getList().get(0);
                    lblClient.setText(client.getId()+" - "+client.getNom());
                }
            }
        });
        btnDelLigne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delLigneAction();
            }
        });
        btnNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newAction();
            }
        });
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validerAction();
            }
        });

    }
    public void validerAction(){
        if(tableProduct.getRowCount()!=0){
            new PaimentFrame(null, true, listProduit).setVisible(true);
        }
    }
    public void newAction(){
        listProduit.clear();
        tableProduct.setModel(new TModel(listProduit));
        calculTotal();
        client = null;
        lblClient.setText("Client ...");
    }
    public void delLigneAction(){
        if(tableProduct.getRowCount()!=1){
        listProduit.remove(((TModel)tableProduct.getModel()).get(tableProduct.getSelectedRow()));
        tableProduct.setModel(new TModel(listProduit));
        calculTotal();
        }
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addCategories(ArrayList<Categorie> list) {
        listCat.setModel(new MyListModel<Categorie>(list));
    }

    private void catClicked(Categorie categorie) {
        //System.out.println("categorie : "+categorie.getNom());
        Main main = (Main) this.getTopLevelAncestor();
        SalesControlor.ListerProdParCatAction(main, categorie);
    }

    public void addProducts(List<Produit> produits) {
        Iterator<Produit> it = produits.iterator();
        panelProduct.removeAll();
        while (it.hasNext()) {
            ProduitWidget pro = new ProduitWidget(it.next());
            panelProduct.add(pro);
            pro.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ProduitWidget wid = (ProduitWidget) e.getSource();
                    wid.setSelected(wid);
                    Component tabc[] = panelProduct.getComponents();
                    for (int i = 0; i < tabc.length; i++) {
                        ProduitWidget pro = (ProduitWidget) tabc[i];
                        pro.setBorder();
                    }
                    if (e.getClickCount() == 2) {
                        catDBClicked(wid.getProduit());
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
        panelProduct.revalidate();
        this.updateUI();
    }

    private void catDBClicked(Produit produit) {
        Integer val = listProduit.get(produit);
            if (val == null) {
                listProduit.put(produit, 1);
            } else {
                listProduit.put(produit, val + 1);
            }
            tableProduct.setModel(new TModel(listProduit));
            calculTotal();
    }
    
    public void calculTotal(){
        ArrayList<Produit> pro = new ArrayList<Produit>(listProduit.keySet());
        double tht=0,total=0;
        for(int i=0;i<pro.size();i++){
            tht+=pro.get(i).getPrixVente()*listProduit.get(pro.get(i));
            total+=pro.get(i).getPrixVente()*(listProduit.get(pro.get(i))*(1+pro.get(i).getTva()/100));
        }
        lblTHT.setText(String.format("%.2f", tht));
        lblTotal.setText(String.format("%.2f", total));
    }

    private class TModel implements TableModel {
        String title[] = tableTitles;
        Map<Produit, Integer> list;
        List<Produit> produits;

        public TModel(Map<Produit, Integer> listProduit) {
            this.list = listProduit;
            produits = new ArrayList<Produit>(listProduit.keySet());
            
        }

        @Override
        public int getRowCount() {
            return list.size();
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return title[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return produits.get(rowIndex).getDesigniation();
                case 1:
                    return (produits.get(rowIndex).getPrixVente())*((produits.get(rowIndex).getTva()/100)+1);
                case 2:
                    return list.get(produits.get(rowIndex));
                case 3:
                    return (produits.get(rowIndex)).getTva();
                case 4:
                    return produits.get(rowIndex).getPrixVente();
                case 5:
                    return (produits.get(rowIndex).getPrixVente()*((produits.get(rowIndex).getTva()/100)+1)*(list.get(produits.get(rowIndex))));

            }
            return "";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

        }

        public Produit get(int ind) {
            return produits.get(ind);
        }



    }
}
