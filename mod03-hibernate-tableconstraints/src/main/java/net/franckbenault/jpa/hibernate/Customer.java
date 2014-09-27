package net.franckbenault.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="DEV_CUSTOMER", 
uniqueConstraints=@UniqueConstraint(name="FULLNAME", columnNames={"firstname", "lastname"})
   )
public class Customer {

	public Customer() {
	}
	
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
