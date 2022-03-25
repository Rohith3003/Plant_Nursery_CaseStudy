package com.onlineplantnursery.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.checkerframework.checker.units.qual.min;
import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Entity
@Data
public class Planter {
	@Id
	@GeneratedValue
	private int planterId;// Auto generated unique value 
	
	@URL
	private String photoLoc;//Url of the image
	
	@NotEmpty(message = "Planter name can't be empty")
	@Size(min=5,message = "Planter name should be min 5 character")
	private String name; //Signifies more details of the produect like color,size,model etc. Eg. Brown M plain
	
	//private enum planterType {PLASTIC_POT,CERMAIC_POT,DESIGNER_POT,HANGING_BUCKET,TOWER_PLANTER};
	private Type category; //Belongs to one of the pre-defined enum Type
	
	@NotEmpty
	@Size(min=10,max=30,message = "Description should be atleast 10 char and maximum 30 chars")
	private String description;//Description of the product
	
	@Min(100)
	private float price;//Price of the planter
}
