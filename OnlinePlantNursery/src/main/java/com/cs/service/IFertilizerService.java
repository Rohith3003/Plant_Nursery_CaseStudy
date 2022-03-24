package com.cs.service;

import java.util.List;

import com.cs.bean.Fertilizer;

public interface IFertilizerService {
	
	Fertilizer addFertilizer(Fertilizer fertilizer);
	String removeFertilizerById(int id);
	Fertilizer getFertilizerById(int id);
	Fertilizer getFertilizerByName(String name);
	List<Fertilizer> getAllFertilizers();
	Fertilizer updatePriceById(int id, double price);
	Fertilizer updatePriceByName(String name, double price);
	Fertilizer updatePriceAndQuantityById(int id, double price, String quantity);
	Fertilizer removeFertilizerByName(String name);
}
