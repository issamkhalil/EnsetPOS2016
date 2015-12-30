package controlors;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Categorie;
import com.entities.Produit;
import com.metier.IAccesRMI;
import com.views.Main;
import com.views.VentePanel;

public class SalesControlor extends SuperControlor{
	private static  IAccesRMI accesRMI;
	
	static{
		try {
			accesRMI =(IAccesRMI) Naming.lookup("rmi://localhost:1099/accRMI");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void indexAction(VentePanel vp) throws RemoteException {
		List<Categorie> ventes;
		try {
			ventes = accesRMI.listerCategories();
			vp.addCategories((ArrayList<Categorie>) ventes);
			List<Produit> produits=accesRMI.listerProduits();
			vp.addProducts((ArrayList<Produit>) produits);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void ListerProdParCatAction(Main main, Categorie categorie) throws Exception {
		VentePanel ventePanel= (VentePanel) main.getListPanel().get("vente");
	         List<Produit>	produits=accesRMI.getProduitsbyCategorie(categorie.getId());
		ventePanel.addProducts(produits);
	}
}
