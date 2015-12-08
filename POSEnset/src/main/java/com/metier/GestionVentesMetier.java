package com.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IProduitsDAO;
import com.dao.ITrancheDAO;
import com.dao.IVenteDAO;
import com.dao.IligneVenteDAO;
import com.entities.Adresse;
import com.entities.LigneVente;
import com.entities.Produit;
import com.entities.Tranche;
import com.entities.Vente;

/**
 * 
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * @see IGestionVentesMetier,com.dao.IVenteDAO, com.dao.ITrancheDAO and
 *      com.dao.ITrancheDAO
 *
 *
 */

@Transactional
public class GestionVentesMetier implements IGestionVentesMetier {
	private IVenteDAO venteDao;
	private ITrancheDAO trancheDao;
	private IligneVenteDAO ligneventeDao;

	public void setVenteDao(IVenteDAO venteDao) {
		this.venteDao = venteDao;
	}

	public void setTrancheDao(ITrancheDAO trancheDao) {
		this.trancheDao = trancheDao;
	}

	public void setLigneventeDao(IligneVenteDAO ligneventeDao) {
		this.ligneventeDao = ligneventeDao;
	}

	@Override
	public void AddVente(Vente v) {
		venteDao.AddVente(v);
	}

	@Override
	public void deleteVente(long id) {
		venteDao.deleteVente(id);
	}

	@Override
	public void modifierVente(long id, Vente v) {
		Vente vente = venteDao.getVentebyId(id);
		vente.setClient(v.getClient());
		vente.setDate(v.getDate());
		vente.setPaymentType(v.getPaymentType());
		vente.setRemise(v.getRemise());
		vente.setTotale(v.getTotale());
		venteDao.modifierVente(v);
	}

	@Override
	public List<Vente> listerVentes() {
		return venteDao.listerVentes();
	}

	@Override
	public Vente getVentebyId(long id) {
		return venteDao.getVentebyId(id);
	}

	@Override
	public List<Vente> getVenteEntre2date(Date dateDeb, Date dateFin) {
		return venteDao.getVenteEntre2date(dateDeb, dateFin);
	}

	@Override
	public List<Vente> getVenteparClientID(long clientId) {
		return venteDao.getVenteparClientID(clientId);
	}

	@Override
	public List<Vente> getVenteparTotale(double totale) {
		return venteDao.getVenteparTotale(totale);
	}

	@SuppressWarnings("unused")
	private final List<Vente> intersection(List<Vente> vnts1, List<Vente> vnts2, List<Vente> vnts3) {
		ArrayList<Vente> result = new ArrayList<Vente>();
		for (Vente v : vnts1) {
			if (vnts2.contains(v) && vnts3.contains(v)) {
				result.add(v);
			}
		}
		return result;

	}

	@Override
	public List<Vente> getVenteParCritaires(long idClient, double total, Date dateDeb, Date dateFin) {
		List<Vente> lv1, lv2, lv3;
		lv1 = venteDao.getVenteEntre2date(dateDeb, dateFin);
		lv2 = venteDao.getVenteparClientID(idClient);
		lv3 = venteDao.getVenteparTotale(total);
		List<Vente> result = intersection(lv1, lv2, lv3);
		return result;
	}

	@Override
	public List<Vente> getVenteParProduit(long produitId) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IGestionProduitsMetier gestionProduitMetier = (IGestionProduitsMetier) context.getBean("gestionProduitsMetier");

		List<LigneVente> ligns = (gestionProduitMetier.getProduitbyId(produitId)).getLignesVente();
		HashSet<Vente> ventes = new HashSet<Vente>();
		for (LigneVente ligneVente : ligns) {
			ventes.add(ligneVente.getVente());
		}
		List<Vente> result = new ArrayList<Vente>(ventes);
		return result;
	}

	@Override
	public List<Adresse> getAdresseDeProduit(long produitId) {
		List<Vente> vents = this.getVenteParProduit(produitId);
		HashSet<Adresse> ad = new HashSet<Adresse>();
		for (Vente vente : vents) {
			ad.add(vente.getClient().getAdresse());
		}

		List<Adresse> adresses = new ArrayList<Adresse>(ad);
		return adresses;
	}

	@Override
	public void AddLigneVente(LigneVente lv,long venteId) {
		Vente vente = venteDao.getVentebyId(venteId);
		lv.setVente(vente);
		ligneventeDao.AddLigneVente(lv);
	}

	@Override
	public void AddListLigneVente(List<LigneVente> listLv,long venteId) {
		Vente vente = venteDao.getVentebyId(venteId);
		for (LigneVente ligneVente : listLv) {
			ligneVente.setVente(vente);
			ligneventeDao.AddLigneVente(ligneVente);
		}
	}

	@Override
	public void modifierLigneVente(long id, LigneVente lv) {
		LigneVente ligneVente = ligneventeDao.getLigneVenteByID(id);
		ligneVente.setProduit(lv.getProduit());
		ligneVente.setQuantite(lv.getQuantite());
		ligneventeDao.modifierLigneVente(ligneVente);
	}

	@Override
	public LigneVente getLigneVenteByID(long id) {
		return ligneventeDao.getLigneVenteByID(id);
	}

	@Override
	public void AddTranche(Tranche t,long venteId) {
		Vente vente = venteDao.getVentebyId(venteId);
		t.setVente(vente);
		trancheDao.AddTranche(t);
	}

	@Override
	public void AddListTranches(List<Tranche> listTranches,long venteId) {
		Vente vente = venteDao.getVentebyId(venteId);
			for (Tranche tranche : listTranches) {
				tranche.setVente(vente);
				trancheDao.AddTranche(tranche);
		}
	}

	@Override
	public void deleteTranche(Tranche t) {
		trancheDao.deleteTranche(t.getId());
	}

	@Override
	public void modifierTranche(long id, Tranche t) {
		Tranche tranche = trancheDao.getTranchebyId(id);
		tranche.setDatePayment(t.getDatePayment());
		tranche.setPaye(t.isPaye());
		tranche.setSomme(tranche.getSomme());
		trancheDao.modifierTranche(tranche);
	}

	@Override
	public void toggelEtatTranche(long id) {
		Tranche tranche = trancheDao.getTranchebyId(id);
		tranche.setPaye(!tranche.isPaye());
		trancheDao.modifierTranche(tranche);
	}

	@Override
	public Tranche getTranchebyId(long id) {
		return trancheDao.getTranchebyId(id);
	}

}
