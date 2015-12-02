
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;



import com.models.FlatIcon;
import com.models.GRessource;
import com.models.Genericon;
import com.models.LangueModel;
import com.models.OctiCon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.miginfocom.swing.MigLayout;
import com.widgets.MyLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author EL MOTTAKI
 */
public class Main extends javax.swing.JFrame {

    private JTabbedPane jtp;
    private ArrayList<MyPanel> listPanel = new ArrayList<MyPanel>();

    public Main() {
        initComponents();
    }

    private void initComponents() {
        GRessource gr = new GRessource();
        LangueModel lm = new LangueModel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 600));
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        MigLayout fLayout = new MigLayout();
        setLayout(fLayout);
        pack();
        
        setTitle(lm.getString("appname"));
        //setIconImage(GRessource.getIcon("logo.png").getImage());
        /*
         // construction de graphique
         */
      
        // tabbed bar 
        jtp = new JTabbedPane(SwingConstants.LEFT);
       
        VentePanel vp =new VentePanel();
        vp.setBackground(Color.red);
        jtp.addTab(lm.getStringWithSpace("sales"),new FlatIcon('\uf0f9', 40),vp);
        listPanel.add(vp);
        StockPanel sp = new StockPanel();
        jtp.addTab(lm.getStringWithSpace("stock"),new FlatIcon('\uf0c0', 40), sp);
        listPanel.add(sp);
        ClientPanel cp = new ClientPanel();
        
        jtp.addTab(lm.getStringWithSpace("clients"),new Genericon('\uf104', 40),cp);
        listPanel.add(cp);
        TraitePanel tp = new TraitePanel();
        jtp.addTab(lm.getStringWithSpace("traites"),new Genericon('\uf104', 40),tp);
        listPanel.add(tp);
        ComptePanel comp = new ComptePanel();
        jtp.addTab(lm.getStringWithSpace("comptes"),new Genericon('\uf104', 40),comp);
        listPanel.add(comp);
        ParamPanel pp = new ParamPanel();
        jtp.addTab(lm.getStringWithSpace("configuration"),new Genericon('\uf104', 40),pp);
        listPanel.add(pp);
        this.add(jtp, "w 100%,h 100%");
        jtp.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (jtp.getSelectedIndex() != 0 && jtp.getSelectedIndex() != 1) {
                    refAction();
                }
            }
        });
        this.add(new SouthPanel(),"dock south,h 60px");


    }

    public static void main(String args[]) {
        // look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }



    public void refAction() {

//        MyPanel panel = (MyPanel) jtp.getSelectedComponent();
//        panel.refresh();
    }

    public void refreshAll() {
        for (int i = 0; i < jtp.getTabCount(); i++) {
       //     MyPanel panel = (MyPanel) jtp.getComponentAt(i);
        //    panel.refresh();
        }
    }
    

}
