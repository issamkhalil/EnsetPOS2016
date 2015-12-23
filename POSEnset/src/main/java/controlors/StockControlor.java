package controlors;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Produit;
import com.metier.IGestionProduitsMetier;
import com.metier.IGestionVentesMetier;
import com.views.ClientPanel;
import com.views.StockPanel;

public class StockControlor {
	private static IGestionVentesMetier gestionVentesMetier;
	private static IGestionProduitsMetier gestionProduitsMetier;

	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		gestionVentesMetier = (IGestionVentesMetier) context
				.getBean("gestionVentesMetier");
		gestionProduitsMetier = (IGestionProduitsMetier) context
				.getBean("gestionProduitsMetier");
	}

	public static void indexAction(StockPanel sp) {
		// TODO Auto-generated method stub
		List<Produit> produits = gestionProduitsMetier.listerProduits();
		sp.getPp().addProds(produits);
	}

}
