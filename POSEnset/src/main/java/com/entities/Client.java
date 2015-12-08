package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_client",length=6)
public abstract class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String nom;
	@Column(unique=true)
	private String telephone;
	@Column(unique=true)
	private String email;
	private double maxCredit;
	private String note;
	@ManyToOne
	@JoinColumn(name="id_adresse",nullable=false)
	private Adresse adresse;
	
	@OneToMany(mappedBy="client")
	private List<Vente> ventes;
	
	
	public List<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMaxCredit() {
		return maxCredit;
	}
	public void setMaxCredit(double maxCredit) {
		this.maxCredit = maxCredit;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}


	public Client(String nom, String telephone, String email, double maxCredit, String note, Adresse adresse) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.maxCredit = maxCredit;
		this.note = note;
		this.adresse = adresse;
	}
	
	public Client(String nom) {
		super();
		this.nom = nom;
	}
	public Client() {
		super();
	}

}
