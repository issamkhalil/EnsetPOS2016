/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.models.ConfigModel;
import com.models.LangueModel;
import javafx.embed.swing.JFXPanel;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class StockPanel  extends JFXPanel implements MyPanel{
    private JTabbedPane jtp;
    
    public StockPanel(){
        this.setLayout(new MigLayout());
        init();
    }
    public void init(){
        LangueModel lm = new LangueModel(ConfigModel.getProprety("langue"));
        jtp = new JTabbedPane();
        jtp.addTab(lm.getString("products"), new ProduitPanel());
        jtp.addTab(lm.getString("categories"), new CatPanel());
        this.add(jtp,"dock center");
        
        
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
