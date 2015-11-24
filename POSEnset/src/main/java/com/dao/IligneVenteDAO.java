package com.dao;

import com.entities.LigneVente;

public interface IligneVenteDAO {
	
	/*
	 * @param com.entities.LigneVente
	 * fonction ajouter une LigneVente
	 */
	public void AddLigneVente(LigneVente lv);
	/*
	 * @param long le ID
	 * @param LigneVente
	 * fonction modifier une LigneVente 
	 */
	public void modifierLigneVente(LigneVente lv);

	/*
	 * @param long id
	 * @return LigneVente
	 * 
	 */
	public LigneVente getLigneVenteByID(long id);


}
