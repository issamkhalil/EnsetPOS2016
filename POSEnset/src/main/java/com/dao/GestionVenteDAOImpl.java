package com.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Adresse;
import com.entities.Client;
import com.entities.LigneVente;
import com.entities.Tranche;
import com.entities.Vente;

public class GestionVenteDAOImpl extends GenericDAOImpl implements IGestionVenteDAO {

	@Override
	public void AddVente(Vente v) {
		em.persist(v);
	}

	@Override
	public void deleteVente(long id) {
		Vente v = em.find(Vente.class, id);
		em.remove(v);
	}

	@Override
	public void modifierVente(Vente v) {
		em.merge(v);
	}

	@Override
	public List<Vente> listerVentes() {
		Query q = em.createQuery("select v from Vente v");
		return q.getResultList();
	}

	@Override
	public Vente getVentebyId(long id) {
		return em.find(Vente.class, id);
	}

	@Override
	public List<Vente> getVenteEntre2date(Date dateDeb, Date dateFin) {
		Query q = em.createQuery("select v from Vente v where v.date between :x and :y");
		q.setParameter("x", dateDeb);
		q.setParameter("y", dateFin);
		return q.getResultList();
	}

	@Override
	public List<Vente> getVenteparClientID(long clientId) {
		Query q = em.createQuery("select v from Vente v where v.client = :x");
		Client c = em.find(Client.class, clientId);
		q.setParameter("x", c);
		return q.getResultList();
	}

	@Override
	public List<Vente> getVenteparTotale(double totale) {
		Query q = em.createQuery("select v from Vente v where v.totale = :x");
		q.setParameter("x", totale);
		return q.getResultList();
	}

	@Override
	public void AddLigneVente(LigneVente lv) {
		em.persist(lv);
	}

	@Override
	public void modifierLigneVente(LigneVente lv) {
		em.merge(lv);
	}

	@Override
	public LigneVente getLigneVenteByID(long id) {
		return em.find(LigneVente.class, id);
	}

	@Override
	public Tranche AddTranche(Tranche t) {
		em.persist(t);
		return t;
	}

	@Override
	public void deleteTranche(long id) {
		Tranche t = em.find(Tranche.class, id);
		em.remove(t);
	}

	@Override
	public Tranche modifierTranche(Tranche t) {
		em.merge(t);
		return t;
	}

	@Override
	public Tranche getTranchebyId(long id) {
		
		return em.find(Tranche.class, id);
	}

}
