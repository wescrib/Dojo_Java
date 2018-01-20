package com.project.DriverLicense.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.DriverLicense.models.License;
import com.project.DriverLicense.repositories.LicenseRepo;

@Service
public class LicenseService {
	// Member variables / service initializations go here
	private LicenseRepo licenseRepo;


	public LicenseService(LicenseRepo licenseRepo){
		this.licenseRepo = licenseRepo;
	}

	public void create(License license){
		licenseRepo.save(license);
	}

	public void edit(License license){
		licenseRepo.save(license);
	}

	public void delete(long id){
		licenseRepo.delete(id);
	}

	public License findById(long id){
		return licenseRepo.findOne(id);
	}

	public ArrayList<License> all(){
		return(ArrayList<License>)licenseRepo.findAll();

	}


	public String generateNumber(){
		String numbers = "0123456789";
		String newNumber = "";
		Random rand = new Random();
		for (int i=0; i < 5; i++){
			int num = numbers.charAt(rand.nextInt(10));
			newNumber += num;
		}
		return newNumber;
	}

	// public ArrayList<License> lastNameSearch(String license){
	// 	return (ArrayList<License>) licenseRepo.findByLicenseContaining(license));
	// }
	
	// Crud methods to act on services go here.
}
