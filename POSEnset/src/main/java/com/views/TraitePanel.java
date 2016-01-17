/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.entities.Client;
import com.entities.Tranche;
import com.entities.Vente;
import com.jidesoft.swing.JideSplitPane;
import com.jidesoft.swing.JideTitledBorder;
import com.jidesoft.swing.PartialEtchedBorder;
import com.jidesoft.swing.PartialSide;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyListClientRenderer;
import com.widgets.MyListModel;
import com.widgets.MyListVenteRenderer;
import com.widgets.TrancheWidget;
import controlors.VentesControlor;
import controlors.traitesControlor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class TraitePanel extends JPanel implements MyPanel {

    JButton btnSearch;
    JList<Client> listClient;
    JList<Vente> listVente;
    private JPanel traitePanel;

    public TraitePanel() {
        init();
    }

    public void init() {
        this.setLayout(new MigLayout("rtl"));
        JPanel btnPanel = new JPanel(new MigLayout());
        LangueModel lm = new LangueModel();
        btnSearch = new MyButton("Chercher Client", new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20));
        btnPanel.add(btnSearch);
        this.add(btnPanel, "dock north");
        // client panel
        JPanel clientPanel = new JPanel(new MigLayout());
        clientPanel.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Les Clients"));
        listClient = new JList();
        JScrollPane clientScr = new JScrollPane(listClient);
        clientScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        clientPanel.add(clientScr, "dock center");
        // vente panel
        JPanel ventePanel = new JPanel(new MigLayout());
        ventePanel.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Les Ventes"));
        listVente = new JList<Vente>();
        JScrollPane venteScr = new JScrollPane(listVente);
        venteScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        ventePanel.add(venteScr, "dock center");

        // traites panel
         traitePanel = new JPanel(new MigLayout("fillx"));
        traitePanel.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Les Traites"));
       JScrollPane trScr = new JScrollPane(traitePanel);
        trScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
// centainer
 
        JPanel container = new JPanel(new MigLayout());
        container.add(clientScr, "w 30%,h 100%");
        container.add(venteScr, "w 30%,h 100%");
        container.add(trScr, "w 40%,h 100%");
        this.add(container, "dock center");
        listClient.setCellRenderer(new MyListClientRenderer());
        listVente.setCellRenderer(new MyListVenteRenderer());
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchAction();
            }
        });
        listClient.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                clientClickAction(listClient.getSelectedValue());
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
        listVente.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2)
                venteClickAction(listVente.getSelectedValue());
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
    private void venteClickAction(Vente vente){
        try{
            List<Tranche> list = traitesControlor.fetchTranches(vente);
            addTranches(list);
        }catch(Exception ex){
        	ex.printStackTrace();
        	JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);

        }
        
    }
    private void clientClickAction(Client client) {
        try {
            if (client != null) {
                List<Vente> list = VentesControlor.fetchVentes(client);
                if(list!=null){
                    addVentes(list);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchAction() {
        ListClientFrame frame = new ListClientFrame(null, true);
        frame.setVisible(true);
        if (frame.getList() != null && frame.getList().size() != 0) {
            listClient.setModel(new MyListModel<Client>(frame.getList()));
        }
    }

    public void addClients(List<Client> clients) {
        listClient.setModel(new MyListModel<Client>(clients));
    }

    public void addVentes(List<Vente> ventes) {
        listVente.setModel(new MyListModel<Vente>(ventes));
    }
    public void addTranches(List<Tranche> tranches){
        traitePanel.removeAll();
        for(int i=0;i<tranches.size();i++){
            TrancheWidget wid = new TrancheWidget(tranches.get(i),this);
            traitePanel.add(wid,"wrap,growx");
        }
        traitePanel.revalidate();
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
