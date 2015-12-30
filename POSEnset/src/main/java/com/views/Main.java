/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.widgets.TabCompoSouth;
import com.models.AwsomeIcon;
import com.models.GRessource;
import com.models.LangueModel;
import com.models.OctiCon;

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
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.jgroups.tests.perf.UPerf.Config;

/**
 *
 * @author EL MOTTAKI
 */
public class Main extends javax.swing.JFrame {

	private JTabbedPane jtp;
	private Map<String, MyPanel> listPanel = new HashMap<String, MyPanel>();

	/*
	 * private SalesControlor salesControlor; private ClientsControlor
	 * clientsControlor; private FaceBookControlor faceBookControlor; private
	 * traitesControlor traitesControlor; private ComptesControlor
	 * comptesControlor; private ConfigControlor configControlor;
	 */

	public Main() {
		initComponents();
	}

	private void initComponents() {
		GRessource gr = new GRessource();
		LangueModel lm = new LangueModel();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(900, 600));
		// setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
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
		StockControlor.indexAction(sp);
		
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

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
				SuperControlor.setMainForm(new Main());
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
