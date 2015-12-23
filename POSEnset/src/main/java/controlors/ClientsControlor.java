package controlors;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Client;
import com.entities.ClientParticulier;
import com.metier.IGestionClientMetier;
import com.metier.IGestionProduitsMetier;
import com.metier.IGestionVentesMetier;
import com.views.ClientPanel;

public class ClientsControlor {
	private static IGestionClientMetier gestionClientMetier;

	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		gestionClientMetier = (IGestionClientMetier) context
				.getBean("gestionClientMetier");
	}

	
	public static void indexAction(ClientPanel cp) {
		List<Client> clients = gestionClientMetier.listerClientsAll();
		cp.addClients(clients);
	}


	public static void choixClinetAction(ClientPanel clientPanel, long idClient) {
		
		
	}


	public static void addClinetAction(String nom, String prenom, String faxe,
			String cptfb, String mail, String credit, String note, String reg,
			String tele, boolean faceBookJaime, boolean clientPar) {
		Client client;
		if(clientPar){
			client = new ClientParticulier(nom, prenom, cptfb);
			//client.set
			
		}
			
	}

}












