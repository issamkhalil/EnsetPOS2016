package com.dao;

import com.entities.Adresse;

public class AdresseDAO extends GenericDAO implements IAdresseDAO{
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
