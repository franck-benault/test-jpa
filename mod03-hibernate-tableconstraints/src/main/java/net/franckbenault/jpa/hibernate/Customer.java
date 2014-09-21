package net.franckbenault.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEV_CUSTOMER")
public class Customer {

	public Customer(String firstname , String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	  @Id
	  private long id = System.currentTimeMillis();

	  private String firstname;
	  
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	  

}
