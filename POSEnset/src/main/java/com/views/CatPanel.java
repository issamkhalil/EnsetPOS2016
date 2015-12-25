/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.entities.Categorie;
import com.models.AwsomeIcon;
import com.models.GRessource;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyListCatRenderer;
import com.widgets.MyListModel;
import com.widgets.MyText;
import com.widgets.MyTextArea;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class CatPanel extends JPanel implements MyPanel{
    private JButton btnSave,btnNew,btnDel;
    private JList<Categorie> listCat;
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
        JPanel  topPanel = new JPanel(new MigLayout("rtl,gap 0 0 0 0"));
        topPanel.add(btnNew);
        topPanel.add(btnDel);
        topPanel.add(btnSave);
        this.add(topPanel,"dock north");
        // panel de centre
        JPanel centrePanel = new JPanel(new MigLayout("fill,insets 0 0 0 0"));
        listCat = new JList<Categorie>();
        listCat.setCellRenderer(new MyListCatRenderer());
        JScrollPane catScr = new JScrollPane(listCat);
        catScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        centrePanel.add(catScr,"w 300:300:300,h 90%");
        JPanel rCentrePanel = new JPanel(new MigLayout("debug"));
        rCentrePanel.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
//        rCentrePanel.setBackground(Color.red);
        centrePanel.add(rCentrePanel,"w 100%,h 90%");
        lblImg = new MyLabel(GRessource.getIcon("open_folder.png",120));
        lblImg.setOpaque(true);
        lblImg.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        rCentrePanel.add(lblImg,"wrap,w 120px,h 100px");
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
    
    public void addCategories(List<Categorie> list){
        listCat.setModel(new MyListModel<Categorie>(list));
        listCat.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(listCat.getSelectedIndex()!=-1)
                catClicked(listCat.getModel().getElementAt(listCat.getSelectedIndex()));
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
    
    public void catClicked(Categorie elementAt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
