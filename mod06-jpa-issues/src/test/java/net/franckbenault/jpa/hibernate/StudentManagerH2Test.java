package net.franckbenault.jpa.hibernate;

import static org.junit.Assert.*;

import java.sql.SQLException;

import net.franckbenault.jpa.hibernate.impl.PersonManagerImpl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentManagerH2Test extends AbstractTester {

	private static PersonManager personManager;
	private static String DB_NAME = "h2";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		personManager = new PersonManagerImpl(DB_NAME);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreatePersons() throws ClassNotFoundException, SQLException {

		int countBefore = countStudentsJDBC(DB_NAME);
		personManager.createPersons();
		int countAfter = countStudentsJDBC(DB_NAME);

		//assertEquals(countBefore + 1, countAfter);
	}


}
