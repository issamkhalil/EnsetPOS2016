package com.entities;

import java.util.Date;

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
public class Tranche {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private double somme;
	@Column(nullable=false)
	private Date datePayment;
	@Column(nullable=false)
	private boolean paye;
	@ManyToOne
	@JoinColumn(name="id_vente",nullable=false)
	private Vente vente;
	
	public double getSomme() {
		return somme;
	}
	public void setSomme(double somme) {
		this.somme = somme;
	}
	public Date getDatePayment() {
		return datePayment;
	}
	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}
	public boolean isPaye() {
		return paye;
	}
	public void setPaye(boolean paye) {
		this.paye = paye;
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
	public Tranche(double somme, Date datePayment, boolean paye, Vente vente) {
		super();
		this.somme = somme;
		this.datePayment = datePayment;
		this.paye = paye;
		this.vente = vente;
	}
	public Tranche() {
		super();
	}
	

}
