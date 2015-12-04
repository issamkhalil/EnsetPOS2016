package com.metier;

import java.util.ArrayList;
import java.util.List;
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
	public void modifierProduit(long id, Produit p) {
			Produit prod =produitDao.getProduitbyId(id);
			prod.setCategorie(p.getCategorie());
			prod.setDesigniation(p.getDesigniation());
			prod.setImage(p.getImage());
			prod.setLignesVente(p.getLignesVente());
			prod.setPrixAchat(p.getPrixAchat());
			prod.setPrixVente(p.getPrixVente());
			prod.setQuantiteEnStock(p.getQuantiteEnStock());
			prod.setReferance(p.getReferance());
			prod.setTva(p.getTva());
			produitDao.modifierProduit(prod);
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
	
	@SuppressWarnings("unused")
	private final List<Produit> intersection(
			List<Produit> prods1, List<Produit> prods2,
			List<Produit> prods3 , List<Produit> prods4
				){
		ArrayList<Produit> result=new ArrayList<Produit>();
		  for (Produit p : prods1) {
	            if(prods2.contains(p) && prods3.contains(p) && prods4.contains(p) ) {
	                result.add(p);
	            }
	        }
					return result;
		
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
		return intersection(prod1, prod2, prod3, prod4);
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
	public void modifierCategorie(long id, Categorie c) {
		Categorie cat = categorieDao.getCategoriebyId(id);
		cat.setImage(c.getImage());
		cat.setNom(c.getNom());
		categorieDao.modifierCategorie(cat);
	}

	@Override
	public List<Categorie> listerCategories() {
		return categorieDao.listerCategories();
	}

	@Override
	public Categorie getCategoriebyId(long id) {
		return categorieDao.getCategoriebyId(id);
	}

}
