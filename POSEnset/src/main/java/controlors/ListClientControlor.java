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

/**
 *
 * @author elmottaki
 */
public class ListClientControlor {
	
	
    
    public static ArrayList<Client> search(String id,String nom,String prenom) throws ContException{
        ArrayList<Client> list = new ArrayList<Client>();
        list.add(new ClientParticulier("Abdelilah", "EL MOTTAKI", "elmottaki"));
        return list;
    }
    
    
}
