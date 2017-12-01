package it.unipv.corso.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.unipv.corso.model.Person;
import it.unipv.corso.service.PersonRepository;

@RunWith(Arquillian.class)
public class HelloTest extends ArquillianTest {

	@Inject
	PersonRepository personService;
	
	@Test
	public void shouldSaveAPerson() {
		
		Person p = new Person();
		p.setName("Adriana");
		p.setSurname("Lima");
		p.setPhoneNumber("33812345678");
		
		personService.save(p);
		
		List<Person> personList = personService.findAllByNameAndSurname("Adriana", "Lima");
		
		assertTrue("Adriana is there", !personList.isEmpty());
		System.out.println(personList.get(0));
		
	}
	
}
