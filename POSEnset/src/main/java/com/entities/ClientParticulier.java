package com.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 */

@Entity
@DiscriminatorValue(value="cltPar")
public class ClientParticulier extends Client{
	
	private String prenom;
	private String compteFaceBook;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCompteFaceBook() {
		return compteFaceBook;
	}
	public void setCompteFaceBook(String compteFaceBook) {
		this.compteFaceBook = compteFaceBook;
	}
	public ClientParticulier(String nom, String prenom, String compteFaceBook) {
		super(nom);
		this.prenom = prenom;
		this.compteFaceBook = compteFaceBook;
	}
	public ClientParticulier() {
		super();
	}
	
}
