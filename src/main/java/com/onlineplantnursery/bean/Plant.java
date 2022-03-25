package com.onlineplantnursery.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Plant {
	@Id
	@GeneratedValue
	private int plantId;
	private String name;
	private double price;
	private String type;
	private String description;
}
