package it.unipv.corso.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unipv.corso.model.Person;

/**
 * It is a service class to handle
 * the Person Entity
 * @author thimo
 *
 */
@Stateless
public class PersonRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Person p) {
		em.persist(p);
	}
	
	public List<Person> findAll() {
		return em
				.createQuery("select p from Person p", Person.class)
				.getResultList();
	}
	
	public List<Person> findAllByNameAndSurname(String name, String surname) {
		return em
				.createQuery("select p from Person p where p.name = :name and p.surname = :surname", Person.class)
				.setParameter("name", name)
				.setParameter("surname", surname)
				.getResultList();
	}

}
