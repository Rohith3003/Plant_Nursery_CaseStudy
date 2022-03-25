package com.cs.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cs.bean.GardenDecor;
import com.cs.service.IGardenDecorService;

@RestController
public class GardenDecorController 
{
	@Autowired
	IGardenDecorService gdServ;
	
	@PostMapping("/addGardenDecor")
	ResponseEntity<GardenDecor> addGardenDecor(@Valid @RequestBody int id, @RequestBody GardenDecor gardenDecor) 
	{
		GardenDecor gd =  gdServ.addGardenDecor(id,gardenDecor);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	@GetMapping("/getGardenDecorById")
	ResponseEntity<GardenDecor> getTraineeById(@RequestBody int gardenDecorId) 
	{
		GardenDecor gd = gdServ.getGardenDecorById(gardenDecorId);
		return new ResponseEntity<>(gd, HttpStatus.OK);
	}
	
	@GetMapping("/getAllGardenDecor")
	List<GardenDecor> getAllGardenDecor() 
	{
		return gdServ.getAllGardenDecor();
	}
	
	@PutMapping("/updateGardenDecorNameById")
	ResponseEntity<GardenDecor> updateGardenDecorNameById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorName) 
	{
		GardenDecor gd =  gdServ.updateGardenDecorNameById(id,gardenDecorId,gardenDecorName);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateGardenDecorPriceById")
	ResponseEntity<GardenDecor> updateGardenDecorPriceById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody float gardenDecorPrice) 
	{
		GardenDecor gd =  gdServ.updateGardenDecorPriceById(id,gardenDecorId,gardenDecorPrice);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateGardenDecorImageById")
	ResponseEntity<GardenDecor> updateGardenDecorImageById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorImage) 
	{
		GardenDecor gd =  gdServ.updateGardenDecorImageById(id,gardenDecorId,gardenDecorImage);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateGardenDecorDescriptionById")
	ResponseEntity<GardenDecor> updateGardenDecorDescriptionById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorDescription) 
	{
		GardenDecor gd =  gdServ.updateGardenDecorDescriptionById(id,gardenDecorId,gardenDecorDescription);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteGardenDecorById")
	ResponseEntity<GardenDecor> updateGardenDecorById(@RequestBody int id, @RequestBody int gardenDecorId) 
	{
		GardenDecor gd =  gdServ.deleteGardenDecorById(id,gardenDecorId);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
}
