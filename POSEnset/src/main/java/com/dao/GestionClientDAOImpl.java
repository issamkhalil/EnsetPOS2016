package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.Produit;

public class GestionClientDAOImpl extends GenericDAOImpl implements IGestionClientDAO {

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
		Query req=em.createQuery("select c from Client c"); 
		return req.getResultList();
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
	public Adresse AddAdresse(Adresse a) {
		em.persist(a);
		return a;

	}

	@Override
	public void deleteAdresse(long id) {
		Adresse a = em.find(Adresse.class, id);
		em.remove(a);
	}

	@Override
	public Adresse modifierAdresse(Adresse a) {
		em.merge(a);
		return a;
}

	@Override
	public Adresse getAdressebyId(long id) {
		return em.find(Adresse.class, id);
	}

}
