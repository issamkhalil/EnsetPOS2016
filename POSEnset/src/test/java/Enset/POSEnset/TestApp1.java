package Enset.POSEnset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.GestionClientDAOImpl;
import com.dao.IGestionClientDAO;
import com.entities.Client;
import com.entities.ClientEntreprise;

public class TestApp1 {
	private IGestionClientDAO dao;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {

		try {
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			assertTrue(true);
		} catch (Exception e) {
			System.err.println(e);
			assertTrue(e.getMessage(), false);
		}
	}
}
