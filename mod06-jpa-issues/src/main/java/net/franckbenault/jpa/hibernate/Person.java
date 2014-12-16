package net.franckbenault.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	public String fullname;

}
