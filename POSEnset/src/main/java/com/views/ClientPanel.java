/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.views;

import com.beans.AwsomeIconConst;
import com.beans.Constants;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.jidesoft.swing.TitledSeparator;
import com.models.AwsomeIcon;
import com.models.LangueModel;
import com.widgets.LikeWidget;
import com.widgets.MyButton;
import com.widgets.MyCheckBox;
import com.widgets.MyLabel;
import com.widgets.MyListClientRenderer;
import com.widgets.MyText;
import com.widgets.MyTextArea;

import controlors.ClientsControlor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.List;

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
import javax.swing.event.ListDataListener;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class ClientPanel extends JPanel implements MyPanel {

	private JButton btnNew, btnDel, btnSave;
	private JList<Client> listClients;
	private JTextField txtNom, txtPrenom, txtTele, txtFaxe, txtReg, email,
			txtCompteFaceBook, txtJameFaceBook, txtMail, txtCredit;
	private JTextArea txtNote;
	private JLabel lblTypeClient;
	private JPanel panelClientPart;
	private JCheckBox faceCheck;
	private JPanel panelClientEnt;
	private JPanel contenair;
	private MyCheckBox clientCheck;
	private long clientID;
	private MyText txtAdd;

	public ClientPanel() {
		this.setLayout(new MigLayout("fill,insets 0 0 20 0"));
		init();

		listClients.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setModifClient(listClients.getSelectedValue());
			}
		});
	}

	public void init() {
		// panel des buttons
		LangueModel lm = new LangueModel(
				com.models.ConfigModel.getProprety("langue"));
		JPanel btnPanel = new JPanel(new MigLayout("rtl"));
		btnSave = new MyButton(lm.getString("ENREGISTRER"), new AwsomeIcon(
				AwsomeIconConst.SAVE_ICON, 20));
		btnSave.setName("new");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSaveClicked();
			}

		});
		btnDel = new MyButton(lm.getString("SUPPRIMER"), new AwsomeIcon(
				AwsomeIconConst.DEL_ICON, 20));
		btnNew = new MyButton(lm.getString("NOUVEAU"), new AwsomeIcon(
				AwsomeIconConst.NEW_ICON, 20));
		btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reInitTfs();
			}
		});
		
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					supprimerClient();
			}
		});
		
		

		btnPanel.add(btnSave);
		btnPanel.add(btnDel);
		btnPanel.add(btnNew);
		this.add(btnPanel, "dock north");
		// panel des list
		JPanel panelContent = new JPanel(new MigLayout("fill"));

		this.add(panelContent, "dock center");
		listClients = new JList<Client>();
		listClients.setCellRenderer(new MyListClientRenderer());
		JScrollPane clientScr = new JScrollPane(listClients);

		clientScr.setBorder(BorderFactory
				.createLineBorder(Constants.TEXT_COLOR));
		panelContent.add(clientScr, "growy,w 250:250:250");
		// panel des info
		JPanel panelInfo = new JPanel(new MigLayout());
		panelInfo.setBorder(BorderFactory
				.createLineBorder(Constants.TEXT_COLOR));
		panelContent.add(panelInfo, "growy,w 90%");
		// les info
		panelInfo.add(new MyLabel("Nom"));
		txtNom = new MyText("");
		panelInfo.add(txtNom, "sg txt,wrap,w 200px");

		panelInfo.add(new MyLabel("Telephone"));
		txtTele = new MyText("");
		panelInfo.add(txtTele, "sg txt,wrap");

		panelInfo.add(new MyLabel("Email"));
		txtMail = new MyText("");
		panelInfo.add(txtMail, "sg txt,wrap");

		panelInfo.add(new MyLabel("Adresse"));
		txtAdd = new MyText("");
		panelInfo.add(txtAdd, "sg txt,wrap");

		panelInfo.add(new MyLabel("Max. Credit"));
		txtCredit = new MyText("");
		panelInfo.add(txtCredit, "sg txt,wrap");

		panelInfo.add(new TitledSeparator("Information Supplimentaire "),
				"span,growx");
		panelInfo.add(new MyLabel("Client Entreprise"), "span,split 3");
		clientCheck = new MyCheckBox(true);
		panelInfo.add(clientCheck);
		lblTypeClient = new MyLabel("Client Particulie");
		panelInfo.add(lblTypeClient);
		// insetion de panel qui va contenir les info sup
		contenair = new JPanel(new MigLayout());
		// contenair.setBorder(new JideTitledBorder(new
		// PartialEtchedBorder(PartialEtchedBorder.LOWERED, PartialSide.NORTH),
		// "Info Sup"));
		panelInfo.add(contenair, "span,wrap,growx");
		// panel de client particulier
		panelClientPart = new JPanel(new MigLayout());
		panelClientPart.add(new MyLabel("Prénom"));
		txtPrenom = new MyText("");
		panelClientPart.add(txtPrenom, "sg txt");

		panelClientPart.add(new MyLabel("Compte FaceBook"));
		txtCompteFaceBook = new MyText("");
		panelClientPart.add(txtCompteFaceBook, "sg txt,wrap,w 200px");

		panelClientPart.add(new MyLabel("FaceBook J'aime :"));
		faceCheck = new LikeWidget(true);
		panelClientPart.add(faceCheck, "wrap");
		contenair.add(panelClientPart, "span,wrap");
		// panel de client entreprise
		panelClientEnt = new JPanel(new MigLayout());
		panelClientEnt.add(new MyLabel("Registre de Commerce"));
		txtReg = new MyText("");
		panelClientEnt.add(txtReg, "sg txt,wrap,w 200px");

		panelClientEnt.add(new MyLabel("Fax"));
		txtFaxe = new MyText("");
		panelClientEnt.add(txtFaxe, "sg txt,wrap,w 200px");
		panelInfo.add(new TitledSeparator("Notes Sur le Client  "),
				"span,growx");
		panelInfo.add(new MyLabel("Note "));
		txtNote = new MyTextArea("");
		panelInfo.add(txtNote, "sg txtarea,wrap,growx");
		txtNote.setLineWrap(true);
		txtNote.setRows(6);

		clientCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (clientCheck.isSelected()) {
					contenair.remove(panelClientEnt);
					contenair.add(panelClientPart);
					contenair.revalidate();
				} else {
					contenair.remove(panelClientPart);
					contenair.add(panelClientEnt);
					contenair.revalidate();
				}
			}
		});

	}
	
	private void supprimerClient(){
		Client  client=listClients.getSelectedValue();
		try {
			ClientsControlor.deleteClient(client.getId());
			ClientsControlor.indexAction(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addClients(List<Client> clients) {
		listClients.setModel(new MyModel(clients));
	}

	// private void ClinetDBClicked(long idClient) {
	// ClientsControlor.choixClinetAction(this, idClient);
	// System.out.println("Iciiiii");
	// }

	public JButton getBtnSave() {
		return btnSave;
	}

	public void reInitTfs(){
		btnSave.setName("new");
		txtNom.setText("");
		txtFaxe.setText("");
		txtMail.setText("");
		txtNote.setText("");
		txtReg.setText("");
		txtTele.setText("");
		txtCredit.setText("");
		faceCheck.setSelected(false);
		txtCompteFaceBook.setText("");
		txtPrenom.setText("");
	}
	
	private void btnSaveClicked() {
		// TODO Auto-generated method stub

		String nom = txtNom.getText();
		String prenom = txtPrenom.getText();
		String faxe = txtFaxe.getText();
		String cptfb = txtCompteFaceBook.getText();
		String mail = txtMail.getText();
		String credit = txtCredit.getText();
		String note = txtNote.getText();
		String reg = txtReg.getText();
		String tele = txtTele.getText();
		boolean faceBookJaime = faceCheck.isSelected();
		boolean clientPar = clientCheck.isSelected();
		String vile = "mohamedia";
		String region = "riad salam";
		String cp = "25660";

		if (btnSave.getName().equals("new")) {

			try {
				ClientsControlor.addClinetAction(nom, prenom, faxe, cptfb, mail,
						credit, note, reg, tele, faceBookJaime, clientPar, vile,
						region, cp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			long clientID = Long.parseLong(btnSave.getName());

			try {
				long adId = listClients.getSelectedValue().getAdresse().getId();
				ClientsControlor.modifClinetAction(clientID, nom, prenom, faxe,
						cptfb, mail, credit, note, reg, tele, faceBookJaime,
						clientPar, adId,vile, region, cp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 try {
			ClientsControlor.indexAction(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setModifClient(Client client) {
		this.btnSave.setName("" + client.getId());
		if (client instanceof ClientEntreprise) {
			this.setModifClient((ClientEntreprise) client);
		} else {
			this.setModifClient((ClientParticulier) client);
		}
	}

	public void setModifClient(ClientEntreprise client) {
		txtNom.setText(client.getNom());
		txtFaxe.setText(client.getFax());
		txtMail.setText(client.getEmail());
		txtNote.setText(client.getNote());
		txtReg.setText(client.getRegistreCommerce());
		txtTele.setText(client.getTelephone());
		txtCredit.setText(client.getMaxCredit() + "");
		clientCheck.setSelected(false);
	}

	public void setModifClient(ClientParticulier client) {
		txtNom.setText(client.getNom());
		txtCompteFaceBook.setText(client.getCompteFaceBook());
		txtMail.setText(client.getEmail());
		txtNote.setText(client.getNote());
		txtPrenom.setText(client.getPrenom());
		txtTele.setText(client.getTelephone());
		txtCredit.setText(client.getMaxCredit() + "");
		clientCheck.setSelected(true);
		faceCheck.setSelected(client.isJameFaceBook());
	}

	@Override
	public void refresh() {
		throw new UnsupportedOperationException("Not supported yet.");
		// To
		// change
		// body
		// of
		// generated
		// methods,
		// choose
		// Tools
		// |
		// Templates.
	}

	private class MyModel implements ListModel<Client> {

		List<Client> list;

		private MyModel(List<Client> list) {
			this.list = list;
		}

		@Override
		public int getSize() {
			return list.size();
		}

		@Override
		public Client getElementAt(int index) {
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
