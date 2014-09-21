package net.franckbenault.jpa.hibernate;

import java.util.List;

public interface CustomerManager {

	Customer createCustomer(Customer customer);
	
	List<Customer> findAllCustomers();
}
