package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Categorie;
import com.entities.Produit;

public class ProduitsDAOImpl extends GenericDAO implements IProduitsDAO {

	@Override
	public Produit AddProduit(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public void deleteProduit(long id) {
		Produit p = em.find(Produit.class, id);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
	}

	@Override
	public List<Produit> listerProduits() {
		Query q = em.createQuery("select p from Produit p");
		return q.getResultList();
	}

	@Override
	public Produit getProduitbyId(long id) {
		return em.find(Produit.class, id);
	}

	@Override
	public List<Produit> getProduitsbyReferanceMotif(String ref) {
		Query q = em.createQuery("select p from Produit p where p.referance like :x");
		q.setParameter("x", "%" + ref + "%");
		return q.getResultList();
	}

	@Override
	public List<Produit> getProduitsbyPa(double pa) {
		Query q = em.createQuery("select p from Produit p where p.prixAchat = :x");
		q.setParameter("x", pa);
		return q.getResultList();
	}

	@Override
	public List<Produit> getProduitsbyPv(double pv) {
		Query q = em.createQuery("select p from Produit p where p.prixVente = :x");
		q.setParameter("x", pv);
		return q.getResultList();
	}

	@Override
	public List<Produit> getProduitsbyCategorie(long idCat) {
		Query q = em.createQuery("select p from Produit p where p.categorie = :x");
		Categorie c = em.find(Categorie.class, idCat);
		q.setParameter("x", c);
		return q.getResultList();
	}

	
}
