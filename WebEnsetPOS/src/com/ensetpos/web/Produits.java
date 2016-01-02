package com.ensetpos.web;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Produit;
import com.metier.IAccesRMI;
import com.metier.IWebAccesRMI;
import com.opensymphony.xwork2.ActionSupport;

public class Produits extends ActionSupport{
	
	private IWebAccesRMI webAccesRMI;
	public List<Produit> produits;
	
	
	
	
	public Produits() {
		super();
		try {
			webAccesRMI =(IWebAccesRMI) Naming.lookup("rmi://localhost:1099/webac");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public String index() {
		try {
			produits = webAccesRMI.listerProduits();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepionnnn  Iciiii "  );
			e.printStackTrace();
			produits = new ArrayList<Produit>();
		}
		return SUCCESS;
	}
	
}
	