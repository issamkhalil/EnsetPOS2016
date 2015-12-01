package com.metier;

import java.util.List;

import com.entities.CompteUtilisateur;

public interface IGestionComptesMetier {

	/*
	 * @param com.entities.CompteUtilisateur
	 * fonction ajouter un compte utilisateurr 
	 */
	public void AddCompteUtilisateur(CompteUtilisateur c);
	/*
	 * @param com.entities.CompteUtilisateur
	 * fonction supprimer un compte utilisateurr 
	 */
	public void deleteCompteUtilisateur(CompteUtilisateur c);
	
	/*
	 * @param long le ID 
	 * @param  com.entities.CompteUtilisateur 
	 * @use getCompteUtilisateurbyId
	 * fonction modifier un CompteUtilisateur 
	 */
	public void modifierCompteUtilisateur(long id,CompteUtilisateur c);
	
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
	public CompteUtilisateur getCompteUtilisateurbyLogin(String login);
	
   public boolean authentification(String login,String password);
	
}
