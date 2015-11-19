package com.metier;

import java.util.List;

import com.entities.Adresse;
import com.entities.Categorie;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.Produit;

public interface IGestionClientMetier {
 // *******************************  Client *******************************************
	/*
	 * @param com.entities.clientParticulier
	 * fonction ajouter un client particulier 
	 */
	public void AddClientParticulier(ClientParticulier c);
	/*
	 * @param com.entities.clientEntreprise
	 * fonction ajouter un client particulier 
	 */
	public void AddClientEntreprise(ClientEntreprise c);
	
	/*
	 * @param long le ID de client
	 * fonction supprimer un client 
	 */
	public void removeClient(long id);
	/*
	 * @param long le ID et Client 
	 * fonction modifier un client 
	 * @use chercheClientparID
	 */
	public void modifierClient(long id,Client c);
	/*
	 * @param long ID
	 * @param  com.entities.Client 
	 * @return java.util.List<Client>
	 * fonction lister touts les clients 
	 */
	public List<Client> listerClientsAll();
	/*
	 * @param String 
	 * @return java.util.List<Client>
	 * fonction cherche  les clients  par le nom
	 */
	public List<Client> chercheClientsparNom(String nomMotif);
	
	/*
	 * @param long id
	 * @return Client
	 * fonction cherche  un clients  par le ID
	 */
	public Client chercheClientparID(long id);
	 
	// ****************************************  Adresse **********************************
	/*
	 * @param com.entities.Adresse
	 * fonction ajouter une Adresse
	 */
	public void AddAdresse(Adresse a);
	
	/*
	 * @param long id
	 * fonction supprimer une Adresse 
	 */
	public void deleteAdresse(long id);
	
	/*
	 * @param long le ID
	 * @param Adresse 
	 * fonction modifier une Adresse 
	 * @use getAdressebyId
	 */
	public void modifierAdresse(long id,Adresse a);
	
	/*
	 * @param long id
	 * @return entities.Categorie
	 * fonction chercher une Categorie  par id 
	 */
	public Produit getAdressebyId(long id);

}
