package com.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 */
@Entity
public class Produit  implements Serializable{
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true, nullable = false)
	private String referance;
	@Column(nullable = false,length=255)
	private String designiation;
	
	@Column(nullable = false)
	private long quantiteEnStock;
	
	@Column(nullable=true)
	private float tva;
	@Column(nullable = false)
	private double prixVente;
	@Column(nullable = true)
	private double prixAchat;
	
	@Column(nullable=true,length=11212960)
	private byte[] image; // the name of image
	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	@OneToMany(mappedBy="produit")
	private List<LigneVente> lignesVente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReferance() {
		return referance;
	}
	public void setReferance(String referance) {
		this.referance = referance;
	}
	public String getDesigniation() {
		return designiation;
	}
	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public long getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(long quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	public List<LigneVente> getLignesVente() {
		return lignesVente;
	}
	public void setLignesVente(List<LigneVente> lignesVente) {
		this.lignesVente = lignesVente;
	}
	public Produit(String referance, String designiation,long quantiteEnStock, float tva, double prixVente, double prixAchat, byte[] image) {
		super();
		this.referance = referance;
		this.designiation = designiation;
		this.quantiteEnStock=quantiteEnStock;
		this.tva = tva;
		this.prixVente = prixVente;
		this.prixAchat = prixAchat;
		this.image = image;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((referance == null) ? 0 : referance.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		if (referance == null) {
			if (other.referance != null)
				return false;
		} else if (!referance.equals(other.referance))
			return false;
		return true;
	}
	
	public Produit() {
		super();
	}

	@Override
	public String toString() {
		return  id + " - " + designiation;
	}
	
}
