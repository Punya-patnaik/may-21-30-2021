package com.synechron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PersonDao personDao;
	
	// DO NOT have verbs in url
	// /create/{name}/{age}
	// /load/id/{id}
	
	
	@GetMapping("name/{name}/age/{age}")
	public Person getPersonsByNameAndAge(@PathVariable String name, @PathVariable int age) {
		return personDao.findByNameAndAge(name, age);
	}
	
	@GetMapping("/all/name/{name}/age/{age}")
	public List<Person> getAllPersonsByNameAndAge(@PathVariable String name, @PathVariable int age) {
		return personDao.findAllByNameAndAge(name, age);
	}
	
	@GetMapping
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		personDao.findAll().forEach(it -> persons.add(it));
		return persons;
	}
	
	@PostMapping("/name/{name}/age/{age}")
	public String createPerson(@PathVariable String name, @PathVariable int age) {
		System.out.println(personDao.getClass().getName());
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personDao.save(person);
		return "Person with id " + person.getId() + " is created";
	}
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		Person person = null;
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			person = optPerson.get();
		}
		return person;
	}
	//@RequestMapping(method = RequestMethod.DELETE) //OLD STYLE OF CODING
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			personDao.delete(person);
			return "Person with id " + id + " is deleted";
		}
		return "Person with id " + id + " is not found";
	}
	
	//PutMapping is used to modify all the fields except the primary key in a record
	//PatchMapping is used to modify a select number of fields in a record
	//Both are usually used interchangeably
	@PatchMapping("/id/{id}/age/{age}")
	public String updateAge(@PathVariable int id, @PathVariable int age) {
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			person.setAge(age);
			personDao.save(person);
			
			return "Age updated";
		}
		return "Person with id " + id + " is not found";
	}
	
	
	
	
	
	
	
	
}
