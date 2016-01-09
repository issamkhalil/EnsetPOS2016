package com.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IProduitsDAO;
import com.dao.IcategorieDAO;
import com.entities.Categorie;
import com.entities.Produit;

/**
 * 
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * @see IGestionProduitsMetier and com.dao.IProduitDAO
 *
 *
 */
@Transactional
public class GestionProduitsMetier implements IGestionProduitsMetier {

	private IProduitsDAO produitDao;
	private IcategorieDAO categorieDao;
	


	public void setProduitDao(IProduitsDAO produitDao) {
		this.produitDao = produitDao;
	}

	public void setCategorieDao(IcategorieDAO categorieDao) {
		this.categorieDao = categorieDao;
	}

	@Override
	public void AddProduit(Produit p) {
		produitDao.AddProduit(p);
	}

	@Override
	public void deleteProduit(long id) {
		produitDao.deleteProduit(id);
	}



	@Override
	public List<Produit> listerProduits() {
		return produitDao.listerProduits();
	}

	@Override
	public Produit getProduitbyId(long id) {
		return produitDao.getProduitbyId(id);
	}

	@Override
	public List<Produit> getProduitsbyReferanceMotif(String ref) {
		return produitDao.getProduitsbyReferanceMotif(ref);
	}

	@Override
	public List<Produit> getProduitsbyPa(double pa) {
		return produitDao.getProduitsbyPa(pa);
	}

	@Override
	public List<Produit> getProduitsbyPv(double pv) {
		return produitDao.getProduitsbyPv(pv);
	}

	@Override
	public List<Produit> getProduitsbyCategorie(long idCat) {
		if(idCat==0){
			return produitDao.listerProduits();
		}
		return produitDao.getProduitsbyCategorie(idCat);
	}
	
	private <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

	
	/**
	 **
	 * @use getProduitsbyReferanceMotif, getProduitsbyPa, getProduitsbyPv, getProduitsbyCategorie;
	 * @see com.metier.IGestionProduitsMetier
	 */
	
	@Override
	public List<Produit> getProduitsbyCritaires(String motifRef, double pa, double pv, long idCat) {
		List<Produit> prod1 = produitDao.getProduitsbyCategorie(idCat);
		List<Produit> prod2 = produitDao.getProduitsbyPa(pa);
		List<Produit> prod3 = produitDao.getProduitsbyPv(pv);
		List<Produit> prod4 = produitDao.getProduitsbyReferanceMotif(motifRef);
		return union(union(prod1, prod2), union(prod3, prod4));
	}
	
	@Override
	public void AddCategorie(Categorie c) {
		categorieDao.AddCategorie(c);
	}

	@Override
	public void deleteCategorie(long id) {
		categorieDao.deleteCategorie(id);
	}


	@Override
	public List<Categorie> listerCategories() {
		return categorieDao.listerCategories();
	}

	@Override
	public Categorie getCategoriebyId(long id) {
		return categorieDao.getCategoriebyId(id);
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		produitDao.modifierProduit(p);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		categorieDao.modifierCategorie(c);
	}

}
