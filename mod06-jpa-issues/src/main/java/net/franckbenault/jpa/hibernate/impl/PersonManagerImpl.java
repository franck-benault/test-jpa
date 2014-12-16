package net.franckbenault.jpa.hibernate.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.franckbenault.jpa.hibernate.PersonManager;

public class PersonManagerImpl implements PersonManager {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PersonManagerImpl(String persistenceUnitName) {
	    emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	    em = emf.createEntityManager();		
	}

	@Override
	public void createPersons() {
	    
		for(int i=0; i<20000; i++) {
			
		}
		
		/*
		em.getTransaction().begin();
	    
	    
	    
	    em.getEntityManagerFactory().getCache().evictAll();
	    
	    em.persist(student);
	    em.getTransaction().commit();
	    return student;*/
	}




	
	  
	

	


	@Override
	public int countAllPersons() {
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
