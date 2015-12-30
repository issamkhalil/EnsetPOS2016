package com.metier;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import com.entities.Adresse;
import com.entities.Categorie;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.CompteUtilisateur;
import com.entities.LigneVente;
import com.entities.Produit;
import com.entities.Tranche;
import com.entities.Vente;

public interface IAccesRMI extends Remote {

	public void AddClientParticulier(ClientParticulier c) throws Exception ;

	public void AddClientEntreprise(ClientEntreprise c) throws Exception ;

	public void removeClient(long id) throws Exception ;

	public void modifierClient(Client c) throws Exception;

	public List<Client> listerClientsAll() throws Exception ;

	public List<Client> chercheClientsparNom(String nomMotif) throws Exception ;
	public List<Client> chercheClients(long id,String nomMotif,String pNomRCMotif) throws Exception ;
	

	public Client chercheClientparID(long id) throws Exception ;

	public void AddAdresse(Adresse a) throws Exception ;

	public void deleteAdresse(long id) throws Exception ;

	public void modifierAdresse(Adresse a) throws Exception ;

	public Adresse getAdressebyId(long id) throws Exception ;

	public void AddCompteUtilisateur(CompteUtilisateur c) throws Exception ;

	public void deleteCompteUtilisateur(CompteUtilisateur c) throws Exception ;

	public void modifierCompteUtilisateur(CompteUtilisateur c) throws Exception ;

	public List<CompteUtilisateur> listerComptesUtilisateurs() throws Exception ;

	public CompteUtilisateur getCompteUtilisateurbyId(long id) throws Exception ;

	public CompteUtilisateur getCompteUtilisateurbyLogin(String login) throws Exception ;

	public boolean authentification(String login, String password) throws Exception ;

	public void AddProduit(Produit p) throws Exception ;

	public void deleteProduit(long id) throws Exception ;

	public void modifierProduit(Produit p) throws Exception ;

	public List<Produit> listerProduits() throws Exception ;

	public Produit getProduitbyId(long id) throws Exception ;

	public List<Produit> getProduitsbyReferanceMotif(String ref) throws Exception ;

	public List<Produit> getProduitsbyPa(double pa) throws Exception ;

	public List<Produit> getProduitsbyPv(double pv) throws Exception ;

	public List<Produit> getProduitsbyCategorie(long idCat) throws Exception ;

	public List<Produit> getProduitsbyCritaires(String motifRef, double pa,
			double pv, long idCa) throws Exception ;

	public void AddCategorie(Categorie c) throws Exception ;

	public void deleteCategorie(long id) throws Exception ;

	public void modifierCategorie(Categorie c) throws Exception ;

	public List<Categorie> listerCategories() throws Exception ;

	public Categorie getCategoriebyId(long id) throws Exception ;

	public void AddVente(Vente v) throws Exception ;

	public void deleteVente(long id) throws Exception ;

	public void modifierVente(Vente v) throws Exception ;

	public List<Vente> listerVentes() throws Exception ;

	public Vente getVentebyId(long id) throws Exception ;

	public List<Vente> getVenteEntre2date(Date dateDeb, Date dateFin) throws Exception ;

	public List<Vente> getVenteparClientID(long clientId) throws Exception ;

	public List<Vente> getVenteparTotale(double totale) throws Exception ;

	public List<Vente> getVenteParCritaires(long idClient, double total,
			Date dateDeb, Date dateFin) throws Exception ;

	public List<Vente> getVenteParProduit(long produitId) throws Exception ;

	public List<Adresse> getAdresseDeProduit(long produitId) throws Exception ;

	public void AddLigneVente(LigneVente lv, long venteId) throws Exception ;

	public void AddListLigneVente(List<LigneVente> listLv, long venteId) throws Exception ;

	public void modifierLigneVente(LigneVente lv) throws Exception ;

	public LigneVente getLigneVenteByID(long d) throws Exception ;

	public void AddTranche(Tranche t, long venteId) throws Exception ;

	public void AddListTranches(List<Tranche> listTranches, long venteId) throws Exception ;

	public void deleteTranche(Tranche t) throws Exception ;

	public void modifierTranche(Tranche t) throws Exception ;

	public void toggelEtatTranche(long id) throws Exception ;

	public Tranche getTranchebyId(long id) throws Exception ;

}
