package controlors;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.entities.Categorie;
import com.entities.Client;
import com.entities.LigneVente;
import com.entities.PaymentType;
import com.entities.Produit;
import com.entities.Tranche;
import com.entities.Vente;
import com.views.Main;
import com.views.VentePanel;

import java.util.Map;

public class SalesControlor extends SuperControlor {

	public static void indexAction(VentePanel vp) throws RemoteException {
		List<Categorie> ventes;
		try {
			ventes = accesRMI.listerCategories();
			vp.addCategories((ArrayList<Categorie>) ventes);
			List<Produit> produits = accesRMI.listerProduits();
			vp.addProducts((ArrayList<Produit>) produits);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ListerProdParCatAction(Main main, Categorie categorie)
			throws Exception {
		VentePanel ventePanel = (VentePanel) main.getListPanel().get("vente");
		List<Produit> produits = accesRMI.getProduitsbyCategorie(categorie
				.getId());
		ventePanel.addProducts(produits);
	}

	/**
	 * 
	 * fonction qui va enregistrer les ligne de vente des ensembre des produits
	 * les types possible espese, cheque , carte
	 * 
	 * @param listProduit
	 *            liste des produit et 2 eme parametre c'est la quantité
	 * @param type
	 *            type de vente espese, cheque , carte
	 * @exception si
	 *                il y a une exception il faut preciser le message en
	 *                francais clair
	 */
	public static void validerVente(Map<Produit, Integer> listProduit,
			PaymentType type, Client client) throws Exception {
		if (type.equals(PaymentType.traites))
			return;
		Vente v = new Vente();
		v.setClient(client);
		v.setDate(new Date());
		v.setPaymentType(type);
		v.setRemise(0);
		List<LigneVente> ligneVentes = new ArrayList<LigneVente>();
		double totale = 0;
		for (Map.Entry<Produit, Integer> entrySet : listProduit.entrySet()) {
			Produit key = entrySet.getKey();
			Integer value = entrySet.getValue();
			totale += value * key.getPrixVente(); // à mdifier
			ligneVentes.add(new LigneVente(value, key, v));
		}
		v.setTotale(totale);
		List<Tranche> tranches = new ArrayList<Tranche>();
		tranches.add(new Tranche(totale, new Date(), true, v));
		v.setTranches(tranches);
		v.setLignsVente(ligneVentes);
		accesRMI.AddVente(v);
	}

	/**
	 * fonction qui va enregister un vente de type traite
	 * 
	 * @param listProduit
	 *            liste des produit et quantité
	 * @param traites
	 *            liste des traites
	 * @throws Exception
	 *             si il y a une exception il faut preciser le message en
	 *             francais clair
	 */
	public static void validerVente(Map<Produit, Integer> listProduit,
			double traites[], Client client) throws Exception {
		
		Vente v = new Vente();
		v.setClient(client);
		v.setDate(new Date());
		v.setPaymentType(PaymentType.traites);
		v.setRemise(0);
		List<LigneVente> ligneVentes = new ArrayList<LigneVente>();
		double totale = 0;
		for (Map.Entry<Produit, Integer> entrySet : listProduit.entrySet()) {
			Produit key = entrySet.getKey();
			Integer value = entrySet.getValue();
			totale += value * key.getPrixVente(); // à mdifier
			ligneVentes.add(new LigneVente(value, key, v));
		}
		List<Tranche> tranches = new ArrayList<Tranche>();
		for (int i = 0; i < traites.length; i++) {
			tranches.add(new Tranche(traites[i], new Date(), false, v));
		}
		v.setTotale(totale);
		v.setTranches(tranches);
		v.setLignsVente(ligneVentes);
		accesRMI.AddVente(v);
	}
}
