package net.franckbenault.jpa.hibernate.impl;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.franckbenault.jpa.hibernate.Bibliography;
import net.franckbenault.jpa.hibernate.Person;
import net.franckbenault.jpa.hibernate.PersonManager;

public class PersonManagerImpl implements PersonManager {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PersonManagerImpl(String persistenceUnitName) {
	    emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	    em = emf.createEntityManager();		
	}
	
	private String getReference() {
		StringBuffer buffer =new StringBuffer(40000);
		for(int i=0; i<4000; i++) {
			buffer.append('a');
		}
		return buffer.toString();
	}

	@Override
	public void createPersons() {
	    Date begin = new Date();

		em.getTransaction().begin();
		for(int i=1; i<=20000; i++) {
		    
		    Person person = new Person("f"+i);
		    Bibliography bib = new Bibliography("ref"+i, person);
		    bib.content = getReference();
		    if((i % 1000)==0){
		    	Date tempDate = new Date();
		    	long average = (tempDate.getTime()-begin.getTime())*1000/i;
		    	em.getTransaction().commit();
		    	em.getTransaction().begin();
		    	em.flush();
		    	em.clear();
		    	System.out.println(i+" average "+average);
		    }
		  
		    
		    em.persist(person);
		    em.persist(bib);
		}
		em.getTransaction().commit();

		
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
