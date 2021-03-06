package net.franckbenault.jpa.eclipselink.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.franckbenault.jpa.eclipselink.Student;
import net.franckbenault.jpa.eclipselink.StudentManager;


public class StudentManagerImpl implements StudentManager {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public StudentManagerImpl(String persistenceUnitName) {
	    emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	    em = emf.createEntityManager();		
	}

	@Override
	public Student createStudent(Student student) {
	    em.getTransaction().begin();
	    em.persist(student);
	    em.getTransaction().commit();
	    return student;
	}

	@Override
	public void removeStudent(Student student) {
	    em.getTransaction().begin();
	    student = em.find(Student.class,student.getId());
	    em.remove(student);
	    em.getTransaction().commit();
		
	}

	@Override
	public List<Student> findAllStudents() {
	    return em.createQuery(
	            "select s from Student s", Student.class).getResultList();
	}

}
