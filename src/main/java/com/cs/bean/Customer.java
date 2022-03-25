package com.cs.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer 
{	
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String role;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loginId")
	private Login login;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable
    (
		name = "customer_garden_decor", 
		joinColumns = { @JoinColumn(name = "customer_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "garden_decor_id") }
	)
	private List<GardenDecor> gardenDecor;
}
