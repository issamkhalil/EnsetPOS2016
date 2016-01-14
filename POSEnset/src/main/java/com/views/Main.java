/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.Constants;
import com.entities.CompteUtilisateur;
import com.widgets.TabCompoSouth;
import com.models.AwsomeIcon;
import com.models.GRessource;
import com.models.LangueModel;
import com.models.OctiCon;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

import com.widgets.MyLabel;

import controlors.ClientsControlor;
import controlors.ComptesControlor;
import controlors.ConfigControlor;
import controlors.FaceBookControlor;
import controlors.SalesControlor;
import controlors.StockControlor;
import controlors.SuperControlor;
import controlors.traitesControlor;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.jgroups.tests.perf.UPerf.Config;

/**
 *
 * @author EL MOTTAKI
 */
public class Main extends javax.swing.JFrame {

    private JTabbedPane jtp;
    public static CompteUtilisateur compte;
    private Map<String, MyPanel> listPanel = new HashMap<String, MyPanel>();
    private JToolBar tbar;
    private JButton btnDec;
    private JMenuBar menu;

    /*
     * private SalesControlor salesControlor; private ClientsControlor
     * clientsControlor; private FaceBookControlor faceBookControlor; private
     * traitesControlor traitesControlor; private ComptesControlor
     * comptesControlor; private ConfigControlor configControlor;
     */
    public Main(CompteUtilisateur compte) {
        this.compte = compte;
        initComponents();
    }

    private void initComponents() {
        GRessource gr = new GRessource();
        LangueModel lm = new LangueModel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 600));
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        MigLayout fLayout = new MigLayout("fill");
        setLayout(fLayout);
        pack();
        setTitle(lm.getString("appname"));
		// setIconImage(GRessource.getIcon("logo.png").getImage());
		/*
         * // construction de graphique
         */

        // tabbed bar
        jtp = new JTabbedPane(SwingConstants.LEFT);

        VentePanel vp = new VentePanel();
        vp.setBackground(Color.red);

        jtp.addTab(null, vp);
        jtp.setTabComponentAt(0, new TabCompoSouth(lm.getString("sales"),
                GRessource.getIcon("sale.png", 40)));
        listPanel.put("vente", vp);
        try {
            SalesControlor.indexAction(vp);
            StockPanel sp = new StockPanel();
            jtp.addTab(null, sp);

            jtp.setTabComponentAt(1, new TabCompoSouth(lm.getString("stock"),
                    GRessource.getIcon("stock.png", 40)));
            listPanel.put("stock", sp);
            ClientPanel cp = new ClientPanel();

            jtp.addTab(null, cp);
            jtp.setTabComponentAt(2, new TabCompoSouth(lm.getString("clients"),
                    GRessource.getIcon("client.png", 40)));
            ClientsControlor.indexAction(cp);

            listPanel.put("clients", cp);
            TraitePanel tp = new TraitePanel();
            jtp.addTab(null, tp);
            jtp.setTabComponentAt(3, new TabCompoSouth(lm.getString("traites"),
                    GRessource.getIcon("tranche.png", 40)));
            listPanel.put("traites", tp);
            ComptePanel comp = new ComptePanel();
            jtp.addTab(null, GRessource.getIcon("users.png"), comp);
            jtp.setTabComponentAt(4, new TabCompoSouth(lm.getString("comptes"),
                    GRessource.getIcon("users.png", 40)));
            listPanel.put("comptes", comp);
            if (compte.getType().equals(Constants.TypeCompte.ADMIN)) {
                FacebookPanel fp = new FacebookPanel();
                jtp.addTab(null, fp);
                jtp.setTabComponentAt(5, new TabCompoSouth(lm.getString("facebook"),
                        GRessource.getIcon("Facebook.png", 40)));
                listPanel.put("facebook", fp);

                ParamPanel pp = new ParamPanel();
                jtp.addTab(null, pp);
                jtp.setTabComponentAt(
                        6,
                        new TabCompoSouth(lm.getString("configuration"), GRessource
                                .getIcon("conf.png", 40)));
                listPanel.put("config", pp);
            }
            JPanel cptPanel = new JPanel(new MigLayout("rtl"));
            cptPanel.add(new MyLabel(GRessource.getIcon("133.png", 30)), "wrap,al center");
            cptPanel.add(new MyLabel("Login : " + compte.getLogin(), 14, 0), "");
            //cptPanel.setBackground(new Color(204,255,255));
            cptPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//            tbar = new JToolBar();
//            tbar.setAlignmentX(JToolBar.RIGHT_ALIGNMENT);
//            tbar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//            tbar.setFloatable(false);
//            btnDec = new JButton(GRessource.getIcon("133.png", 50));
//            tbar.add(btnDec);
//            cptPanel.add(tbar,"w 90%");
            this.add(cptPanel, "dock north");
            this.add(jtp, "dock center");
            jtp.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    if (jtp.getSelectedIndex() != 0 && jtp.getSelectedIndex() != 1) {
                        refAction();
                    }
                }
            });
           
            JPanel southPanel = new SouthPanel();
            southPanel.add(new JButton("click here"));
            // this.add(southPanel,"dock north,h 400px");
            menu = new JMenuBar();
        JMenu aide = new JMenu("Aide");
        JMenuItem propos = new JMenuItem("A propos");
        propos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                proposAction();
            }
        });
        aide.add(propos);
        JMenu option = new JMenu("Option");
        JMenuItem deconnexion = new JMenuItem("Deconnexion");
        deconnexion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                decAction();
            }
        });
        option.add(deconnexion);
        menu.add(option);
        menu.add(aide);
        this.setJMenuBar(menu);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
    public void proposAction(){
        new ProposFrame(this, true).setVisible(true);
    }
    public void decAction(){
        this.dispose();
        new LoginFrame().setVisible(true);
    }
    public static void main(String args[]) {
        // look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SuperControlor.setMainForm(new Main(null));
                SuperControlor.getMainForm().setVisible(true);
            }
        });
    }

    public Map<String, MyPanel> getListPanel() {
        return listPanel;
    }

    public void refAction() {

		// MyPanel panel = (MyPanel) jtp.getSelectedComponent();
        // panel.refresh();
    }

    public void refreshAll() {
        for (int i = 0; i < jtp.getTabCount(); i++) {
			// MyPanel panel = (MyPanel) jtp.getComponentAt(i);
            // panel.refresh();
        }
    }

}
