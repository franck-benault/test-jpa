package net.franckbenault.jpa.hibernate.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.franckbenault.jpa.hibernate.Customer;
import net.franckbenault.jpa.hibernate.CustomerManager;

public class CustomerManagerImpl implements CustomerManager {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CustomerManagerImpl(String persistenceUnitName) {
	    emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	    em = emf.createEntityManager();		
	}
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			return customer;
		} catch (RuntimeException error) {
		    if (em.getTransaction().isActive()) {
		      em.getTransaction().rollback();
		    }
		    //em.flush();
		    em.clear();
		    return null;
		  }
	}

	@Override
	public List<Customer> findAllCustomers() {
	    return em.createQuery(
	            "select c from Customer c", Customer.class).getResultList();
	}

}
