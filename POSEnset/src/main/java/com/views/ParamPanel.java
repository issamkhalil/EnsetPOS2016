/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.jidesoft.swing.TitledSeparator;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyPassText;
import com.widgets.MyText;
import java.awt.Color;
import javafx.embed.swing.JFXPanel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ParamPanel  extends JFXPanel implements MyPanel{
    private MyText txtURL;
    private MyText txtLogin;
    private MyPassText txtPass;
    private MyText txtPay;
    private MyText txtLan;
    private JComboBox<String> comboPay;
    private JComboBox<String> comboLan;
    private MyButton btnSave;
    private MyButton btnAnn;

    public ParamPanel(){
        init();
    }
    public void init(){
        this.setLayout(new MigLayout("center,fill"));
        LangueModel lm = new LangueModel();
        JPanel contenair = new JPanel(new MigLayout("center"));
        contenair.add(new TitledSeparator("Comfiguration de Base de données"),"span,growx");
        
        contenair.add(new MyLabel("URL vers la base de données"));
        txtURL = new MyText("");
        contenair.add(txtURL,"sg txt,wrap,w 200px");
        
        contenair.add(new MyLabel("Login"));
        txtLogin = new MyText("");
        contenair.add(txtLogin,"sg txt,wrap,w 200px");
        
        contenair.add(new MyLabel("Mot de Passe"));
        txtPass = new MyPassText("");
        contenair.add(txtPass,"sg txt,wrap,w 200px");
        
        contenair.add(new TitledSeparator("Comfiguration de Locale"),"span,growx");
        contenair.add(new MyLabel("Pay"));
        comboPay = new JComboBox<String>();
        contenair.add(comboPay,"sg txt,wrap,w 200px");
        
        contenair.add(new MyLabel("Langue"));
        comboLan = new JComboBox<String>();
        contenair.add(comboLan,"sg txt,wrap,w 200px");
        this.add(contenair,"gaptop 40px,w 100%");
        
        // les bouttons
        JPanel btnPanel = new JPanel(new MigLayout("rtl"));
        btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(AwsomeIconConst.SAVE_ICON, 20));
        btnAnn = new MyButton(lm.getString("annuler"), new AwsomeIcon(AwsomeIconConst.DEL_ICON, 20));
        btnPanel.add(btnSave);
        btnPanel.add(btnAnn);
        contenair.add(btnPanel,"dock south");
        
       
        
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
