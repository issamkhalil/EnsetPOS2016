package com.dao;

import java.util.List;

import com.entities.Categorie;
import com.entities.Produit;

public interface IProduitsDAO {
	/*
	 * @param com.entities.Produit
	 * fonction ajouter un Produit
	 */
	public Produit AddProduit(Produit p);
	/*
	 * @param long id
	 * fonction supprimer un Produit 
	 */
	public void deleteProduit(long id);
	
	/*
	 * @param Produit 
	 * fonction modifier un Produit 
	 */
	public void modifierProduit(Produit p);
	
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
	
}
