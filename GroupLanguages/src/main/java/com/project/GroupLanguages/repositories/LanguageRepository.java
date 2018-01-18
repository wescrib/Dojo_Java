package com.project.GroupLanguages.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.project.GroupLanguages.models.*;

@Repository 												
public interface LanguageRepository extends CrudRepository<Languages,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
