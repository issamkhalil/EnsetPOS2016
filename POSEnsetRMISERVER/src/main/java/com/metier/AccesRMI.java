package com.metier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

public class AccesRMI extends UnicastRemoteObject implements IAccesRMI{
	private IGestionClientMetier gestionClientMetier;
	private IGestionProduitsMetier gestionProduitsMetier;
	private IGestionVentesMetier gestionVentesMetier;
	private IGestionComptesMetier gestionComptesMetier;
	
	
	public AccesRMI() throws RemoteException {
		super();
		try {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			gestionClientMetier = (IGestionClientMetier) 
					context.getBean("gestionClientMetier");
			
			gestionComptesMetier = (IGestionComptesMetier) 
					context.getBean("gestionComptesMetier");
			
			gestionProduitsMetier = (IGestionProduitsMetier) 
					context.getBean("gestionProduitsMetier");
			
			gestionVentesMetier = (IGestionVentesMetier) 
					context.getBean("gestionVentesMetier");
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void AddClientParticulier(ClientParticulier c) throws Exception {
		// TODO Auto-generated method stub
			gestionClientMetier.AddClientParticulier(c);
	}

	@Override
	public void AddClientEntreprise(ClientEntreprise c) throws Exception {
		// TODO Auto-generated method stub

		gestionClientMetier.AddClientEntreprise(c);
	}

	@Override
	public void removeClient(long id) throws Exception {
		// TODO Auto-generated method stub
		gestionClientMetier.removeClient(id);
	}

	@Override
	public void modifierClient(Client c) throws Exception {
		// TODO Auto-generated method stub
		gestionClientMetier.modifierClient(c);
	}

	@Override
	public List<Client> listerClientsAll() throws Exception {
		// TODO Auto-generated method stub
		return gestionClientMetier.listerClientsAll();
	}

	@Override
	public List<Client> chercheClientsparNom(String nomMotif) throws Exception {
		// TODO Auto-generated method stub
		return gestionClientMetier.chercheClientsparNom(nomMotif);
	}

	@Override
	public Client chercheClientparID(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionClientMetier.chercheClientparID(id);
	}

	@Override
	public void AddAdresse(Adresse a) throws Exception {
		// TODO Auto-generated method stub
		gestionClientMetier.AddAdresse(a);
	}

	@Override
	public void deleteAdresse(long id) throws Exception {
		// TODO Auto-generated method stub
		gestionClientMetier.deleteAdresse(id);
	}

	@Override
	public void modifierAdresse(Adresse a) throws Exception {
		// TODO Auto-generated method stub
		gestionClientMetier.modifierAdresse(a);
	}

	@Override
	public Adresse getAdressebyId(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionClientMetier.getAdressebyId(id);
	}

	@Override
	public void AddCompteUtilisateur(CompteUtilisateur c) throws Exception {
		// TODO Auto-generated method stub
		gestionComptesMetier.AddCompteUtilisateur(c);
	}

	@Override
	public void deleteCompteUtilisateur(CompteUtilisateur c) throws Exception {
		// TODO Auto-generated method stub
		gestionComptesMetier.deleteCompteUtilisateur(c);
	}

	@Override
	public void modifierCompteUtilisateur(CompteUtilisateur c) throws Exception {
		// TODO Auto-generated method stub
		gestionComptesMetier.modifierCompteUtilisateur(c);
	}

	@Override
	public List<CompteUtilisateur> listerComptesUtilisateurs() throws Exception {
		// TODO Auto-generated method stub
		return gestionComptesMetier.listerComptesUtilisateurs();
	}

	@Override
	public CompteUtilisateur getCompteUtilisateurbyId(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionComptesMetier.getCompteUtilisateurbyId(id);
	}

	@Override
	public CompteUtilisateur getCompteUtilisateurbyLogin(String login)
			throws Exception {
		// TODO Auto-generated method stub
		return gestionComptesMetier.getCompteUtilisateurbyLogin(login);
	}

	@Override
	public boolean authentification(String login, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return gestionComptesMetier.authentification(login, password);
	}

	@Override
	public void AddProduit(Produit p) throws Exception {
		// TODO Auto-generated method stub
		gestionProduitsMetier.AddProduit(p);
	}

	@Override
	public void deleteProduit(long id) throws Exception {
		// TODO Auto-generated method stub
		gestionProduitsMetier.deleteProduit(id);
	}

	@Override
	public void modifierProduit(Produit p) throws Exception {
		// TODO Auto-generated method stub
		gestionProduitsMetier.modifierProduit(p);
	}

	@Override
	public List<Produit> listerProduits() throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.listerProduits();
	}

	@Override
	public Produit getProduitbyId(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitbyId(id);
	}

	@Override
	public List<Produit> getProduitsbyReferanceMotif(String ref)
			throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyReferanceMotif(ref);
	}

	@Override
	public List<Produit> getProduitsbyPa(double pa) throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyPa(pa);
	}

	@Override
	public List<Produit> getProduitsbyPv(double pv) throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyPv(pv);
	}

	@Override
	public List<Produit> getProduitsbyCategorie(long idCat) throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyCategorie(idCat);
	}

	@Override
	public List<Produit> getProduitsbyCritaires(String motifRef, double pa,
			double pv, long idCa) throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyCritaires(motifRef, pa, pv, idCa);
	}

	@Override
	public void AddCategorie(Categorie c) throws Exception {
		// TODO Auto-generated method stub
		gestionProduitsMetier.AddCategorie(c);
	}

	@Override
	public void deleteCategorie(long id) throws Exception {
		// TODO Auto-generated method stub
		gestionProduitsMetier.deleteCategorie(id);
	}

	@Override
	public void modifierCategorie(Categorie c) throws Exception {
		// TODO Auto-generated method stub
		gestionProduitsMetier.modifierCategorie(c);
	}

	@Override
	public List<Categorie> listerCategories() throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.listerCategories();
	}

	@Override
	public Categorie getCategoriebyId(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getCategoriebyId(id);
	}

	@Override
	public void AddVente(Vente v) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.AddVente(v);
	}

	@Override
	public void deleteVente(long id) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.deleteVente(id);
	}

	@Override
	public void modifierVente(Vente v) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.modifierVente(v);
	}

	@Override
	public List<Vente> listerVentes() throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.listerVentes();
	}

	@Override
	public Vente getVentebyId(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getVentebyId(id);
	}

	@Override
	public List<Vente> getVenteEntre2date(Date dateDeb, Date dateFin)
			throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getVenteEntre2date(dateDeb, dateFin);
	}

	@Override
	public List<Vente> getVenteparClientID(long clientId) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getVenteparClientID(clientId);
	}

	@Override
	public List<Vente> getVenteparTotale(double totale) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getVenteparTotale(totale);
		}

	@Override
	public List<Vente> getVenteParCritaires(long idClient, double total,
			Date dateDeb, Date dateFin) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getVenteParCritaires(idClient, total, dateDeb, dateFin);
	}

	@Override
	public List<Vente> getVenteParProduit(long produitId) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getVenteParProduit(produitId);
	}

	@Override
	public List<Adresse> getAdresseDeProduit(long produitId) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getAdresseDeProduit(produitId);
	}

	@Override
	public void AddLigneVente(LigneVente lv, long venteId) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.AddLigneVente(lv, venteId);
	}

	@Override
	public void AddListLigneVente(List<LigneVente> listLv, long venteId)
			throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.AddListLigneVente(listLv, venteId);
	}

	@Override
	public void modifierLigneVente(LigneVente lv) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.modifierLigneVente(lv);
	}

	@Override
	public LigneVente getLigneVenteByID(long d) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getLigneVenteByID(d);
	}

	@Override
	public void AddTranche(Tranche t, long venteId) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.AddTranche(t, venteId);
	}

	@Override
	public void AddListTranches(List<Tranche> listTranches, long venteId)
			throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.AddListTranches(listTranches, venteId);
	}

	@Override
	public void deleteTranche(Tranche t) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.deleteTranche(t);
	}

	@Override
	public void modifierTranche(Tranche t) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.modifierTranche(t);
	}

	@Override
	public void toggelEtatTranche(long id) throws Exception {
		// TODO Auto-generated method stub
		gestionVentesMetier.toggelEtatTranche(id);
	}

	@Override
	public Tranche getTranchebyId(long id) throws Exception {
		// TODO Auto-generated method stub
		return gestionVentesMetier.getTranchebyId(id);
	}

	@Override
	public List<Client> chercheClients(long id, String nomMotif,
			String pNomRCMotif) throws Exception {
		return gestionClientMetier.chercheClients(id,nomMotif,pNomRCMotif);
	}

}
