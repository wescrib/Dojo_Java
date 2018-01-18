package com.project.GroupLanguages.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Languages{
	@Id
	@GeneratedValue
	private long id;
	//Validators
	@Size(min = 2, max = 20, message = "Name must be longer than two characters long.")
	private String name;

	@Size(min = 2, max = 20, message = "Creator's name must be longer than two characters long")
	private String creator;

	@NotNull(message = "Version cannot be empty.")
	private double version;

	public Languages(){
	}

	public Languages(String name, String creator, double version){
		this.name 		= name;
		this.creator 	= creator;
		this.version 	= version;

	}

		public String getName(){
			return name;
		}

		public void setName(String name){
			this.name = name;
		}
		public double getVersion(){
			return version;
		}

		public void setVersion(double version){
			this.version = version;
		}

		public String getCreator(){
			return creator;
		}

		public void setCreator(String creator){
			this.creator = creator;
		}

		public long getId(){
			return id;
		}

		public void setId(Long id){
			this.id = id;
		}
		
}