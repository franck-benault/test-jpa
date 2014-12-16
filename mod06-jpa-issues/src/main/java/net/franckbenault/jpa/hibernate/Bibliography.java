package net.franckbenault.jpa.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bibliography {

	@Id
	public String reference;
	
	@Column(name = "content", nullable = true, length = 4000)
	public String content;
	
	
	@OneToOne
	public Person person;
	
	public Bibliography() {
		
	}
	
	public Bibliography(String reference, Person person) {
		this.reference= reference;
		this.person = person;
	}
}
