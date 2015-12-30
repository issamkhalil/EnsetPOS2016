package com.metier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Categorie;
import com.entities.Client;
import com.entities.Produit;

public class WebAccesRMI extends UnicastRemoteObject implements IWebAccesRMI{
	
	private IGestionClientMetier gestionClientMetier;
	private IGestionProduitsMetier gestionProduitsMetier;
	

	public WebAccesRMI() throws RemoteException {
		super();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		gestionClientMetier = (IGestionClientMetier) context
				.getBean("gestionClientMetier");
		gestionProduitsMetier = (IGestionProduitsMetier) context.
				getBean("gestionProduitsMetier");

	}

	
	public void modifierClient(Client c) throws Exception {
		// TODO Auto-generated method stub
		gestionClientMetier.modifierClient( c);
	}

	
	public List<Client> listerClientsAll() throws RemoteException {
		// TODO Auto-generated method stub
		return gestionClientMetier.listerClientsAll();
	}

	
	public List<Client> chercheClientsparNom(String nomMotif)
			throws RemoteException {
		// TODO Auto-generated method stub
		return gestionClientMetier.chercheClientsparNom(nomMotif);
	}

	
	public Client chercheClientparID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return gestionClientMetier.chercheClientparID(id);
	}

	
	public List<Produit> listerProduits() throws RemoteException {
		// TODO Auto-generated method stub
		List<Produit> produits1 =  gestionProduitsMetier.listerProduits();
		List<Produit> produits2=new ArrayList<Produit>();
		for (Produit produit : produits1) {
			produits2.add(produit);
		}
		
		return produits2;
	}

	
	public Produit getProduitbyId(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitbyId(id);
	}

	
	public List<Produit> getProduitsbyReferanceMotif(String ref)
			throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyReferanceMotif(ref);
	}

	
	public List<Produit> getProduitsbyPa(double pa) throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyPa(pa);
	}

	
	public List<Produit> getProduitsbyPv(double pv) throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyPv(pv);
	}

	
	public List<Produit> getProduitsbyCategorie(long idCat)
			throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getProduitsbyCategorie(idCat);
	}

	
	public List<Categorie> listerCategories() throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.listerCategories();
	}

	
	public Categorie getCategoriebyId(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return gestionProduitsMetier.getCategoriebyId(id);
	}

	
}
