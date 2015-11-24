package com.dao;

import java.util.Date;
import java.util.List;

import com.entities.Adresse;
import com.entities.LigneVente;
import com.entities.Tranche;
import com.entities.Vente;

public interface IVenteDAO {
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

}
