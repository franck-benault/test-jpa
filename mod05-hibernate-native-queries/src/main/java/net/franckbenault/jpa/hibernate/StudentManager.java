package net.franckbenault.jpa.hibernate;

import java.util.List;

public interface StudentManager {

	Student createStudent(Student student);
	
	List<Student> findAllStudents();
	
}
