package com.project.Authentication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Authentication.models.*;

@Repository 												
public interface BundleRepo extends CrudRepository<Bundle,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
