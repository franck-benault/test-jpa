package net.franckbenault.jpa.hibernate;


public interface StudentManager {

	Student createStudent(Student student);
	
	int countAllStudents();
	
	void deleteAllStudents();
	
}
