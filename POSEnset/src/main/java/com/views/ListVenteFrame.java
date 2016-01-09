/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.entities.Client;
import com.entities.Produit;
import com.entities.Vente;
import com.models.AwsomeIcon;
import com.models.DateLabelFormatter;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyText;
import controlors.VentesControlor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DateFormatter;
import org.jdatepicker.impl.JDatePickerImpl;
import net.miginfocom.swing.MigLayout;
import org.jdatepicker.impl.*;

/**
 *
 * @author elmottaki
 */
public class ListVenteFrame extends JDialog {

    JTextField txtId, txtTotal;
    JDatePickerImpl dateDebut;
    JDatePickerImpl dateFin;
    JButton btnClientSearch, btnSearch;
    JLabel lblClient;
    JTable tableResult;
    String[] tableResultTilties;
    JButton btnValider, btnAnnuler;
    ArrayList<Vente> list;
    private Client client;

    public ListVenteFrame(JFrame parent, boolean modal) {
        super(parent, modal);
        init();
        pack();
        this.setLocationRelativeTo(null);
    }

    public void init() {
        LangueModel lm = new LangueModel();
        this.setLayout(new MigLayout());
        // partie de recherche
        JPanel panelSearch = new JPanel(new MigLayout());
        panelSearch.add(new MyLabel(lm.getStringWithSpace("id_client") + ":", 14));
        txtId = new MyText("");
        panelSearch.add(txtId, "w 220px,wrap");
        panelSearch.add(new MyLabel(lm.getStringWithSpace("total") + ":", 14));
        txtTotal = new MyText("");
        panelSearch.add(txtTotal, "w 220px,wrap");
        btnClientSearch = new MyButton(lm.getString("client"), new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20, Color.BLACK));
        panelSearch.add(btnClientSearch);
        lblClient = new MyLabel(lm.getStringWithSpace("client") + "...", 14);
        lblClient.setBackground(Color.LIGHT_GRAY);
        lblClient.setOpaque(true);
        lblClient.setFont(new Font("Arial", Font.ITALIC, 12));
        lblClient.setHorizontalAlignment(JLabel.CENTER);
        panelSearch.add(lblClient, "wrap,w 120px,h 26px");
        
        panelSearch.add(new MyLabel(lm.getStringWithSpace("date_debut") + ":", 14));
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        dateDebut = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());
        panelSearch.add(dateDebut, "w 220px,wrap");
        panelSearch.add(new MyLabel(lm.getStringWithSpace("date_fin") + ":", 14));
        dateFin = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());
        panelSearch.add(dateFin, "w 220px,wrap");
        btnSearch = new MyButton("Chercher", new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20, Color.BLACK));
        panelSearch.add(btnSearch, "skip 2");
        this.add(panelSearch, "dock north");
        // tableau de result 
        tableResultTilties = new String[]{lm.getString("id_client"), lm.getString("date"), lm.getString("total"), lm.getString("client")};
        tableResult = new JTable(new DefaultTableModel(new String[][]{}, tableResultTilties));
        this.add(new JScrollPane(tableResult), "dock center");
        // les button 
        JPanel panelSud = new JPanel(new MigLayout("center"));
        btnValider = new MyButton(lm.getString("valider"), new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 20, Color.black));
        btnAnnuler = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.CANCEL_ICON, 20, Color.black));
        panelSud.add(btnAnnuler);
        panelSud.add(btnValider);
        this.add(panelSud, "dock south");
        btnAnnuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                list = ((TModel) tableResult.getModel()).getList();
                btnAnnuler.doClick();
            }
        });
        btnClientSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchClientAction();
            }
        });
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchAction();
            }
        });
    }
    private void searchAction(){
        try{
            ArrayList<Vente> listVente = (ArrayList<Vente>)VentesControlor.searchVentes(txtId.getText(),txtTotal.getText(),client,(Date)dateDebut.getModel().getValue(),(Date)dateFin.getModel().getValue());
            tableResult.setModel(new TModel(listVente));
        }catch(Exception ex){
            
        }
    }
    
    private void searchClientAction() {
        ListClientFrame fr = new ListClientFrame(null, true);
        fr.setVisible(true);
        if (fr.getList().size() > 0) {
            client = fr.getList().get(0);
            lblClient.setText(client.getId() + " - " + client.getNom());
        }
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
                new ListVenteFrame(null, true).setVisible(true);
            }
        });
    }

    private class TModel implements TableModel {

        String title[] = {"ID Vente", "total", "Client", "Date"};
        ArrayList<Vente> list;

        public TModel(ArrayList<Vente> list) {
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
                    return list.get(rowIndex).getTotale();
                case 2:
                    return list.get(rowIndex).getClient();
                case 3:
                    return list.get(rowIndex).getDate();

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

        public Vente get(int ind) {
            return list.get(ind);
        }

        public ArrayList<Vente> getList() {
            return list;
        }

    }

    public ArrayList<Vente> getList() {
        return list;
    }

    public void setList(ArrayList<Vente> list) {
        this.list = list;
    }
    

}
