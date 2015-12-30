package POSEnset.POSEnsetRMISERVER;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.LigneVente;
import com.entities.PaymentType;
import com.entities.Produit;
import com.entities.Vente;
import com.metier.IGestionProduitsMetier;
import com.metier.IGestionVentesMetier;

public class TestVenteMetier {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });

			IGestionVentesMetier gestionVentesMetier = (IGestionVentesMetier) context
					.getBean("gestionVentesMetier");
			IGestionProduitsMetier gestionProduitsMetier  = (IGestionProduitsMetier) context
			.getBean("gestionProduitsMetier");
			Vente vente = new Vente(new Date(), PaymentType.parCarte, 10, 5600);
			gestionVentesMetier.AddVente(vente);
			LigneVente ligneVente = new LigneVente();
			LigneVente ligneVente2 = new LigneVente();
			
			Produit prod = gestionProduitsMetier.getProduitbyId(1);
			Produit prod2 = gestionProduitsMetier.getProduitbyId(2);
			
			ligneVente.setProduit(prod);
			ligneVente.setQuantite(5);
		
			ligneVente2.setProduit(prod2);
			ligneVente2.setQuantite(15);
			
			List<LigneVente> ligneVentes = new ArrayList<LigneVente>();
			ligneVentes.add(ligneVente2);
			ligneVentes.add(ligneVente);
			
			gestionVentesMetier.AddListLigneVente(ligneVentes, 1);
			
			int count = gestionVentesMetier.listerVentes().size();
			assertTrue(count == 1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
