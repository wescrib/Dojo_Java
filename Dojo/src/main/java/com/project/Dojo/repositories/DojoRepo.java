package com.project.Dojo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Dojo.models.DojoModel;

@Repository 												
public interface DojoRepo extends CrudRepository<DojoModel,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
