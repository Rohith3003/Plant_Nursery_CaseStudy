package com.cs.controller;

import java.util.List;

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

import com.cs.bean.Fertilizer;
import com.cs.dto.FertilizerDto;
import com.cs.service.IFertilizerService;

@RestController
public class FertilizerController {
	
	@Autowired
	IFertilizerService fertilizerService;
	
	@PostMapping("/addFertilizer")
	ResponseEntity<Fertilizer> addFertilizer(Fertilizer fertilizer)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.addFertilizer(fertilizer),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	ResponseEntity<String> removeFertilizerById(@PathVariable("id") int id)
	{
		return new ResponseEntity<String>(fertilizerService.removeFertilizerById(id),HttpStatus.OK);
	}
	
	@GetMapping("/fertilizer/{id}")
	ResponseEntity<Fertilizer> getFertilizerById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.getFertilizerById(id),HttpStatus.OK);
	}
	
	@GetMapping("/fertilizerByName/{name}")
	ResponseEntity<Fertilizer> getFertilizerByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.getFertilizerByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/allFertilizers")
	ResponseEntity<List<Fertilizer>> getAllFertilizers()
	{
		return new ResponseEntity<List<Fertilizer>>(fertilizerService.getAllFertilizers(),HttpStatus.OK);
	}
	
	@PutMapping("/updatePrice/{id}")
	ResponseEntity<Fertilizer> updatePriceById(@PathVariable("id") int id, @RequestBody double price)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceById(id, price),HttpStatus.OK);
	}
	
	@PutMapping("/updatePriceByName/{name}")
	ResponseEntity<Fertilizer> updatePriceByName(@PathVariable("name") String name, @RequestBody double Price)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceByName(name, Price),HttpStatus.OK);
	}
	
	@PutMapping("/updatePriceAndQuantity/{id}")
	ResponseEntity<Fertilizer> updatePriceAndQuantityById(@PathVariable("id") int id, @RequestBody FertilizerDto fertilizerDto)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceAndQuantityById(id,fertilizerDto.getPrice(),fertilizerDto.getQuantity()),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByName/{name}")
	ResponseEntity<Fertilizer> deleteFertilizerByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Fertilizer>(fertilizerService.removeFertilizerByName(name),HttpStatus.OK);
	}
}
