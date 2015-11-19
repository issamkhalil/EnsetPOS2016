package com.dao;

import java.util.Date;
import java.util.List;

import com.entities.Adresse;
import com.entities.LigneVente;
import com.entities.Tranche;
import com.entities.Vente;

public interface IGestionVenteDAO {
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
		public void deleteVente(long id);
		
		/*
		 * fonction modifier une Vente 
		 */
		public void modifierVente(Vente v);
		
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
		 * @param long le totale � payer 
		 * @return List<Produit>
		 * fonction chercher une Vente par le totale � payer 
		 */
		public List<Vente> getVenteparTotale(double totale);
		
		

		
		// *************************************    LigneVente  *****************************
		
			/*
			 * @param com.entities.LigneVente
			 * fonction ajouter une LigneVente
			 */
			public void AddLigneVente(LigneVente lv);
			/*
			 * @param long le ID
			 * @param LigneVente
			 * fonction modifier une LigneVente 
			 */
			public void modifierLigneVente(LigneVente lv);

			/*
			 * @param long id
			 * @return LigneVente
			 * 
			 */
			public LigneVente getLigneVenteByID(long id);
		

// *************************************    Tranches  *****************************
			
			/*
			 * @param long id
			 * @return Tranche
			 * fonction ajouter une Tranche de payment d'une vente
			 */
			public Tranche AddTranche(Tranche t);
			/*
			 * @param long id
			 * fonction supprimer une Tranche 
			 */
			public void deleteTranche(long id);
			
			/*
			 * @param Tranche contient les nouveaux valeur
			 * @return Tranche
			 * fonction modifier une tranche 
			 */
			public Tranche modifierTranche(Tranche t);
			

			/*
			 * @param long id
			 * @return entities.Tranche
			 * fonction chercher une Tranche  par id 
			 */
			public Tranche  getTranchebyId(long id);



}
