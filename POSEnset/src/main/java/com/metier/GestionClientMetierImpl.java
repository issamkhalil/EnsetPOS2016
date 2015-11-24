package com.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IAdresseDAO;
import com.dao.IClientDAO;
import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.Produit;

@Transactional
public class GestionClientMetierImpl implements IGestionClientMetier {

	private IClientDAO clientDAO;
	private IAdresseDAO adresseDAO;
	

	public void setAdresseDAO(IAdresseDAO adresseDAO) {
		this.adresseDAO = adresseDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public void AddClientParticulier(ClientParticulier c) {
		clientDAO.AddClient(c);
	}

	@Override
	public void AddClientEntreprise(ClientEntreprise c) {
		clientDAO.AddClient(c);
	}

	@Override
	public void removeClient(long id) {
		clientDAO.removeClient(id);
	}

	public void modifierClientEntreprise(long id, ClientEntreprise c) throws Exception {
		ClientEntreprise client = (ClientEntreprise) clientDAO.chercheClientparID(id);
		client.setAdresse(c.getAdresse());
		client.setFax(c.getFax());
		client.setEmail(c.getEmail());
		client.setMaxCredit(c.getMaxCredit());
		client.setNom(c.getNom());
		client.setNote(c.getNote());
		client.setRegistreCommerce(c.getRegistreCommerce());
		client.setTelephone(c.getTelephone());
		client.setVentes(c.getVentes());
		clientDAO.modifierClient(client);
	}

	public void modifierClientParticulier(long id, ClientParticulier c) throws Exception{
		ClientParticulier client = (ClientParticulier) clientDAO.chercheClientparID(id);
		client.setAdresse(c.getAdresse());
		client.setCompteFaceBook(c.getCompteFaceBook());
		client.setEmail(c.getEmail());
		client.setMaxCredit(c.getMaxCredit());
		client.setNom(c.getNom());
		client.setNote(c.getNote());
		client.setPrenom(c.getPrenom());
		client.setTelephone(c.getTelephone());
		client.setVentes(c.getVentes());
		clientDAO.modifierClient(client);
	}

	@Override
	public void modifierClient(long id, Client c) throws Exception{
		if (c.getClass().toString().indexOf("ClientParticulier") > 0) {
			modifierClientParticulier(id, (ClientParticulier) c);
		} else if (c.getClass().toString().indexOf("ClientEntreprise") > 0) {
			modifierClientEntreprise(id, (ClientEntreprise) c);
		}
	}

	@Override
	public List<Client> listerClientsAll() {
		return clientDAO.listerClientsAll();
	}

	@Override
	public List<Client> chercheClientsparNom(String nomMotif) {
			
		return chercheClientsparNom(nomMotif);
	}

	@Override
	public Client chercheClientparID(long id) {
		return clientDAO.chercheClientparID(id);
	}

	@Override
	public void AddAdresse(Adresse a) {
			adresseDAO.AddAdresse(a);
	}

	@Override
	public void deleteAdresse(long id) {
			adresseDAO.deleteAdresse(id);
	}

	@Override
	public void modifierAdresse(long id, Adresse a) {
			Adresse adresse = adresseDAO.getAdressebyId(id);
			adresse.setClients(a.getClients());
			adresse.setCodePostale(a.getCodePostale());
			adresse.setRegion(a.getRegion());
			adresse.setVille(a.getRegion());
			adresseDAO.modifierAdresse(adresse);
	}

	@Override
	public Adresse getAdressebyId(long id) {
		return adresseDAO.getAdressebyId(id);
	}

}
