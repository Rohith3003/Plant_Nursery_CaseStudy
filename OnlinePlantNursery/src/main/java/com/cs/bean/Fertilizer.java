package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fertilizer {
	
	@Id
	@GeneratedValue
	int fertilizerId;
	String name;
	String imageURL;
	double price;
	String description;
	String quantity;

}
