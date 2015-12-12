/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.models.AwsomeIcon;
import com.models.ConfigModel;
import com.models.LangueModel;
import com.widgets.TabCompoLeft;
import javafx.embed.swing.JFXPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
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
        jtp.addTab(null, new ProduitPanel());
        jtp.setTabComponentAt(0, new TabCompoLeft(lm.getString("products"), new AwsomeIcon(AwsomeIconConst.PRODUCT_ICON, 20)));
        jtp.addTab(null, new CatPanel());
        jtp.setTabComponentAt(1, new TabCompoLeft(lm.getString("categories"), new AwsomeIcon(AwsomeIconConst.FOLDERF_ICON, 20)));
     
        this.add(jtp,"dock center");
        
        
    }
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
