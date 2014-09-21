package net.franckbenault.jpa.hibernate;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

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
		customerManager.createCustomer(new Customer());
		int countAfter = countStudentsJDBC(DB_NAME);

		assertEquals(countBefore + 1, countAfter);
	}

	
	@Test
	public void testfindAllCustomers() throws ClassNotFoundException, SQLException {
		int countBefore = countStudentsJDBC(DB_NAME);


		List<Customer> customers = customerManager.findAllCustomers();

		assertNotNull(customers);
		assertEquals(customers.size(), countBefore);
	}

}
