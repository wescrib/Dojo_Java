package com.project.DriverLicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.DriverLicense.models.License;

@Repository 												
public interface LicenseRepo extends CrudRepository<License,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
