package com.project.DriverLicense.repositories;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.DriverLicense.models.Person;

@Repository 												
public interface PersonRepo extends CrudRepository<Person,Long>{
	// Query methods go here.
	// public ArrayList<Person> findByPersonContaining(String search);
	// Example:
	// public YourModelHere findByName(String name);
}
