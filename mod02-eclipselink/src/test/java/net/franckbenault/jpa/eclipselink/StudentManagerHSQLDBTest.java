package net.franckbenault.jpa.eclipselink;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;



import net.franckbenault.jpa.eclipselink.impl.StudentManagerImpl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentManagerHSQLDBTest extends AbstractTester {

	private static StudentManager studentManager;
	private static String DB_NAME = "hsqldb";

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
	public void testRemoveStudent() throws ClassNotFoundException, SQLException {
		

		Student student = studentManager.createStudent(new Student());
		int countBefore = countStudentsJDBC(DB_NAME);
		
		studentManager.removeStudent(student);
		int countAfter = countStudentsJDBC(DB_NAME);

		assertEquals(countBefore, countAfter+1);
	}
	

	@Test
	public void testfindAllStudents() throws ClassNotFoundException, SQLException {
		int countBefore = countStudentsJDBC(DB_NAME);


		List<Student> students = studentManager.findAllStudents();

		assertNotNull(students);
		assertEquals(students.size(), countBefore);
	}

}
