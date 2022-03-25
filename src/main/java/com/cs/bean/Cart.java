package com.cs.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Cart 
{
	@Id
	@GeneratedValue
	private int cartId;
	private double cartCost;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable
    (
		name = "cart_garden_decor", 
		joinColumns = { @JoinColumn(name = "cart_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "garden_decor_id") }
	)
	private List<GardenDecor> gardenDecor;
	
}
