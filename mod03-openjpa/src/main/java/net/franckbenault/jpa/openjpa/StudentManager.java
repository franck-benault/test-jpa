package net.franckbenault.jpa.openjpa;

import java.util.List;

public interface StudentManager {

	Student createStudent(Student student);
	
	void removeStudent(Student student);
	
	List<Student> findAllStudents();
	
}
