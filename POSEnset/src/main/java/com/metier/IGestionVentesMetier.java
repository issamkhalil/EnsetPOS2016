package com.metier;

import java.util.Date;
import java.util.List;

import com.entities.Adresse;
import com.entities.LigneVente;
import com.entities.Tranche;
import com.entities.Vente;

public interface IGestionVentesMetier {
	// **************************      ventes  *************************
	
	/*
	 * @param com.entities.Vente
	 * fonction ajouter une Vente
	 */
	public void AddVente(Vente v);
	/*
	 * @param com.entities.Vente
	 * fonction supprimer une Vente 
	 */
	public void deleteVente(Vente v);
	
	/*
	 * @param long le ID et Vente 
	 * fonction modifier une Vente 
	 */
	public void modifierVente(long id,Vente v);
	
	/*
	 * @return java.util.List<Vente>
	 * fonction lister touts les  Ventes
	 */
	public List<Vente> listerVentes();
	/*
	 * @param long id
	 * @return entities.Vente
	 * fonction chercher une Vente  par id 
	 */
	public Vente getVentebyId(long id);
	/*
	 * @param Date date de debut 
	 * @param Date date de fin
	 * @return List<Produit>
	 * fonction chercher une Vente entre deux date  
	 */
	public List<Vente> getVenteEntre2date(Date dateDeb,Date dateFin);
	/*
	 * @param long le id de client 
	 * @return List<Produit>
	 * fonction chercher une Vente par l'ID de client
	 */
	public List<Vente> getVenteparClientID(long clientId);
	
	/*
	 * @param long le totale à payer 
	 * @return List<Produit>
	 * fonction chercher une Vente par le totale à payer 
	 */
	public List<Vente> getVenteparTotale(double totale);
	
	
	/*
	 * @param long id de client
	 * @param double totale fe la vente
	 * @param Date date de debut 
	 * @param Date date de fin
	 * @return List<Produit>
	 * @use getVenteEntre2date, getVenteparTotale, and  getVenteparClientID
	 * fonction chercher une Vente par des Critaires  
	 */
	public List<Vente> getVenteParCritaires(long idClient,double total,Date dateDeb,Date dateFin);
	
	
	/*
	 *@param long le id du produit
	 *@return java.util.List<Vente> 
	 * fonction retourne la liste des ventes qui contien un produit
	 */
	public List<Vente> getVenteParProduit(long produitId);
	
	/*
	 *@param long le id du produit
	 *@return java.util.List<Adresse> 
	 *@use getVenteParProduit
	 * fonction retourne la liste des adresse d'un produits 
	 * utiliser pour afficher les places d'un produit sur google maps
	 */
	public List<Adresse> getAdresseDeProduit(long produitId);

	
	// *************************************    LigneVente  *****************************
	
		/*
		 * @param com.entities.LigneVente
		 * fonction ajouter une LigneVente
		 */
		public void AddLigneVente(LigneVente lv);
		
		/*
		 * @param List<LigneVente>
		 * fonction ajouter une liste deLigneVente
		 */
		public void AddListLigneVente(List<LigneVente> listLv);
		
		/*
		 * @param com.entities.LigneVente
		 * fonction supprimer une LigneVente 
		 */
	//	public void deleteLigneVente(LigneVente lv);
		
		
		/*
		 * @param long le ID
		 * @param LigneVente
		 * fonction modifier une LigneVente 
		 */
		public void modifierLigneVente(long id,LigneVente lv);
	
	
	
	

// *************************************    Tranches  *****************************
	
	/*
	 * @param com.entities.Tranche
	 * fonction ajouter une Tranche de payment d'une vente
	 */
	public void AddTranche(Tranche t);

	/*
	 * @param List<Tranche>
	 * fonction ajouter une liste de Tranches
	 */
	public void AddListTranches(List<Tranche> listTranches);

	
	/*
	 * @param com.entities.Tranche
	 * fonction supprimer une Tranche 
	 */
	public void deleteTranche(Tranche t);
	
	/*
	 * @param long le ID
	 * @param Tranche contient les nouveaux valeur
	 * fonction modifier une tranche 
	 */
	public void modifierTranche(long id,Tranche t);
	
	/*
	 * @param long id
	 * fonction change l'etat d'une tranche payè ou non payè
	 * true -> false  and false -> true
	 */
	public void toggelEtatTranche(long id);
	
	/*
	 * @param long id
	 * @return entities.Tranche
	 * fonction chercher une Tranche  par id 
	 */
	public Tranche  getTranchebyId(long id);


}

