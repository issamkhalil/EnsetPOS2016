package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.Produit;

public class ClientDAOImpl extends GenericDAO implements IClientDAO {
	@Override
	public Client AddClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public void removeClient(long id) {
		Client c = em.find(Client.class, id);
		em.remove(c);
	}

	@Override
	public Client modifierClient(Client c) {
		return em.merge(c);
}

	@Override
	public List<Client> listerClientsAll() {
		try{
		Query req=em.createQuery("select c from Client c"); 
		return req.getResultList();
		}catch(Exception e){
			
			return null;
		}
		}

	@Override
	public List<Client> chercheClientsparNom(String nomMotif) {
		Query req=em.createQuery("select c from Client c where c.nom like"
				+":x or c.nom like:x");
				req.setParameter("x", "%"+nomMotif+"%");
				return req.getResultList();
	}

	@Override
	public Client chercheClientparID(long id) {
		return em.find(Client.class, id);
	}

	@Override
	public List<Client> chercheClientsPNomRCMotif(String pNomRCMotif) {
		Query req=em.createQuery("select c from Client c where c.RegistreCommerce like"
				+":x or c.prenom like:x");
				req.setParameter("x", "%"+pNomRCMotif+"%");
				req.setParameter("x", "%"+pNomRCMotif+"%");
				return req.getResultList();
	}

	
}
