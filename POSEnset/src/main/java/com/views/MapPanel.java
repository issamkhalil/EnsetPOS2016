/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.views;
import com.models.LangueModel;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class MapPanel extends JPanel implements MyPanel{

public MapPanel(){
    init();

}
public void init(){
    LangueModel lm = new LangueModel();
    setLayout(new MigLayout());

}

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
