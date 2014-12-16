package net.franckbenault.jpa.hibernate;


public interface StudentManager {

	Student createStudent(Student student);
	
	int countAllStudents();
	
	
	int deleteAllStudents();

	void deleteSnellAllStudents();
	
	
}
