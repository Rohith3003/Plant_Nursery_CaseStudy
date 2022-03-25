package com.onlineplantnursery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineplantnursery.bean.Planter;
import com.onlineplantnursery.bean.Type;

@SpringBootTest
public class PlanterServiceTest {
	
	@Autowired
	IPlanterService planterService;
	
	Planter returned_planter;
	@Test 
	@Disabled
	public void addPlanterTest()
	{
		Planter planter=new Planter();
//		planter.setCategory(Type.CERMAIC_POT);
//		planter.setDescription("This is Ceramic type pot");
//		planter.setName("Cream Stripes M");
//		planter.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
//		planter.setPrice(650);
		planter.setCategory(Type.PLASTIC_POT);
		planter.setDescription("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.");
		planter.setName("Brown M plain");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg");
		planter.setPrice(800);
		returned_planter=planterService.addPlanter(planter);
//		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
//		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
//		assertEquals("Cream Stripes M", returned_planter.getName());
//		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
//		assertEquals(650, returned_planter.getPrice());
	}
	
	@Test
	//@Disabled
	public void getPlanterByIdTest()
	{
		Planter returned_planter=planterService.getPlanterById(69);
		assertEquals("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.", returned_planter.getDescription());
		assertEquals(Type.PLASTIC_POT, returned_planter.getCategory());
		assertEquals("Brown M plain", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_planter.getPhotoLoc());
		assertEquals(777, returned_planter.getPrice());
	}
	
	@Test
	public void getPlanterByNameTest()
	{
		Planter returned_planter=planterService.getPlanterByName("Cream Stripes M");
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_planter.getPhotoLoc());
		assertEquals(777, returned_planter.getPrice());
	}
	
	@Test
	//@Disabled
	public void deletePlanterByIdTest()
	{
		Planter returned_planter=planterService.deletePlanterById(70);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_planter.getPhotoLoc());
		assertEquals(777, returned_planter.getPrice());
	}
	
	@Test
	public void updatePlanterPrice()
	{
		Planter returned_planter=planterService.updatePlanterPrice(68,777);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_planter.getPhotoLoc());
		assertEquals(777, returned_planter.getPrice());
	}
}
