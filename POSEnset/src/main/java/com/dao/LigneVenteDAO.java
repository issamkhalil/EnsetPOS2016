package com.dao;

import com.entities.LigneVente;
import com.entities.Tranche;

public class LigneVenteDAO extends GenericDAO implements IligneVenteDAO {
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




}
