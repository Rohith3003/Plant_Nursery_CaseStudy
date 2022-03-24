package com.cs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Fertilizer;
import com.cs.exception.FertilizerNotFoundException;

@SpringBootTest
class FertilizerServiceTest {

	@Autowired
	IFertilizerService fertilizerService;
	
	@Test
	void getAllFertilizersTest() {
		List<Fertilizer> fertilizers = fertilizerService.getAllFertilizers();
		assertEquals(4,fertilizers.size());
	}

	@Test
	@Disabled
	void addFertilizer()
	{
		Fertilizer fertilizer  = new Fertilizer();
		fertilizer.setName("vermicompost");
		fertilizer.setPrice(99.99);
		fertilizer.setQuantity("5KG");
		fertilizer.setImageURL("www.google.com/vermicompost");
		fertilizer.setDescription("It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.");
		
		//persisting object in database
		Fertilizer fertilizer1 = fertilizerService.addFertilizer(fertilizer);
		
		//verifying the result
		assertEquals("vermicompost",fertilizer1.getName());
		assertEquals(99.99,fertilizer1.getPrice());
		assertEquals("5KG",fertilizer1.getQuantity());
		assertEquals("www.google.com/vermicompost",fertilizer1.getImageURL());
		assertEquals("It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.",fertilizer1.getDescription());
	}
	
	@Test
	@Disabled
	public void  removeFertilizerByIdTest()
	{
		fertilizerService.removeFertilizerById(11);
		Exception exception = assertThrows(FertilizerNotFoundException.class, () -> {
			fertilizerService.getFertilizerById(11);
	    });
		String expectedMessage = "Fertilizer with the given id: 11 is not found";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void getFertilizerByIdTest()
	{
		Fertilizer fertilizer = fertilizerService.getFertilizerById(1);
		assertEquals(1,fertilizer.getFertilizerId());
		assertEquals(49.99,fertilizer.getPrice());
		assertEquals("compost",fertilizer.getName());
		assertEquals("www.google.com/compost",fertilizer.getImageURL());
		assertEquals("The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.",fertilizer.getDescription());
		assertEquals("1KG",fertilizer.getQuantity());
	}
	
	@Test
	@Disabled
	public void getFertilizerByNameTest()
	{
		Fertilizer fertilizer = fertilizerService.getFertilizerByName("vermicompost");
		assertEquals(12,fertilizer.getFertilizerId());
		assertEquals(99.99,fertilizer.getPrice());
		assertEquals("vermicompost",fertilizer.getName());
		assertEquals("www.google.com/vermicompost",fertilizer.getImageURL());
		assertEquals("It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.",fertilizer.getDescription());
		assertEquals("5KG",fertilizer.getQuantity());
	}
	
	@Test
	@Disabled
	public void updatePriceById()
	{
		Fertilizer fertilizer = fertilizerService.updatePriceById(12, 89.99);
		assertEquals(12,fertilizer.getFertilizerId());
		assertEquals(89.99,fertilizer.getPrice());
	}
	
	@Test
	@Disabled
	public void updatePriceByName()
	{
		Fertilizer fertilizer = fertilizerService.updatePriceByName("plant food", 299.99);
		assertEquals("plant food",fertilizer.getName());
		assertEquals(299.99,fertilizer.getPrice());
	}
	
	@Test
	@Disabled
	public void updatePriceAndQuantityById()
	{
		Fertilizer fertilizer = fertilizerService.updatePriceAndQuantityById(5, 549.99, "2KG");
		assertEquals("2KG",fertilizer.getQuantity());
		assertEquals(549.99,fertilizer.getPrice());
		assertEquals(5, fertilizer.getFertilizerId());
	}
	
	@Test
	@Disabled
	public void removeFertilizerByName()
	{
		Fertilizer fertilizer = fertilizerService.removeFertilizerByName("vermicompost");
		assertEquals(12,fertilizer.getFertilizerId());
		assertEquals(89.99,fertilizer.getPrice());
		assertEquals("vermicompost",fertilizer.getName());
		assertEquals("www.google.com/vermicompost",fertilizer.getImageURL());
		assertEquals("It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.",fertilizer.getDescription());
		assertEquals("5KG",fertilizer.getQuantity());
	}
	
}
