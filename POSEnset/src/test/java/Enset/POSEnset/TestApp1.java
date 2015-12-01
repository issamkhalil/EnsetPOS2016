package Enset.POSEnset;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ClientDAOImpl;
import com.dao.IClientDAO;
import com.entities.Client;
import com.entities.ClientEntreprise;
import com.entities.ClientParticulier;
import com.metier.IGestionClientMetier;

public class TestApp1 {
	private IClientDAO dao;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		ClassPathXmlApplicationContext context=
		new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		IGestionClientMetier gestionClientmetier=(IGestionClientMetier) context.getBean("GestionClientMetier");
		
		System.out.println(gestionClientmetier);
		List<Client> l1=gestionClientmetier.listerClientsAll();
		
		ClientEntreprise c1= new ClientEntreprise("enset", "2533", "3336655");
		ClientEntreprise c2= new ClientEntreprise("samir", "123456", "998877");
		gestionClientmetier.AddClientEntreprise(c1);
		gestionClientmetier.AddClientEntreprise(c2);
		
		
		ClientParticulier c3= new ClientParticulier("issam", "khalil", "fb.com/issam.khalil11");
		ClientParticulier c4= new ClientParticulier("tata", "toto", "fb.com/issam");
			
		gestionClientmetier.AddClientParticulier(c3);
		gestionClientmetier.AddClientParticulier(c4);
		
		List<Client> l2=gestionClientmetier.listerClientsAll();
		
		assertTrue(l2.size()==l1.size()+4);
	}
}
