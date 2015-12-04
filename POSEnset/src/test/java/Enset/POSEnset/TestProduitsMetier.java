package Enset.POSEnset;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

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
			Categorie cat = new Categorie("psss", bFile);
			gestionProduitsMetier.AddCategorie(cat);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
