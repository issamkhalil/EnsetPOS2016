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

import java.util.ArrayList;

public class StockControlor extends SuperControlor{
    
//    public static void indexAction(StockPanel sp) throws Exception {
//        // TODO Auto-generated method stub
//        List<Produit> produits = accesRMI.listerProduits();
//        sp.getPp().addProds(produits);
//    }

    /**
     * fonction qui va chercher les produit
     *
     * @param nom c'est la designation du produit
     * @param prixVente c'est le prix de vente de produit mais rmq : il faut
     * faire la conversion de string vers double
     * @param prixAchat c'est le prix de achat de produit mais rmq : il faut
     * faire la conversion de string vers double
     * @param cat c'est le categorie de produit rechercher
     * @return il return liste de produits trouver
     * @throws Exception il envoie exception c'est il y a des erreurs rmq : il
     * faut preciser le message en francais
     */
    public static List<Produit> searchProduct(String nom, String prixVente,
            String prixAchat, Categorie cat) throws Exception {
        return accesRMI.getProduitsbyCritaires(nom,
                Double.parseDouble(prixAchat), Double.parseDouble(prixVente),
                cat.getId());
    }

    /**
     * fonction qui va enregister un produit
     *
     * @param img image de produit
     * @param ref reference de produit
     * @param nom le designation de produit
     * @param prixAchat c'est le prix de achat de produit mais rmq : il faut
     * faire la conversion de string vers double
     * @param prixVente c'est le prix de vente de produit mais rmq : il faut
     * faire la conversion de string vers double
     * @param taxe c'est le porcentage entre 0 et 100 rmq il faut envoyer un
     * exception si taxe n'est pas correcte
     * @param qte quantité de produit en stock valeur positive
     * @param cat categorie de produit
     * @throws Exception il envoie exception c'est il y a des erreurs rmq : il
     * faut preciser le message en francais
     */
    public static void saveProduct(byte img[], String ref, String nom,
            String prixAchat, String prixVente, String taxe, String qte,
            Categorie cat) throws Exception {
        long q;
        float t;
        double pa, pv;
        try {
            q = Long.parseLong(qte);
        } catch (NumberFormatException e) {
            throw new Exception("Veillez sasir une quantité valide !!!");
        }

        try {
            t = Float.parseFloat(taxe);
        } catch (NumberFormatException e) {
            throw new Exception("Veillez sasir une taxe valide !!!");
        }

        try {
            pv = Double.parseDouble(prixVente);
        } catch (NumberFormatException e) {
            throw new Exception("Veillez sasir un prix de vente valide !!!");
        }

        try {
            pa = Double.parseDouble(prixAchat);
        } catch (NumberFormatException e) {
            throw new Exception("Veillez sasir un prix d'achat valide !!!");
        }

        Produit produit = new Produit(ref, nom, q, t, pv, pa, img);
        produit.setCategorie(cat);
        
        accesRMI.AddProduit(produit);
    }

    /**
     * fonction qui va modifier un produit
     *
     * @param img image de produit
     * @param ref reference de produit
     * @param nom le designation de produit
     * @param prixAchat c'est le prix de achat de produit mais rmq : il faut
     * faire la conversion de string vers double
     * @param prixVente c'est le prix de vente de produit mais rmq : il faut
     * faire la conversion de string vers double
     * @param taxe c'est le porcentage entre 0 et 100 rmq il faut envoyer un
     * exception si taxe n'est pas correcte
     * @param qte quantité de produit en stock valeur positive
     * @param cat categorie de produit
     * @throws Exception il envoie exception c'est il y a des erreurs rmq : il
     * faut preciser le message en francais
     */
    public static void updateProduct(Produit produit, byte img[], String ref,
            String nom, String prixAchat, String prixVente, String taxe,
            String qte, Categorie cat) throws Exception {

        produit.setCategorie(cat);
        produit.setDesigniation(nom);
        produit.setImage(img);
        try {
            produit.setPrixAchat(Double.parseDouble(prixAchat));
        } catch (RuntimeException e) {
            throw new Exception("Veillez sasir un prix d'achat valide !!!");
        }
        try {
            produit.setPrixVente(Double.parseDouble(prixVente));
        } catch (RuntimeException e) {
            throw new Exception("Veillez sasir un prix de vente valide !!!");
        }
        try {
            produit.setQuantiteEnStock(Long.parseLong(qte));
        } catch (RuntimeException e) {
            throw new Exception("Veillez sasir une quantité valide !!!");
        }
        produit.setReferance(ref);
        try {
            produit.setTva(Float.parseFloat(taxe));
        } catch (RuntimeException e) {
            throw new Exception("Veillez sasir une Tva valide !!!");
        }
        
        accesRMI.modifierProduit(produit);
    }

    /**
     * fonction qui va supprimer un produit
     *
     * @param prod c'est le produit
     * @throws Exception Exception il envoie exception c'est il y a des erreurs
     * rmq : il faut preciser le message en francais
     */
    public static void deleteProduct(Produit prod) throws Exception {

    }

    /**
     * fonction qui return tout les categorie
     *
     * @return
     */
    public static List<Categorie> fetchAllCategories() throws Exception {
        return accesRMI.listerCategories();
    }

    public static void deleteCategorie(Categorie elementAt) {
        try {
            accesRMI.deleteCategorie(elementAt.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveCategorie(byte[] image, String text, String text0) {
        try {
            Categorie c = new Categorie(text, image);
            accesRMI.AddCategorie(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateCategorie(Categorie elementAt, byte[] image,
            String text, String text0) {

        try {

            elementAt.setImage(image);
            elementAt.setNom(text);
            accesRMI.modifierCategorie(elementAt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static List<Produit> searchProduct(String reference, String designation, String prixVente) throws Exception {
    	return accesRMI.getProduitsbyReferanceMotif(reference);    
    }

    public static List<Produit> fetchAllProducts() throws Exception {
        return accesRMI.listerProduits();
    }

}
