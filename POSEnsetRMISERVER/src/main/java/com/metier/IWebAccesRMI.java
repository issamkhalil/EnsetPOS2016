package com.metier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.entities.Categorie;
import com.entities.Client;
import com.entities.Produit;

public interface IWebAccesRMI extends Remote {

	public void modifierClient(Client c) throws Exception;
	/*
	 * @param long ID
	 * @param  com.entities.Client 
	 * @return java.util.List<Client>
	 * fonction lister touts les clients 
	 */
	public List<Client> listerClientsAll() throws RemoteException;
	/*
	 * @param String 
	 * @return java.util.List<Client>
	 * fonction cherche  les clients  par le nom
	 */
	public List<Client> chercheClientsparNom(String nomMotif) throws RemoteException;
	
	/*
	 * @param long id
	 * @return Client
	 * fonction cherche  un clients  par le ID
	 */
	public Client chercheClientparID(long id) throws RemoteException;

	/***************************************    Categorie et produit        ********************************/
	
	/*
	 * @return java.util.List<Produit>
	 * fonction lister toutn les  Produits
	 */
	public List<Produit> listerProduits()  throws RemoteException;
	/*
	 * @param long id
	 * @return entities.Produit
	 * fonction chercher un Produit  par id 
	 */
	public Produit getProduitbyId(long id)  throws RemoteException;
	/*
	 * @param String ref
	 * @return List<Produit>
	 * fonction chercher un  Produit par une motif de referance 
	 */
	public List<Produit> getProduitsbyReferanceMotif(String ref)  throws RemoteException;
	
	/*
	 * @param double pa
	 * @return List<Produit>
	 * fonction chercher un  Produit par le prix d'achat 
	 */
	public List<Produit> getProduitsbyPa(double pa)  throws RemoteException;
	
	/*
	 * @param double pv
	 * @return List<Produit>
	 * fonction chercher un  Produit par le prix de vente 
	 */
	public List<Produit> getProduitsbyPv(double pv)  throws RemoteException;
	
	
	/*
	 * @param long  id categorie
	 * @return List<Produit>
	 * fonction chercher un  Produit par une motif de referance 
	 */
	public List<Produit> getProduitsbyCategorie(long idCat)  throws RemoteException;
	
	
	
// ****************************   categorie   ************************************
	
		/*
		 * @return java.util.List<Categorie>
		 * fonction lister toutn les  Categories
		 */
		public List<Categorie> listerCategories() throws RemoteException;
		/*
		 * @param long id
		 * @return entities.Categorie
		 * fonction chercher une Categorie  par id 
		 */
		public Categorie getCategoriebyId(long id) throws RemoteException;

	
}
