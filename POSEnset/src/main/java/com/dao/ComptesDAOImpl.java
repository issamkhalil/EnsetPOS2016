package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.CompteUtilisateur;

public class ComptesDAOImpl extends GenericDAO implements IComptesDAO {

	@Override
	public CompteUtilisateur AddCompteUtilisateur(CompteUtilisateur c) {
		em.persist(c);
		return c;
	}

	@Override
	public void deleteCompteUtilisateur(long id) {
		CompteUtilisateur cu = em.find(CompteUtilisateur.class, id);
		em.remove(cu);
	}

	@Override
	public void modifierCompteUtilisateur(CompteUtilisateur c) {
		em.merge(c);
	}

	@Override
	public List<CompteUtilisateur> listerComptesUtilisateurs() {
		Query q = em.createQuery("select c from CompteUtilisateur c");
		return q.getResultList();
	}

	@Override
	public CompteUtilisateur getCompteUtilisateurbyId(long id) {
		return em.find(CompteUtilisateur.class, id);
	}

}
