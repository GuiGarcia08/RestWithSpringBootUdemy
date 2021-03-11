package br.com.guilherme.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.guilherme.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Guilherme");
		person.setLastName("Garcia");
		person.setAddress("Rio Preto - SP");
		person.setGender("Male");
		return person ;
	}
	
	public List<Person> findAll(){
		List<Person> Persons = new ArrayList<Person>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			Persons.add(person);
		}
		return Persons ;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Some address in Brasil" + i);
		person.setGender("Male");
		return person ;
	}
}
