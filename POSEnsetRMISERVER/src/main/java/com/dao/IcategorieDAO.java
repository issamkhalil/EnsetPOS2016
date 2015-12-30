package com.dao;

import java.util.List;

import com.entities.Categorie;

public interface IcategorieDAO {

	/*
	 * @param com.entities.Categorie
	 * fonction ajouter une Categorie
	 */
	public void AddCategorie(Categorie c);
	
	/*
	 * @param long id
	 * fonction supprimer une Categorie 
	 */
	public void deleteCategorie(long id);
	
	/*
	 * @param Categorie 
	 * fonction modifier une Categorie 
	 */
	public void modifierCategorie(Categorie c);
	
	/*
	 * @return java.util.List<Categorie>
	 * fonction lister toutn les  Categories
	 */
	public List<Categorie> listerCategories();
	/*
	 * @param long id
	 * @return entities.Categorie
	 * fonction chercher une Categorie  par id 
	 */
	public Categorie getCategoriebyId(long id);




}
