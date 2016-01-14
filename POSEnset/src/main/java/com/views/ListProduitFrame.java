/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.entities.Produit;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyTableRenderer;
import com.widgets.MyText;
import controlors.StockControlor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ListProduitFrame extends JDialog {

    JTextField txtRef, txtDes, txtPrix;
    JButton btnSearch;
    JTable tableResult;
    String tableResultTiltles[];
    JButton btnValider, btnAnnuler;
    ArrayList<Produit> list = new ArrayList<Produit>();

    public ListProduitFrame(JFrame parent, boolean modal) {
        super(parent, modal);
        init();
        pack();
        this.setLocationRelativeTo(null);
    }

    public void init() {
        this.setLayout(new MigLayout());
        LangueModel lm = new LangueModel();
        this.setLocationRelativeTo(null);
        this.tableResultTiltles = new String[]{"Reference", "designation", "Prix de vente"};
        // partie de recherche
        JPanel panelTop = new JPanel(new MigLayout());
        txtRef = new MyText("");
        txtDes = new MyText("");
        txtPrix = new MyText("");
        panelTop.add(new MyLabel("Reference" + ":", 14));
        panelTop.add(txtRef, "w 220px,wrap");
        panelTop.add(new MyLabel("designation" + ":", 14));
        panelTop.add(txtDes, "w 220px,wrap");
        panelTop.add(new MyLabel("Prix de vente" + ":", 14));
        panelTop.add(txtPrix, "w 220px,wrap");
        btnSearch = new MyButton(lm.getString("chercher"), new AwsomeIcon(AwsomeIconConst.SEARCH_PLUS_ICON, 20, Color.BLACK));
        panelTop.add(btnSearch, "push 2");
        this.add(panelTop, "dock north");
        // tableau qui contient result de recherche
        JPanel panelCentre = new JPanel(new MigLayout());
        tableResult = new JTable(new DefaultTableModel(null, tableResultTiltles));
        tableResult.setDefaultRenderer(String.class, new MyTableRenderer());
        this.add(new JScrollPane(tableResult), "dock center");
        // les button
        JPanel panelSud = new JPanel(new MigLayout("center"));
        btnValider = new MyButton(lm.getString("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20, Color.black));
        btnAnnuler = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.CANCEL_ICON, 20, Color.black));
        panelSud.add(btnValider);
        panelSud.add(btnAnnuler);
        this.add(panelSud, "dock south");
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Produit> list = StockControlor.searchProduct(txtRef.getText(), txtDes.getText(), txtPrix.getText());
                    if (list != null) {
                        tableResult.setModel(new TModel(list));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR);
                }
            }
        });
        btnAnnuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int tab[] = tableResult.getSelectedRows();
                if (tab.length > 0) {
                    list.clear();
                    for (int i = 0; i < tab.length; i++) {
                        list.add(((TModel) tableResult.getModel()).get(i));
                    }
                    btnAnnuler.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "if faut selectionner ou moins un ligne !", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

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
                new ListProduitFrame(null, true).setVisible(true);
            }
        });
    }

    private class TModel implements TableModel {

        String title[] = {"Reference", "Designation", "Prix de vente"};
        List<Produit> list;

        public TModel(List<Produit> list) {
            this.list = list;
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
                    return list.get(rowIndex).getReferance();
                case 1:
                    return list.get(rowIndex).getDesigniation();
                case 2:
                    return list.get(rowIndex).getPrixVente();

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
            return list.get(ind);
        }

    }

    public ArrayList<Produit> getList() {
        return list;
    }

    public void setList(ArrayList<Produit> list) {
        this.list = list;
    }

}
