package com.dao;

import java.util.List;

import com.entities.CompteUtilisateur;

public interface IComptesDAO {
	/*
	 * @param com.entities.CompteUtilisateur
	 * fonction ajouter un compte utilisateurr 
	 */
	public CompteUtilisateur AddCompteUtilisateur(CompteUtilisateur c);
	/*
	 * @param long id
	 * fonction supprimer un compte utilisateurr 
	 */
	public void deleteCompteUtilisateur(long id);
	
	/*
	 * @param  com.entities.CompteUtilisateur 
	 * fonction modifier un CompteUtilisateur 
	 */
	public void modifierCompteUtilisateur(CompteUtilisateur c);
	
	/*
	 * @return java.util.List<CompteUtilisateur>
	 * fonction lister toutn les  Compte Utilisateur
	 */
	public List<CompteUtilisateur> listerComptesUtilisateurs();
	/*
	 * @param long id
	 * @return entities.CompteUtilisateur
	 * fonction chercher un compte utilisateur ar id 
	 */
	public CompteUtilisateur getCompteUtilisateurbyId(long id);
	/*
	 * @param String Login
	 * @return entities.CompteUtilisateur
	 * fonction chercher un compte utilisateur ar referance 
	 */

}
