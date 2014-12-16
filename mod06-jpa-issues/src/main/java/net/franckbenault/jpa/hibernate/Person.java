package net.franckbenault.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	public String fullname;

	
	public Person() {
		
	}
	
	public Person(String fullname) {
		this.fullname = fullname;
	}
}
