package com.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IAdresseDAO;
import com.dao.IClientDAO;
import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.entities.Produit;

/**
 * 
 * @author <a href="mailto:issam.khalil11@gmail.com"> KHALIL Issam GLSID2 <a/>
 * @version 1
 * @see IGestionClientMetier com.dao.IClientDAO and com.dao.IAdresseDAO
 *
 *
 */
@Transactional
public class GestionClientMetierImpl implements IGestionClientMetier {

	private IClientDAO clientDAO;
	private IAdresseDAO adresseDAO;

	public void setAdresseDAO(IAdresseDAO adresseDAO) {
		this.adresseDAO = adresseDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public void AddClientParticulier(ClientParticulier c) {
		adresseDAO.AddAdresse(c.getAdresse());
		clientDAO.AddClient(c);
	}

	@Override
	public void AddClientEntreprise(ClientEntreprise c) {
		adresseDAO.AddAdresse(c.getAdresse());
		clientDAO.AddClient(c);
	}

	@Override
	public void removeClient(long id) {
		clientDAO.removeClient(id);
	}


		@Override
	public List<Client> listerClientsAll() {
		return clientDAO.listerClientsAll();
	}

	@Override
	public List<Client> chercheClientsparNom(String nomMotif) {

		return clientDAO.chercheClientsparNom(nomMotif);
	}

	@Override
	public Client chercheClientparID(long id) {
		return clientDAO.chercheClientparID(id);
	}

	@Override
	public void AddAdresse(Adresse a) {
		adresseDAO.AddAdresse(a);
	}

	@Override
	public void deleteAdresse(long id) {
		adresseDAO.deleteAdresse(id);
	}

		@Override
	public Adresse getAdressebyId(long id) {
		return adresseDAO.getAdressebyId(id);
		}

		@Override
		public void modifierClient(Client c) throws Exception {
			// TODO Auto-generated method stub
			clientDAO.modifierClient(c);
		}

		@Override
		public void modifierAdresse(Adresse a) {
			// TODO Auto-generated method stub
			adresseDAO.modifierAdresse(a);
			
		}

		@Override
		public List<Client> chercheClients(long id, String nomMotif,String pNomRCMotif) {
			List<Client> l1= clientDAO.chercheClientsPNomRCMotif(pNomRCMotif);
			List<Client> l2= clientDAO.chercheClientsparNom(nomMotif);
			List<Client> l3= new ArrayList<Client>();
			l3.add(chercheClientparID(id));
			return union(intersection(l1, l2), l3); 
		}

		private <T> List<T> union(List<T> list1, List<T> list2) {
	        Set<T> set = new HashSet<T>();

	        set.addAll(list1);
	        set.addAll(list2);

	        return new ArrayList<T>(set);
	    }
		
		 private <T> List<T> intersection(List<T> list1, List<T> list2) {
		        List<T> list = new ArrayList<T>();

		        for (T t : list1) {
		            if(list2.contains(t)) {
		                list.add(t);
		            }
		        }

		        return list;
		    }

		
}
