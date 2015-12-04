package com.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ComptesDAOImpl;
import com.dao.IComptesDAO;
import com.entities.CompteUtilisateur;


/**
 * 
 *  @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 *  @version 1
 *  @see IGestionComptesMetier and com.dao.IComptesDAO
 *
 */
@Transactional
public class GestionComptesMetier implements IGestionComptesMetier{

	private IComptesDAO comptesDAO; 
	
	public void setComptesDAO(IComptesDAO comptesDAO) {
		this.comptesDAO = comptesDAO;
	}

	@Override
	public void AddCompteUtilisateur(CompteUtilisateur c) {
		comptesDAO.AddCompteUtilisateur(c);
	}

	@Override
	public void deleteCompteUtilisateur(CompteUtilisateur c) {
		comptesDAO.deleteCompteUtilisateur(c.getId());
	}

	@Override
	public void modifierCompteUtilisateur(long id, CompteUtilisateur c) {
		CompteUtilisateur compte = (CompteUtilisateur) comptesDAO.getCompteUtilisateurbyId(id);
		compte.setEmail(c.getEmail());
		compte.setLogin(c.getLogin());
		compte.setNom(c.getNom());
		compte.setPassword(c.getPassword());
		compte.setPrenom(c.getPrenom());
		compte.setTelephone(c.getTelephone());
		compte.setType(c.getType());
		comptesDAO.modifierCompteUtilisateur(compte);
	}

	@Override
	public List<CompteUtilisateur> listerComptesUtilisateurs() {
		return comptesDAO.listerComptesUtilisateurs();
	}

	@Override
	public CompteUtilisateur getCompteUtilisateurbyId(long id) {
		return comptesDAO.getCompteUtilisateurbyId(id);
	}

	@Override
	public CompteUtilisateur getCompteUtilisateurbyLogin(String login) {
		return comptesDAO.getCompteUtilisateurbyLogin(login);
	}

	@Override
	public boolean authentification(String login, String password) {
		// TODO Auto-generated method stub
		return comptesDAO.authentification(login, password);
	}
	
	
}
