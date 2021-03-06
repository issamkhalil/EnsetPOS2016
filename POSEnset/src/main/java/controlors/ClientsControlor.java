package controlors;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;







import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.views.ClientPanel;

public class ClientsControlor extends SuperControlor{


	public static void indexAction(ClientPanel cp) throws Exception {
		List<Client> clients = accesRMI.listerClientsAll();
		cp.addClients(clients);
		cp.reInitTfs();
	}

	

	public static void addClinetAction(String nom, String prenom, String faxe,
			String cptfb, String mail, String credit, String note, String reg,
			String tele, boolean faceBookJaime, boolean clientPar, String vile,
			String region, String cp) throws Exception {
		Adresse adresse = new Adresse(vile, region, cp);
		if (clientPar) {
			ClientParticulier client;
			client = new ClientParticulier(nom, prenom, cptfb);
			client.setAdresse(adresse);
			client.setNote(note);
			client.setMaxCredit(Double.parseDouble(credit));
			client.setTelephone(tele);
			client.setEmail(mail);
			accesRMI.AddClientParticulier(client);
		} else {
			ClientEntreprise client;
			client = new ClientEntreprise(nom, reg, faxe);
			client.setAdresse(adresse);
			client.setNote(note);
			client.setMaxCredit(Double.parseDouble(credit));
			client.setTelephone(tele);
			client.setEmail(mail);
			accesRMI.AddClientEntreprise(client);
		}

	}



	public static void modifClinetAction(long clientID, String nom,	
			String prenom, String faxe, String cptfb, String mail,
			String credit, String note, String reg, String tele,
			boolean faceBookJaime, boolean clientPar,long adId, String vile,
			String region, String cp) throws Exception {
		Client client;

		Adresse adresse = new Adresse(vile, region, cp);
		adresse.setId(adId);
		if (clientPar) {
			client = new ClientParticulier(nom, prenom, cptfb);
			client.setAdresse(adresse);
			client.setNote(note);
			client.setMaxCredit(Double.parseDouble(credit));
			client.setTelephone(tele);
			client.setEmail(mail);
			
		}else{
			client = new ClientEntreprise(nom, reg, faxe);
			client.setAdresse(adresse);
			client.setNote(note);
			client.setMaxCredit(Double.parseDouble(credit));
			client.setTelephone(tele);
			client.setEmail(mail);
			client.setId(clientID);
		}
		accesRMI.modifierClient(client);
		
	}



	public static void deleteClient(long id) throws Exception {
		accesRMI.removeClient(id);
	}



	public static List<Client> search(String id, String nom,
			String pnomRC) {
	try{
		return accesRMI.chercheClients(Long.parseLong(id), nom, pnomRC);
	}catch(Exception e){
		e.printStackTrace();
		return new ArrayList<Client>();
	}
	
	
	}
}
