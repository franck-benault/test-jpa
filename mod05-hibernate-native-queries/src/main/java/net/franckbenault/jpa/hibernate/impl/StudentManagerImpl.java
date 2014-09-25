package net.franckbenault.jpa.hibernate.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.franckbenault.jpa.hibernate.Student;
import net.franckbenault.jpa.hibernate.StudentManager;

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
	public int countAllStudents() {
		
	    Object res = em.createNativeQuery(
	            "select count(*) from Student s").getSingleResult();
	    if(res instanceof BigInteger) {
	    	BigInteger res2 = (BigInteger) res;
	    	return res2.intValue();
	    } else {
	    	Integer res2 = (Integer) res;
	    	return res2.intValue();	
	    }
	    
	}
}
