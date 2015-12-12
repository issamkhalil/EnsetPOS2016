/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.jidesoft.swing.TitledSeparator;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyPassText;
import com.widgets.MyText;
import javafx.embed.swing.JFXPanel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ComptePanel extends JFXPanel implements MyPanel{
    private MyButton btnSave;
    private MyButton btnDel;
    private MyButton btnNew;
    private JList<String> listClients;
    private MyText txtNom;
    private MyText txtTele;
    private MyText txtMail;
    private MyText txtPrenom;
    private MyText txtLogin;
    private MyPassText txtPass;
    private JComboBox<String> comboType;

    
    public ComptePanel(){
        init();
    }
    public void init(){
        // panel des buttons
        this.setLayout(new MigLayout("fill"));
        LangueModel lm = new LangueModel(com.models.ConfigModel.getProprety("langue"));
        JPanel btnPanel = new JPanel(new MigLayout("rtl"));
        btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(AwsomeIconConst.SAVE_ICON, 20));
        btnDel = new MyButton(lm.getString("SUPPRIMER"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20));
        btnNew = new MyButton(lm.getString("NOUVEAU"), new AwsomeIcon(AwsomeIconConst.NEW_ICON, 20));
        btnPanel.add(btnSave);
        btnPanel.add(btnDel);
        btnPanel.add(btnNew);
        this.add(btnPanel,"dock north");
        // panel des list
        JPanel panelContent = new JPanel(new MigLayout("fill"));
        this.add(panelContent,"dock center");
        listClients = new JList<String>();
        JScrollPane clientScr = new JScrollPane(listClients);
        clientScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelContent.add(clientScr,"growy,w 25%");
        // panel des info
        JPanel panelInfo = new JPanel(new MigLayout("center,fill"));
        panelInfo.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelContent.add(panelInfo,"growy,w 75%");
        // les info 
        JPanel container = new JPanel(new MigLayout("center"));
        container.add(new MyLabel("Nom"));
        txtNom = new MyText("");
        container.add(txtNom,"sg txt,wrap,w 200px");
        
        container.add(new MyLabel("Prenom"));
        txtPrenom = new MyText("");
        container.add(txtPrenom,"sg txt,wrap,w 200px");
        
        container.add(new MyLabel("Telephone"));
        txtTele = new MyText("");
        container.add(txtTele,"sg txt,wrap");
        
        container.add(new MyLabel("Email"));
        txtMail = new MyText("");
        container.add(txtMail,"sg txt,wrap");
        
        container.add(new TitledSeparator("Information de Securité "),"span,growx");
        
        container.add(new MyLabel("Login"));
        txtLogin = new MyText("");
        container.add(txtLogin,"sg txt,wrap");
        
        container.add(new MyLabel("Password"));
        txtPass = new MyPassText("");
        container.add(txtPass,"sg txt,wrap");
        
        container.add(new MyLabel("Type"));
        comboType = new JComboBox<String>();
        container.add(comboType,"sg txt,wrap");
        panelInfo.add(container,"w 100%");
        
        
        
        
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
