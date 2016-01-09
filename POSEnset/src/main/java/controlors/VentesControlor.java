/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlors;

import com.entities.Client;
import com.entities.PaymentType;
import com.entities.Vente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author elmottaki
 */
public class VentesControlor extends SuperControlor{

    /**
     * fonction pour chercher des ventes
     * @param idVente id de vente 
     * @param total prix total payer , il faut le converter en double
     * @param client client de vente
     * @param dateDebut date avant la date de vente
     * @param dateFin date aprés la date de vente
     * @return list des ventes
     * @exception il faut preciser les message en francais
     */
    public static List<Vente> searchVentes(String idVente, String total, Client client, Date dateDebut, Date dateFin) throws Exception {
        return accesRMI.getVenteParCritaires(client.getId(), Double.parseDouble(total), dateDebut, dateFin);
         
    }
    /**
     * fonction pour recuperer des ventes d'un client
     * @param client
     * @return list des ventes
     * @exception il faut preciser les message en francais
     */
    public static List<Vente> fetchVentes(Client client) throws Exception  {
        return accesRMI.getVenteparClientID(client.getId());
    }
}
