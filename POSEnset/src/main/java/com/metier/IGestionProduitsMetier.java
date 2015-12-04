package com.metier;

import java.util.List;

import com.entities.Categorie;
import com.entities.Produit;

public interface IGestionProduitsMetier {
	// *******************************   les produits   *************************// 
	/*
	 * @param com.entities.Produit
	 * fonction ajouter un Produit
	 */
	public void AddProduit(Produit p);
	/*
	 * @param long id
	 * fonction supprimer un Produit 
	 */
	public void deleteProduit(long id);
	
	/*
	 * @param long le ID 
	 * @param Produit 
	 * @use getProduitbyId
	 * fonction modifier un Produit 
	 */
	public void modifierProduit(long id,Produit p);
	
	/*
	 * @return java.util.List<Produit>
	 * fonction lister toutn les  Produits
	 */
	public List<Produit> listerProduits();
	/*
	 * @param long id
	 * @return entities.Produit
	 * fonction chercher un Produit  par id 
	 */
	public Produit getProduitbyId(long id);
	/*
	 * @param String ref
	 * @return List<Produit>
	 * fonction chercher un  Produit par une motif de referance 
	 */
	public List<Produit> getProduitsbyReferanceMotif(String ref);
	
	/*
	 * @param double pa
	 * @return List<Produit>
	 * fonction chercher un  Produit par le prix d'achat 
	 */
	public List<Produit> getProduitsbyPa(double pa);
	
	/*
	 * @param double pv
	 * @return List<Produit>
	 * fonction chercher un  Produit par le prix de vente 
	 */
	public List<Produit> getProduitsbyPv(double pv);
	
	
	/*
	 * @param long  id categorie
	 * @return List<Produit>
	 * fonction chercher un  Produit par une motif de referance 
	 */
	public List<Produit> getProduitsbyCategorie(long idCat);
	
	/*
	 * @param String une sous chaine de la referance
	 * @param double le prix de vente
	 * @param double le prix d'achat
	 * @param long  id de categorie
	 * @use getProduitsbyReferanceMotif, getProduitsbyPa, getProduitsbyPv, getProduitsbyCategorie;
	 * @return List<Produit>
	 * fonction chercher un  Produit par une motif de referance 
	 */
	public List<Produit> getProduitsbyCritaires(String motifRef,double pa,double pv,long idCa);
	
	
	
// ****************************   categorie   ************************************
	
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
		 * @param long le ID
		 * @param Categorie 
		 * @use getCategoriebyId
		 * fonction modifier une Categorie 
		 */
		public void modifierCategorie(long id,Categorie c);
		
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
