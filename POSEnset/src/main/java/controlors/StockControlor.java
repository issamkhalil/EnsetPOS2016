package controlors;

import com.entities.Categorie;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Produit;
import com.metier.IAccesRMI;
import com.views.ClientPanel;
import com.views.StockPanel;

public class StockControlor {
	private static IAccesRMI accesRMI;

	static {
		try {
			accesRMI =(IAccesRMI) Naming.lookup("rmi://localhost:1099/accRMI");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void indexAction(StockPanel sp) throws Exception {
		// TODO Auto-generated method stub
		List<Produit> produits = accesRMI.listerProduits();
		sp.getPp().addProds(produits);
	}
        public static List<Produit> searchProduct(String nom,String prixVente,String prixAchat,Categorie cat) throws Exception{
            return null;
        }
        public static void saveProduct(String img,String ref,String nom,String prixAchat,String prixVente,String taxe,String qte,Categorie cat) throws Exception{
            
        }
        public static void updateProduct(Produit produit,byte img[],String ref,String nom,String prixAchat,String prixVente,String taxe,String qte,Categorie cat) throws Exception{
            
        }
        public static void deleteProduct(Produit prod) throws Exception{
            
        }
       

}
