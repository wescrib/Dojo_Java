package com.project.DriverLicense.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.DriverLicense.models.Person;
import com.project.DriverLicense.repositories.PersonRepo;

@Service
public class PersonService {
	// Member variables / service initializations go here
	private PersonRepo personRepo;


	public PersonService(PersonRepo personRepo){
		this.personRepo = personRepo;
	}
	
	public void create(Person person){
		personRepo.save(person);
	}

	public void edit(Person person){
		personRepo.save(person);
	}

	public void delete(long id){
		personRepo.delete(id);
	}

	public ArrayList<Person> all(){
		return(ArrayList<Person>)personRepo.findAll();
	}

	// public ArrayList<Person> lastNameSearch(String person){
	// 	return (ArrayList<Person>) personRepo.findByPersonContaining(person);
	// }
	// Crud methods to act on services go here.
}
