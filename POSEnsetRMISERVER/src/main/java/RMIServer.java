import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metier.AccesRMI;
import com.metier.GestionClientMetierImpl;
import com.metier.GestionComptesMetier;
import com.metier.GestionProduitsMetier;
import com.metier.GestionVentesMetier;
import com.metier.IGestionClientMetier;
import com.metier.IGestionComptesMetier;
import com.metier.IGestionProduitsMetier;
import com.metier.IGestionVentesMetier;
import com.metier.WebAccesRMI;


public class RMIServer {

	public static void main(String[] args) {
	try{
		

			LocateRegistry.createRegistry(1099);
			WebAccesRMI webAccesRMI = new WebAccesRMI();
			AccesRMI accesRMI = new AccesRMI();


	
			Naming.rebind("rmi://localhost:1099/webac", webAccesRMI);
				System.out.println("INFO : le serveur d'acces Web est demarer ...");
			
		
			Naming.rebind("rmi://localhost:1099/accRMI", accesRMI);
				System.out.println("INFO : le serveur d'acces par l'application est demarer ...");
						
			}catch(Exception e){
				System.err.println("ERROR : le serveur d'acces Web n'a pas pu demarer la trace de l'exception :");
				e.printStackTrace();
			}
	}
}
