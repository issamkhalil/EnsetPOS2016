package controlors;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Adresse;
import com.entities.Client;
import com.entities.ClientEntreprise;
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
			String tele, boolean faceBookJaime, boolean clientPar, String vile,
			String region, String cp) {
		Adresse adresse = new Adresse(vile, region, cp);
		if (clientPar) {
			ClientParticulier client;
			client = new ClientParticulier(nom, prenom, cptfb);
			client.setAdresse(adresse);
			client.setNote(note);
			client.setMaxCredit(Double.parseDouble(credit));
			client.setTelephone(tele);
			client.setEmail(mail);
			gestionClientMetier.AddClientParticulier(client);
		} else {
			ClientEntreprise client;
			client = new ClientEntreprise(nom, reg, faxe);
			client.setAdresse(adresse);
			client.setNote(note);
			client.setMaxCredit(Double.parseDouble(credit));
			client.setTelephone(tele);
			client.setEmail(mail);
			gestionClientMetier.AddClientEntreprise(client);
		}

	}

}
