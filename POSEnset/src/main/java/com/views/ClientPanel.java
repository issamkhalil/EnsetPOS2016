/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.jidesoft.swing.JideTitledBorder;
import com.jidesoft.swing.PartialEtchedBorder;
import com.jidesoft.swing.PartialSide;
import com.jidesoft.swing.TitledSeparator;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.models.OctiCon;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.widgets.LikeWidget;
import com.widgets.MyButton;
import com.widgets.MyCheckBox;
import com.widgets.MyLabel;
import com.widgets.MyText;
import com.widgets.MyTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ClientPanel extends JPanel implements MyPanel{
    private JButton btnNew,btnDel,btnSave;
    private JList<String> listClients;
    private JTextField txtNom,txtPrenom,txtTele,txtFaxe,txtReg,email,txtCompteFaceBook,txtJameFaceBook,txtMail,txtCredit;
    private JTextArea txtNote;
    private JLabel lblTypeClient;
    private JPanel panelClientPart;
    private JCheckBox faceCheck;
    private JPanel panelClientEnt;
    private JPanel contenair;
    private MyCheckBox clientCheck;
    public ClientPanel(){
        this.setLayout(new MigLayout("fill,insets 0 0 20 0"));
        init();
    }
    public void init(){
        // panel des buttons
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
        panelContent.add(new JScrollPane(listClients),"growy,w 25%");
        // panel des info
        JPanel panelInfo = new JPanel(new MigLayout());
        panelInfo.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelContent.add(panelInfo,"growy,w 75%");
        // les info 
        panelInfo.add(new MyLabel("Nom"));
        txtNom = new MyText("");
        panelInfo.add(txtNom,"sg txt,wrap,w 200px");
        
        panelInfo.add(new MyLabel("Telephone"));
        txtTele = new MyText("");
        panelInfo.add(txtTele,"sg txt,wrap");
        
        panelInfo.add(new MyLabel("Email"));
        txtMail = new MyText("");
        panelInfo.add(txtMail,"sg txt,wrap");
        
        panelInfo.add(new MyLabel("Max. Credit"));
        txtCredit = new MyText("");
        panelInfo.add(txtCredit,"sg txt,wrap");
        
        panelInfo.add(new TitledSeparator("Information Supplimentaire "),"span,growx");
        panelInfo.add(new MyLabel("Client Entreprise"),"span,split 3");
        clientCheck = new MyCheckBox(true);
        panelInfo.add(clientCheck);
        lblTypeClient = new MyLabel("Client Particulie");
        panelInfo.add(lblTypeClient);
        // insetion de panel qui va contenir les info sup
        contenair = new JPanel(new MigLayout());
        //contenair.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Info Sup"));
        panelInfo.add(contenair,"span,wrap,growx");
        // panel de client particulier
        panelClientPart = new JPanel(new MigLayout());
        panelClientPart.add(new MyLabel("Prénom"));
        txtPrenom = new MyText("");
        panelClientPart.add(txtPrenom,"sg txt");
        
        panelClientPart.add(new MyLabel("Compte FaceBook"));
        txtCompteFaceBook = new MyText("");
        panelClientPart.add(txtCompteFaceBook,"sg txt,wrap,w 200px");
        
        panelClientPart.add(new MyLabel("FaceBook J'aime :"));
        faceCheck = new LikeWidget(true);
        panelClientPart.add(faceCheck,"wrap");
        contenair.add(panelClientPart,"span,wrap");
        // panel de client entreprise
        panelClientEnt = new JPanel(new MigLayout());
        panelClientEnt.add(new MyLabel("Registre de Commerce"));
        txtReg = new MyText("");
        panelClientEnt.add(txtReg,"sg txt,wrap,w 200px");
        
        panelClientEnt.add(new MyLabel("Fax"));
        txtFaxe = new MyText("");
        panelClientEnt.add(txtFaxe,"sg txt,wrap,w 200px");
        panelInfo.add(new TitledSeparator("Notes Sur le Client  "),"span,growx");
        panelInfo.add(new MyLabel("Note "));
        txtNote = new MyTextArea("");
        panelInfo.add(txtNote,"sg txtarea,wrap,growx");
        txtNote.setLineWrap(true);
        txtNote.setRows(6);
        clientCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientCheck.isSelected()){
                    contenair.remove(panelClientEnt);
                    contenair.add(panelClientPart);
                    contenair.revalidate();
                }else{
                    contenair.remove(panelClientPart);
                    contenair.add(panelClientEnt);
                    contenair.revalidate();
                }
            }
        });
        
        
        
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
