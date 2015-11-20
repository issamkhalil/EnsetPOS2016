package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 */

@Entity
public class LigneVente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private long quantite;
	
	@ManyToOne()
	@JoinColumn(name="id_produit")
	private Produit produit;
	@ManyToOne()
	@JoinColumn(name="id_vente")
	private Vente vente;
	public long getQuantite() {
		return quantite;
	}
	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Vente getVente() {
		return vente;
	}
	public void setVente(Vente vente) {
		this.vente = vente;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LigneVente(long quantite, Produit produit, Vente vente) {
		super();
		this.quantite = quantite;
		this.produit = produit;
		this.vente = vente;
	}
	public LigneVente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
