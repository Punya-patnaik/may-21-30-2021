package com.synechron;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Integer> {
	
	//findBy and findAllBy methods
	//methods are named on the combinations of the fields 
	//methods vary based on the arguments 
	
	Person findByNameAndAge(String name, int age);
	Person findByAgeAndName(int age, String name);
	Person findByIdAndNameAndAge(int id, String name, int age);
	Person findByIdAndName(int id, String name);
	
	
	List<Person> findAllByNameAndAge(String name, int age);
	List<Person> findAllByAgeAndName(int age, String name);
	List<Person> findAllByIdAndNameAndAge(int id, String name, int age);
	List<Person> findAllByIdAndName(int id, String name);
	
}
