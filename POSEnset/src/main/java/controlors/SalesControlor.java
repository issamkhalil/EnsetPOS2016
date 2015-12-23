package controlors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Categorie;
import com.entities.Produit;
import com.metier.IGestionProduitsMetier;
import com.metier.IGestionVentesMetier;
import com.views.Main;
import com.views.VentePanel;

public class SalesControlor extends SuperControlor{
	private static  IGestionVentesMetier gestionVentesMetier;
	private static  IGestionProduitsMetier gestionProduitsMetier;
	
	static{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		gestionVentesMetier = (IGestionVentesMetier) context.getBean("gestionVentesMetier");
		gestionProduitsMetier = (IGestionProduitsMetier) context.getBean("gestionProduitsMetier");
	}
	
	public static void indexAction(VentePanel vp) {
		List<Categorie> ventes=gestionProduitsMetier.listerCategories();
		vp.addCategories((ArrayList<Categorie>) ventes);
		List<Produit> produits=gestionProduitsMetier.listerProduits();
		vp.addProducts((ArrayList<Produit>) produits);
	
	}

	public static void ListerProdParCatAction(Main main, Categorie categorie) {
		VentePanel ventePanel= (VentePanel) main.getListPanel().get("vente");
	         List<Produit>	produits=gestionProduitsMetier.getProduitsbyCategorie(categorie.getId());
		ventePanel.addProducts(produits);
	}
}
