package com.cs.service;

import com.cs.bean.Cart;

public interface ICartService 
{
	Cart viewCart(int cartId);
	Cart addGardenDecorToCart(int cartId, int gardenDecorId);
	Cart removeGardenDecorFromCart(int cartId, int gardenDecorId);
	/*Cart addSeedToCart(int cartId, int seedId);
	Cart removeSeedFromCart(int cartId, int seedId);
	Cart addPlantToCart(int cartId, int PlantId);
	Cart removePlantFromCart(int cartId, int PlantId);
	Cart addFertilizerToCart(int cartId, int fertilizerId);
	Cart removeFertilizerFromCart(int cartId, int fertilizerId);
	Cart addPlanterToCart(int cartId, int planterId);
	Cart removePlanterFromCart(int cartId, int planterId);*/
	
}
