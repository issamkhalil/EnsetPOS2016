package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Categorie;

public class CategorieDAO extends GenericDAO implements IcategorieDAO{
	@Override
	public void AddCategorie(Categorie c) {
		em.persist(c);
	}

	@Override
	public void deleteCategorie(long id) {
		Categorie c = em.find(Categorie.class, id);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}

	@Override
	public List<Categorie> listerCategories() {
		Query q = em.createQuery("select c from Categorie c");
		return q.getResultList();
	}

	@Override
	public Categorie getCategoriebyId(long id) {
		return em.find(Categorie.class, id);
	}


}
