package com.onlineplantnursery.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Seed {

	@Id
	@GeneratedValue
	private int seedId;
	
	//name should not be empty
	//name should have at least 2 characters

	
	@NotEmpty
	@Size(min=4, message="Seed name should have atleast 4 characters")
	private String name;
	
	@NotEmpty
	@Size(min=1, message="Price should not be less than Rs. 1")
	private double price;
	
	@NotEmpty
	@Size(min=1, message="Number of seeds per packet should not be less than 1")
	private int numberOfSeeds;
	
	
	private String description;

	

	public void setName(String name) {
		this.name = name;
	}

	

	public int getNumberOfSeeds() {
		return numberOfSeeds;
	}



	public void setNumberOfSeeds(int numberOfSeeds) {
		this.numberOfSeeds = numberOfSeeds;
	}



	public int getSeedId() {
		return seedId;
	}



	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}



	public String getName() {
		return name;
	}



	public Seed(int seedId, String name, double price, int numberOfSeeds, String description) {
		
		this.seedId = seedId;
		this.name = name;
		this.setPrice(price);
		this.numberOfSeeds = numberOfSeeds;
		this.setDescription(description);
	}


	public Seed() {
		
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}


}
