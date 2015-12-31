/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.entities.Client;
import com.entities.ClientParticulier;
import com.entities.Produit;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyDateText;
import com.widgets.MyLabel;
import com.widgets.MyTableRenderer;
import com.widgets.MyText;
import controlors.ListClientControlor;
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
public class ListClientFrame extends JDialog {

    JTextField txtId, txtNom, txtPrenom;
    JButton btnSearch;
    JTable tableResult;
    String tableResultTiltles[];
    JButton btnValider, btnAnnuler;
    ArrayList<Client> list = new ArrayList<Client>();
    public ListClientFrame(JFrame parent, boolean modal) {
        super(parent, modal);
        init();
        pack();
        this.setLocationRelativeTo(null);
    }

    public void init() {
        this.setLayout(new MigLayout());
        LangueModel lm = new LangueModel();
        this.setLocationRelativeTo(null);
        this.tableResultTiltles = new String[]{lm.getString("id_client"), lm.getString("nom"), lm.getString("prenom")};
        // partie de recherche
        JPanel panelTop = new JPanel(new MigLayout());
        txtId = new MyText("");
        txtNom = new MyText("");
        txtPrenom = new MyText("");
        panelTop.add(new MyLabel(lm.getStringWithSpace("id_client") + ":", 14));
        panelTop.add(txtId, "w 220px,wrap");
        panelTop.add(new MyLabel(lm.getStringWithSpace("nom_client") + ":", 14));
        panelTop.add(txtNom, "w 220px,wrap");
        panelTop.add(new MyLabel(lm.getStringWithSpace("prenom_client") + ":", 14));
        panelTop.add(txtPrenom, "w 220px,wrap");
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
                    ArrayList<Client> list = ListClientControlor.search(txtId.getText(), txtNom.getText(), txtPrenom.getText());
                    tableResult.setModel(new TModel(list));
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
                    JOptionPane.showMessageDialog(null, "Information", "if faut selectionner ou moins un ligne !", JOptionPane.INFORMATION_MESSAGE);
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
                new ListClientFrame(null, true).setVisible(true);
            }
        });
    }

    private class TModel implements TableModel {

        String title[] = {"ID Client", "Nom", "Prenom"};
        ArrayList<Client> list;

        public TModel(ArrayList<Client> list) {
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
                    return list.get(rowIndex).getId();
                case 1:
                    return list.get(rowIndex).getNom();
                case 2:
                    if (list.get(rowIndex) instanceof ClientParticulier) {
                        ClientParticulier c = (ClientParticulier) list.get(rowIndex);
                        return c.getPrenom();
                    } else {
                        return "-----";
                    }

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

        public Client get(int ind) {
            return list.get(ind);
        }

    }

    public ArrayList<Client> getList() {
        return list;
    }

    public void setList(ArrayList<Client> list) {
        this.list = list;
    }

}
