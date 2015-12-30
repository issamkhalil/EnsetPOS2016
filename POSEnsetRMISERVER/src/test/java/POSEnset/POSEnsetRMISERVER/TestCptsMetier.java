package POSEnset.POSEnsetRMISERVER;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ProduitsDAOImpl;
import com.entities.CompteUtilisateur;
import com.entities.Produit;
import com.metier.IGestionComptesMetier;

public class TestCptsMetier {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });

			IGestionComptesMetier gestionComptesMetier = (IGestionComptesMetier) context
					.getBean("gestionComptesMetier");
			
			  System.out.println(gestionComptesMetier);
			  
			  CompteUtilisateur c1= new CompteUtilisateur("issam", "khali",
			  "0621948738","issam.khalil11@gmail.com", "issam", "123","admin"
			  );
			  
			  gestionComptesMetier.AddCompteUtilisateur(c1);
			
			boolean b = gestionComptesMetier.authentification("issam", "123");
			System.out.println("autehntification : "+ b);
			assertTrue(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
