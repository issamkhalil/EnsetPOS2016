package com.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.swing.Icon;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 * la classe Vente implement l'interface comparable pour tier les vente 
 * en fonction de la date pour afficher les ventes les plus recent en premier
 * 
 */

@Entity
public class Vente implements Comparable<Vente>{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Vente other = (Vente) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		return true;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private Date date;
	private PaymentType paymentType;
	private double totale;
	private float remise;
	@OneToMany(mappedBy="vente")
	private List<LigneVente> lignsVente;
	
	@OneToMany(mappedBy="vente")
	private List<Tranche> tranches ;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public List<Tranche> getTranches() {
		return tranches;
	}
	public void setTranches(List<Tranche> tranches) {
		this.tranches = tranches;
	}
	public List<LigneVente> getLignsVente() {
		return lignsVente;
	}
	public void setLignsVente(List<LigneVente> lignsVente) {
		this.lignsVente = lignsVente;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public float getRemise() {
		return remise;
	}
	public void setRemise(float remise) {
		this.remise = remise;
	}
	
	public Vente(Date date, PaymentType paymentType, float remise, double totale) {
		super();
		this.date = date;
		this.paymentType = paymentType;
		this.remise = remise;
		this.totale = totale;
		
	}
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int compareTo(Vente v) {
		return this.date.compareTo(v.date);
	}
	
	
	
}
