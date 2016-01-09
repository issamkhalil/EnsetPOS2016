/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.entities.CompteUtilisateur;
import com.jidesoft.swing.TitledSeparator;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import com.widgets.MyLabel;
import com.widgets.MyListCompteRenderer;
import com.widgets.MyPassText;
import com.widgets.MyText;
import controlors.ComptesControlor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ComptePanel extends JFXPanel implements MyPanel{
    private MyButton btnSave;
    private MyButton btnDel;
    private MyButton btnNew;
    private JList<CompteUtilisateur> listClients;
    private MyText txtNom;
    private MyText txtTele;
    private MyText txtMail;
    private MyText txtPrenom;
    private MyText txtLogin;
    private MyPassText txtPass;
    private JComboBox comboType;
    private CompteUtilisateur compteSelec=null;

    
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
        JPanel panelContent = new JPanel(new MigLayout("fill","",""));
        this.add(panelContent,"dock center");
        listClients = new JList<CompteUtilisateur>();
        listClients.setCellRenderer(new MyListCompteRenderer());
        JScrollPane clientScr = new JScrollPane(listClients);
        clientScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelContent.add(clientScr,"growy,w 240:240:240");
        // panel des info
        JPanel panelInfo = new JPanel(new MigLayout("center,fill"));
        panelInfo.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
        panelContent.add(panelInfo,"growy,w 100%");
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
        refrechListCompte();
        

        AddUsers((ArrayList<CompteUtilisateur>)ComptesControlor.fetchComptes());
        // initialisation de Compo
        comboType.addItem(Constants.TypeCompte.ADMIN);
        comboType.addItem(Constants.TypeCompte.USER);
        
        btnNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newAction();
            }
        });
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveAction();
            }
        });
        btnDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delAction();
            }
        });
   
    }
    private void delAction(){
        try{
            if(compteSelec!=null){
                ComptesControlor.deleteCompte(compteSelec);
                refrechListCompte();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void saveAction(){
        
        try{
            if(compteSelec==null){
            	try{
                ComptesControlor.saveCompte(txtLogin.getText(),txtPass.getText(),txtNom.getText(),txtPrenom.getText(),txtMail.getText(),txtTele.getText(),comboType.getSelectedItem().toString());
            	}catch(Exception e){
            		System.out.println("une exception : " + e);
            	}
            	}else{
                ComptesControlor.updateCompte(compteSelec,txtLogin.getText(),txtPass.getText(),txtNom.getText(),txtPrenom.getText(),txtMail.getText(),txtTele.getText(),comboType.getSelectedItem().toString());
            }
            refrechListCompte();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void newAction(){
        txtLogin.setText("");
        txtNom.setText("");
        txtMail.setText("");
        txtPass.setText("");
        txtPrenom.setText("");
        txtTele.setText("");
        comboType.setSelectedItem("");
        compteSelec = null;
    }
    public void AddUsers(ArrayList<CompteUtilisateur> list){
        listClients.setModel(new MyModel(list));
        listClients.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JList<CompteUtilisateur> wid = (JList<CompteUtilisateur>) e.getSource();
                MyModel model = (MyModel) wid.getModel();
                userClicked(model.getElementAt(wid.getSelectedIndex()));
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
    public void userClicked(CompteUtilisateur c){
        txtLogin.setText(c.getLogin());
        txtNom.setText(c.getNom());
        txtMail.setText(c.getEmail());
        txtPass.setText(c.getPassword());
        txtPrenom.setText(c.getPrenom());
        txtTele.setText(c.getTelephone());
        comboType.setSelectedItem(c.getType());
        compteSelec = c;
    }
    public void refrechListCompte(){
        try{
        AddUsers((ArrayList<CompteUtilisateur>)ComptesControlor.fetchComptes());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class MyModel implements ListModel<CompteUtilisateur>{
        ArrayList<CompteUtilisateur> list;

        private MyModel(ArrayList<CompteUtilisateur> list) {
            this.list= list;
        }


        @Override
        public int getSize() {
            return list.size();
        }

        @Override
        public CompteUtilisateur getElementAt(int index) {
            return list.get(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {
            
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
        }
        
    }
    

    
}
