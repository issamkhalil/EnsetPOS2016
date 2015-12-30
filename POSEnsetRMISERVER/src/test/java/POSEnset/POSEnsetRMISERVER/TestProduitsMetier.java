package POSEnset.POSEnsetRMISERVER;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Categorie;
import com.entities.Produit;
import com.metier.IGestionProduitsMetier;

public class TestProduitsMetier {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });

			IGestionProduitsMetier gestionProduitsMetier = (IGestionProduitsMetier) context
					.getBean("gestionProduitsMetier");

			File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg");
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();

			 Categorie c = new Categorie("c1", bFile);
			 gestionProduitsMetier.AddCategorie(c);
			 Produit produit = new Produit("p002", "pc portable ASUS i7", 25,
			 20, 5000, 3000, bFile);
			 
			 Produit produit2 = new Produit("p003", "pc portable ASUS i7", 25,
					 20, 5000, 3000, bFile);
					 
			 Categorie categorie= gestionProduitsMetier.getCategoriebyId(1);
			 produit.setCategorie(categorie);
			 produit2.setCategorie(categorie);
				 gestionProduitsMetier.AddProduit(produit);
				 gestionProduitsMetier.AddProduit(produit2);

//			Produit produit = gestionProduitsMetier.getProduitbyId(1);
//			byte[] img = produit.getImage();
//			File file = new File(System.getenv("temp")+"\\POSEnsetTemp");
//			file.mkdir();
//			file = new File(System.getenv("temp")+"\\POSEnsetTemp\\sans.jpg");
//			
//			FileOutputStream fileOutputStream = new FileOutputStream(file);
//			fileOutputStream.write(img);
//			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
