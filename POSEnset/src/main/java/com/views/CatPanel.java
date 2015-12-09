/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import com.models.GRessource;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyText;
import com.widgets.MyTextArea;
import java.awt.Color;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class CatPanel extends JPanel implements MyPanel{
    private JButton btnSave,btnNew,btnDel;
    private JList<String> listCat;
    private JLabel lblImg;
    private JTextField txtName;
    private JTextArea txtDescription;
    
    
    public CatPanel(){
        init();
    }
    private void init(){
        this.setLayout(new MigLayout("fill"));
        LangueModel lm = new LangueModel();
        btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(AwsomeIconConst.SAVE_ICON, 20));
        btnDel = new MyButton(lm.getString("SUPPRIMER"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20));
        btnNew = new MyButton(lm.getString("NOUVEAU"), new AwsomeIcon(AwsomeIconConst.NEW_ICON, 20));
        // panel des bouttons
        JPanel  topPanel = new JPanel(new MigLayout("rtl"));
        topPanel.add(btnNew);
        topPanel.add(btnDel);
        topPanel.add(btnSave);
        this.add(topPanel,"dock north");
        // panel de centre
        JPanel centrePanel = new JPanel(new MigLayout("fill"));
        listCat = new JList<String>();
        centrePanel.add(listCat,"w 20%,h 100%");
        JPanel rCentrePanel = new JPanel(new MigLayout("debug"));
//        rCentrePanel.setBackground(Color.red);
        centrePanel.add(rCentrePanel,"w 80%,h 100%");
        lblImg = new MyLabel(GRessource.getIcon("open_folder.png",120));
        lblImg.setOpaque(true);
        lblImg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rCentrePanel.add(lblImg,"wrap,span 2,w 120px,h 100px");
        rCentrePanel.add(new MyLabel(lm.getString("NOM")));
        txtName = new MyText("");
        rCentrePanel.add(txtName,"w 200px,wrap");
        rCentrePanel.add(new MyLabel(lm.getString("DESCRIPTION")));
        txtDescription = new MyTextArea("");
        rCentrePanel.add(txtDescription,"w 200px,wrap,h 200px");
        this.add(centrePanel,"dock center");
        
        
        
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
