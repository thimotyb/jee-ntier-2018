package it.unipv.corso.ws;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;

import it.unipv.corso.model.Person;
import it.unipv.corso.service.PersonRepository;

/**
 * A web service to be used for SoapUI stress
 * @author thimo
 *
 */
@WebService
public class InsertPerson {

	@Inject PersonRepository service;
	
	public String insert(@WebParam(name = "name") String name, 
			@WebParam(name = "surname") String surname, 
			@WebParam(name = "phone") String phone) {
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setPhoneNumber(phone);
		service.save(p);
		return "OK "+p;
	}
	
}
