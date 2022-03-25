package com.cs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.bean.Cart;
import com.cs.bean.GardenDecor;
import com.cs.exception.CartException;
import com.cs.exception.GardenDecorException;
import com.cs.repository.ICartRepository;
import com.cs.repository.IGardenDecorRepository;

@Service
public class CartServiceImpl implements ICartService
{
	@Autowired
	ICartRepository cRepo;
	@Autowired
	IGardenDecorRepository gdRepo;
	
	@Override
	public Cart viewCart(int cartId) 
	{
		Optional<Cart> cart = cRepo.findById(cartId);
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		return cart.get();
	}
	
	@Override
	public Cart addGardenDecorToCart(int cartId, int gardenDecorId) 
	{
		Optional<GardenDecor> gd = gdRepo.findById(gardenDecorId);
		Optional<Cart> cart = cRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!gd.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<GardenDecor> al = cart.get().getGardenDecor();
			al.add(gd.get());
			cart.get().setGardenDecor(al);
		}
		cost = cost + gd.get().getGardenDecorPrice();
		cart.get().setCartCost(cost);
		return cart.get();
	}

	@Override
	public Cart removeGardenDecorFromCart(int cartId, int gardenDecorId) 
	{
		Optional<GardenDecor> gd = gdRepo.findById(gardenDecorId);
		Optional<Cart> cart = cRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!gd.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<GardenDecor> al = cart.get().getGardenDecor();
			al.remove(gd.get());
			cart.get().setGardenDecor(al);
		}
		cost = cost - gd.get().getGardenDecorPrice();
		cart.get().setCartCost(cost);
		return cart.get();
	}

}
