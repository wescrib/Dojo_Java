package com.project.DriverLicense.models;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class License{
	@Id
	@GeneratedValue
	private long id;

	private String number;

	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	// private String number;
	private Date expirationDate;
	private String state;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}

	// @PrePersist
	// public void onExpire(){
	// 	// this.expirationDate = Calendar.getInstance();
	// 	this.expirationDate = new Date();
	// }

	public Person getPerson(){
		return person;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	// private String generateNumber(){
	// 	String numbers = "0123456789";
	// 	String newNumber = "";
	// 	Random rand = new Random();
	// 	for (int i=0; i < 5; i++){
	// 		int num = numbers.charAt(rand.nextInt(10));
	// 		newNumber += num;
	// 	}
	// 	this.number=newNumber;

	// 	return this.number;
	// }

	// public void setNumber(String number){
	// 	this.number = String.valueOf(longNumber);
	// }

	public String getNumber(){
		return number;
	}

	public Date getExpirationDate(){
		return expirationDate;
	}

	public void setState(String state){
		this.state=state;
	}

	public String getState(){
		return state;
	}
	
	// Setters and Getters go here
	
	public License(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public License(String state, Person person, Date expirationDate, String number){
		this.state = state;
		this.person = person;
		this.expirationDate = expirationDate;
		this.number = number;
	}
}
