package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAO {
	@PersistenceContext
	protected EntityManager em;
}
