package com.synechron;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonDao extends CrudRepository<Person, Integer> {
	
	//findBy and findAllBy methods
	//methods are named on the combinations of the fields 
	//methods vary based on the arguments 
	
	@Query("select p from Person p where p.cars.size >= 2")
	List<Person> getPersonsWithAtleast2Cars();
	
	@Query(value = "select * from persons where age > :p1", nativeQuery = true)
	List<Person> findAllWithAgeGt(@Param("p1") int age);
	
	//JPA QL : Query classes and fields
	@Query("select p from Person p where p.age > :p1")
	List<Person> findPersonsWithAgeGt(@Param("p1") int age);
	
	@Modifying
	@Query("update Person p set p.age = :age where p.id = :id ")
	void updateAgeOf(@Param("id") int id, @Param("age") int newAge);
	
	
	Person findByNameAndAge(String name, int age);
	Person findByAgeAndName(int age, String name);
	Person findByIdAndNameAndAge(int id, String name, int age);
	Person findByIdAndName(int id, String name);
	
	
	List<Person> findAllByNameAndAge(String name, int age);
	List<Person> findAllByAgeAndName(int age, String name);
	List<Person> findAllByIdAndNameAndAge(int id, String name, int age);
	List<Person> findAllByIdAndName(int id, String name);
	
}
