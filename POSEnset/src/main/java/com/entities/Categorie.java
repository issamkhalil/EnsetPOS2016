
package com.entities;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 */
@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String nom;
	@Column(nullable=true,length=11212960)
	private byte[] image;	
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public  byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Categorie(String nom, byte[] image) {
		super();
		this.nom = nom;
		this.image = image;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString() {
        return id+"- "+nom;
    }
        
        
	

	
	
}
