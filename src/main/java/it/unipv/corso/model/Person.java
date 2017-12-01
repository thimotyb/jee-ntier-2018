package it.unipv.corso.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long personId;
	private String name;
	private String surname;
	
	@Column(name="phone_number")
	private String phoneNumber;
		
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", surname=" + surname + ", phoneNumber="
				+ phoneNumber + "]";
	}

	public Person() {
		super();
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
   
}
