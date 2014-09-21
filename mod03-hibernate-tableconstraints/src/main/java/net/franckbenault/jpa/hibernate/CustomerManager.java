package net.franckbenault.jpa.hibernate;

import java.util.List;

public interface CustomerManager {

	Customer createStudent(Customer customer);
	
	List<Customer> findAllCustomer();
}
