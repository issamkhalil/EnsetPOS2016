package com.dao;

import com.entities.Tranche;

public class TrancheDAO extends GenericDAO implements ITrancheDAO {
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
