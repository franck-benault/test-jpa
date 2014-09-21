package net.franckbenault.jpa.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.RollbackException;

import net.franckbenault.jpa.hibernate.impl.CustomerManagerImpl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerManagerHSQLDBTest extends AbstractTester {

	private static CustomerManager customerManager;
	private static String DB_NAME = "hsqldb";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerManager = new CustomerManagerImpl(DB_NAME);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testCreateCustomers() throws ClassNotFoundException, SQLException {

		int countBefore = countStudentsJDBC(DB_NAME);
		Customer c= customerManager.createCustomer(new Customer("John", "Smith"));
		assertNotNull(c);
		
		int countAfter = countStudentsJDBC(DB_NAME);

		assertEquals(countBefore + 1, countAfter);
		
		List<String> constraints = countConstraints(DB_NAME);
		assertTrue(constraints.size()>0);
		assertTrue(constraints.contains("FULLNAME"));
	}
	
	
	@Test
	public void testCreateCustomers_withException() throws ClassNotFoundException, SQLException {

		Customer c = customerManager.createCustomer(new Customer("William", "Smouth"));
		assertNotNull(c);
		c = customerManager.createCustomer(new Customer("William", "Smouth"));
		assertNull(c);
	}

	
	@Test
	public void testfindAllCustomers() throws ClassNotFoundException, SQLException {
		int countBefore = countStudentsJDBC(DB_NAME);


		List<Customer> customers = customerManager.findAllCustomers();

		assertNotNull(customers);
		assertEquals(customers.size(), countBefore);
	}

}
