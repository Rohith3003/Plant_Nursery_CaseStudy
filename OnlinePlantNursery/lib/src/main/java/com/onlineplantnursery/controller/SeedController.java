package com.onlineplantnursery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineplantnursery.bean.Seed;
import com.onlineplantnursery.service.ISeedService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
//@RequestMapping("/opn")
public class SeedController {
	@Autowired
	//bean mapping
	ISeedService seedService;
	
	@PostMapping("/addSeed")
	 ResponseEntity<Seed> addSeed(@Valid @RequestBody Seed seed)
	{
		Seed s= seedService.addSeed(seed);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
		 //return new ResponseEntity<Seed>(seedService.addSeed(seed),HttpStatus.OK);
	}
	
	@GetMapping("/getSeed/{id}")
	public ResponseEntity<Seed> getById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Seed>(seedService.getSeedById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getSeedByName/{name}")
	public ResponseEntity<Seed> getByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Seed>(seedService.getSeedByName(name),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePrice/{id}")
	public ResponseEntity<Seed> updatePrice(@RequestBody float price, @PathVariable("id") int id)
	{
		return new ResponseEntity<Seed>(seedService.updateSeedPrice(id, price),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteSeed/{id}")
	public ResponseEntity<Seed> deleteById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Seed>(seedService.deleteSeedById(id),HttpStatus.OK);
	}
}
