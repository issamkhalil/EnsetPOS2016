package com.dao;

import com.entities.Adresse;

public interface IAdresseDAO {
	/*
	 * @param com.entities.Adresse
	 * fonction ajouter une Adresse
	 */
	public Adresse AddAdresse(Adresse a);
	
	/*
	 * @param long id
	 * fonction supprimer une Adresse 
	 */
	public void deleteAdresse(long id);
	
	/*
	 * @param Adresse 
	 * fonction modifier une Adresse 
	 */
	public Adresse modifierAdresse(Adresse a);
	
	/*
	 * @param long id
	 * @return entities.Adresse
	 * fonction chercher une Categorie  par id 
	 */
	public Adresse getAdressebyId(long id);

}
