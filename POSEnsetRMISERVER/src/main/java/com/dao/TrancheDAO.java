package com.dao;

import java.util.List;




import javax.persistence.Query;

import com.entities.Tranche;
import com.entities.Vente;

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
	@Override
	public List<Tranche> getTranchebyVente(Vente v) throws Exception {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from Tranche t where t.vente=:v");
		q.setParameter("v", v);
		return q.getResultList();
	}


}
