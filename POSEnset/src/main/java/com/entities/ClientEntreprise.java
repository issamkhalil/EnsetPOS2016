package com.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * 
 */
@Entity
@DiscriminatorValue(value="cltEse")
public class ClientEntreprise extends Client {

	private String RegistreCommerce;
	@Column(unique=true)
	private String fax;
	@Column(unique=true)
	public String getRegistreCommerce() {
		return RegistreCommerce;
	}
	public void setRegistreCommerce(String registreCommerce) {
		RegistreCommerce = registreCommerce;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public ClientEntreprise(String nom, String registreCommerce, String fax) {
		super(nom);
		RegistreCommerce = registreCommerce;
		this.fax = fax;
	}
	public ClientEntreprise() {
		super();
	}	
}
