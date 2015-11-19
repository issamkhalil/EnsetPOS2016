package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAOImpl {
	@PersistenceContext
	protected EntityManager em;
}
