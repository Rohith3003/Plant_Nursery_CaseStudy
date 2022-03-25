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
import org.springframework.web.bind.annotation.RestController;

import com.onlineplantnursery.bean.Planter;
import com.onlineplantnursery.service.IPlanterService;

@RestController
public class PlanterController {
	
	@Autowired
	IPlanterService planterservice;
	
	@PostMapping("/addPlanter")
	public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter)
	{
		return new ResponseEntity<Planter>(planterservice.addPlanter(planter),HttpStatus.OK);
	}
	
	@GetMapping("/getPlanter/{id}")
	public ResponseEntity<Planter> getById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.getPlanterById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getPlanterByName/{name}")
	public ResponseEntity<Planter> getByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Planter>(planterservice.getPlanterByName(name),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePrice/{id}")
	public ResponseEntity<Planter> updatePrice(@RequestBody float price, @PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPrice(id, price),HttpStatus.OK);
	}
	
	@DeleteMapping("deletePlanter/{id}")
	public ResponseEntity<Planter> deleteById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.deletePlanterById(id),HttpStatus.OK);
	}
}
