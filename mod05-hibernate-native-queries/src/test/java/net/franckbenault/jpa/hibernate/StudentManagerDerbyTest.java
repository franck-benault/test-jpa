package net.franckbenault.jpa.hibernate;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import net.franckbenault.jpa.hibernate.impl.StudentManagerImpl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentManagerDerbyTest extends AbstractTester  {

	private static StudentManager studentManager;
	private static String DB_NAME = "derby";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentManager = new StudentManagerImpl(DB_NAME);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testCreateStudent() throws ClassNotFoundException, SQLException {

		int countBefore = countStudentsJDBC(DB_NAME);
		studentManager.createStudent(new Student());
		int countAfter = countStudentsJDBC(DB_NAME);

		assertEquals(countBefore + 1, countAfter);
	}



	
	@Test
	public void testCountAllStudents() throws ClassNotFoundException, SQLException {
		int countBefore = countStudentsJDBC(DB_NAME);


		int nbStudents = studentManager.countAllStudents();
		assertEquals(nbStudents, countBefore);
	}

}
