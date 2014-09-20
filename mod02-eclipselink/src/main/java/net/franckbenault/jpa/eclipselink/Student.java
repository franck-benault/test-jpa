package net.franckbenault.jpa.eclipselink;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Student {
  @Id
  private long id = System.currentTimeMillis();

  @Basic
  private String name;

  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date dateOfBirth = new Date();

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
}

