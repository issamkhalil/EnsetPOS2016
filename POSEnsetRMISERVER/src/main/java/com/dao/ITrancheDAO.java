package com.dao;

import java.util.List;

import com.entities.Tranche;
import com.entities.Vente;

public interface ITrancheDAO {
	
	/*
	 * @param long id
	 * @return Tranche
	 * fonction ajouter une Tranche de payment d'une vente
	 */
	public Tranche AddTranche(Tranche t);
	/*
	 * @param long id
	 * fonction supprimer une Tranche 
	 */
	public void deleteTranche(long id);
	
	/*
	 * @param Tranche contient les nouveaux valeur
	 * @return Tranche
	 * fonction modifier une tranche 
	 */
	public Tranche modifierTranche(Tranche t);
	

	/*
	 * @param long id
	 * @return entities.Tranche
	 * fonction chercher une Tranche  par id 
	 */
	public Tranche  getTranchebyId(long id);

	public List<Tranche> getTranchebyVente(Vente v) throws Exception ;
}
