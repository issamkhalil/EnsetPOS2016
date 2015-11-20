package Enset.POSEnset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.dao.GestionClientDAOImpl;
import com.dao.IGestionClientDAO;

public class TestApp1 {
	private IGestionClientDAO dao;
	@Before
	public void setUp() throws Exception {
	dao =new GestionClientDAOImpl();
	}

	@Test
	public void test() {
		assertTrue(true);
	}

}
