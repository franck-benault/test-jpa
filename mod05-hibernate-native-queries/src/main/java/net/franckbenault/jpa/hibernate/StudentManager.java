package net.franckbenault.jpa.hibernate;


public interface StudentManager {

	Student createStudent(Student student);
	
	int countAllStudents();
	
	int countSnellAllStudents();
	
	int deleteAllStudents();

	void deleteSnellAllStudents();
	
	
}
