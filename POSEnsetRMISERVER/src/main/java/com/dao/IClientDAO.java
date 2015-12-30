package com.dao;

import java.util.List;

import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.Produit;

public interface IClientDAO {
	/*
	 * @param Client 
	 * ajouter un client
	 */
	public Client AddClient(Client c);

	/*
	 * @param long le ID de client
	 * fonction supprimer un client 
	 */
	public void removeClient(long id);
	/*
	 * @param Client 
	 * fonction modifier un client 
	 */
	public Client modifierClient(Client c);
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

	public List<Client> chercheClientsPNomRCMotif(String pNomRCMotif);
}