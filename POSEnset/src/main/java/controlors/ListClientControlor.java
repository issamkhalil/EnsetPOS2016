/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlors;

import com.entities.Client;
import com.entities.ClientParticulier;
import com.models.ContException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elmottaki
 */
public class ListClientControlor extends SuperControlor{
	
	
    
    public static List<Client> search(String id,String nom,String prenom) throws Exception{
        if(id.equals("")){
            id="0";
        }
        return accesRMI.chercheClients(Long.parseLong(id), nom, prenom);
    }
    
}
