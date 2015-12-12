/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.jidesoft.swing.JideSplitPane;
import com.jidesoft.swing.JideTitledBorder;
import com.jidesoft.swing.PartialEtchedBorder;
import com.jidesoft.swing.PartialSide;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.MyButton;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class TraitePanel  extends JFXPanel implements MyPanel{
    JButton btnSearch;
    JList<String> listClient,listVente;
    public TraitePanel(){
        init();
    }
    
   public void init(){
       this.setLayout(new MigLayout("rtl"));
       JPanel btnPanel = new JPanel(new MigLayout());
       LangueModel lm = new LangueModel();
       btnSearch = new MyButton("Chercher Client",new AwsomeIcon(AwsomeIconConst.SEARCH_ICON, 20));
       btnPanel.add(btnSearch);
       this.add(btnPanel,"dock north");
       // client panel
       JPanel clientPanel = new JPanel(new MigLayout());
       clientPanel.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Les Clients"));
       listClient = new JList();
       JScrollPane clientScr = new JScrollPane(listClient);
       clientScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
       clientPanel.add(clientScr,"dock center");
       // vente panel
       JPanel ventePanel = new JPanel(new MigLayout());
       ventePanel.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Les Ventes"));
       listVente = new JList<String>();
       JScrollPane venteScr = new JScrollPane(listClient);
       venteScr.setBorder(BorderFactory.createLineBorder(Constants.TEXT_COLOR));
       ventePanel.add(venteScr,"dock center");
       
       // traites panel
       JPanel traitePanel =new JPanel(new MigLayout());
       traitePanel.setBorder(new JideTitledBorder(new PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH), "Les Traites"));
       // centainer
       
       JPanel container = new JPanel(new MigLayout());
       container.add(clientPanel,"w 30%,h 100%");
       container.add(ventePanel,"w 30%,h 100%");
       container.add(traitePanel,"w 40%,h 100%");
       this.add(container,"dock center");
       
       
       
       
   }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
