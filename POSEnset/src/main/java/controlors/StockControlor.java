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
        /**
         * fonction qui va chercher les produit 
         * @param nom c'est le designation de produit
         * @param prixVente c'est le prix de vente de produit mais rmq : il faut faire la conversion de string vers double 
         * @param prixAchat c'est le prix de achat de produit mais rmq : il faut faire la conversion de string vers double 
         * @param cat c'est le categorie de produit rechercher
         * @return il return liste de produits trouver
         * @throws Exception il envoie exception c'est il y a des erreurs rmq : il faut preciser le message en francais
         */
        public static List<Produit> searchProduct(String nom,String prixVente,String prixAchat,Categorie cat) throws Exception{
            return null;
        }
        /**
         * fonction qui va enregister un produit
         * @param img image de produit
         * @param ref reference de produit
         * @param nom le designation de produit
         * @param prixAchat  c'est le prix de achat de produit mais rmq : il faut faire la conversion de string vers double
         * @param prixVente   c'est le prix de vente de produit mais rmq : il faut faire la conversion de string vers double
         * @param taxe c'est le porcentage entre 0 et 100 rmq il faut envoyer un exception si taxe n'est pas correcte
         * @param qte quantité de produit en stock valeur positive
         * @param cat categorie de produit
         * @throws Exception  il envoie exception c'est il y a des erreurs rmq : il faut preciser le message en francais
         */
        public static void saveProduct(byte img[],String ref,String nom,String prixAchat,String prixVente,String taxe,String qte,Categorie cat) throws Exception{
            
        }
        /**
         * fonction qui va modifier un produit
         * @param img image de produit
         * @param ref reference de produit
         * @param nom le designation de produit
         * @param prixAchat  c'est le prix de achat de produit mais rmq : il faut faire la conversion de string vers double
         * @param prixVente   c'est le prix de vente de produit mais rmq : il faut faire la conversion de string vers double
         * @param taxe c'est le porcentage entre 0 et 100 rmq il faut envoyer un exception si taxe n'est pas correcte
         * @param qte quantité de produit en stock valeur positive
         * @param cat categorie de produit
         * @throws Exception  il envoie exception c'est il y a des erreurs rmq : il faut preciser le message en francais
         */
        public static void updateProduct(Produit produit,byte img[],String ref,String nom,String prixAchat,String prixVente,String taxe,String qte,Categorie cat) throws Exception{
            
        }
        /**
         * fonction qui va supprimer un produit
         * @param prod c'est le produit
         * @throws Exception Exception  il envoie exception c'est il y a des erreurs rmq : il faut preciser le message en francais
         */
        public static void deleteProduct(Produit prod) throws Exception{
            
        }
   /**
    * fonction qui return tout les categorie
    * @return 
    */
    public static List<Categorie> fetchAllCategories() throws Exception {
         return accesRMI.listerCategories();
    }

    public static void deleteCategorie(Categorie elementAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void saveCategorie(byte[] image, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void updateCategorie(Categorie elementAt, byte[] image, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       

}
