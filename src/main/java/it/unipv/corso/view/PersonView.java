package it.unipv.corso.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.unipv.corso.model.Person;
import it.unipv.corso.service.PersonRepository;

@Named
@SessionScoped
public class PersonView implements Serializable {
     
    private List<Person> persons;
    private Person newPerson = new Person();
     
    @Inject
    private PersonRepository service;
 
    @PostConstruct
    public void init() {
        persons = service.findAll();
    }
     
    public List<Person> getPersons() {
        return persons;
    }
    
    public String insertPerson() {    	
    	service.save(newPerson);
    	persons = service.findAll();
    	newPerson = new Person();
    	return null;    	
    }

	public Person getNewPerson() {
		return newPerson;
	}

	public void setNewPerson(Person newPerson) {
		this.newPerson = newPerson;
	}
 
}
