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

	@Override
	public CompteUtilisateur getCompteUtilisateurbyLogin(String login) {
		Query req=em.createQuery("from CompteUtilisateur c where c.login=':x'");
		req.setParameter("x", login);
		return (CompteUtilisateur)req.getResultList().get(0);
	}

	/*@version non Final
	 * @see com.dao.IComptesDAO#authentification(java.lang.String, java.lang.String)
	 * 
	 *  la version de cette fonction n'est pas finale car on doit 
	 *  la changer lors de l'integration de spring security
	 */
	@Override
	public boolean authentification(String login, String mp) {
		CompteUtilisateur c = this.getCompteUtilisateurbyLogin(login);
			return mp.equals(c.getPassword());
	}

}
