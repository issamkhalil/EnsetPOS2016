/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.models.LangueModel;
import com.models.OctiCon;
import com.widgets.MyButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ClientPanel extends JPanel implements MyPanel{
    private JButton btnNew,btnDel,btnAdd;
    private JList<String> listClients;
    public ClientPanel(){
        this.setLayout(new MigLayout("fill"));
        init();
    }
    public void init(){
        // panel des buttons
        LangueModel lm = new LangueModel(com.models.ConfigModel.getProprety("langue"));
        JPanel btnPanel = new JPanel(new MigLayout("rtl"));
        btnAdd = new MyButton("", new OctiCon('\uf0c5', 24));
        btnDel = new MyButton("", new OctiCon('\uf0c5', 24));
        btnNew = new MyButton("", new OctiCon('\uf0c5', 24));
        btnPanel.add(btnAdd);
        btnPanel.add(btnDel);
        btnPanel.add(btnNew);
        btnPanel.setBackground(Color.red);
        this.add(btnPanel,"dock north");
        // panel des list
        JPanel panelContent = new JPanel(new MigLayout("fill"));
        this.add(panelContent,"dock center");
        listClients = new JList<String>();
        panelContent.add(listClients,"h 100%,w 20%");
        // panel des info
        JPanel panelInfo = new JPanel(new MigLayout("fill"));
        panelInfo.setBorder(BorderFactory.createTitledBorder(lm.getString("client_info")));
        panelContent.add(panelInfo,"h 100%,w 80%");
        
        
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
