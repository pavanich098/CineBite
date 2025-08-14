package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.FoodItem;
import com.nt.repository.FoodItemRepository;

@Service

public class IFoodItemServiceImpl implements IFoodItemService 
{
	@Autowired
	private FoodItemRepository repo;

	@Override
	public FoodItem createFoodItem(FoodItem fooditem) 
	{
		// TODO Auto-generated method stub
		
		return repo.save(fooditem);
	}

	@Override
	public Optional<FoodItem> getFoodItemById(int id) 
	{
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<FoodItem> getListOfFoodItems() 
	{
		
		return repo.findAll();
	}

	@Override
	public FoodItem UpdateFoodItem(int id, FoodItem item)
	{
		// TODO Auto-generated method stub
		Optional<FoodItem> opt=repo.findById(id);
		if(opt.isPresent())
		{
			FoodItem existing=opt.get();
			existing.setName(item.getName());
			existing.setDescription(item.getDescription());
			existing.setAvailable(item.isAvailable());
			existing.setPrice(item.getPrice());
			existing.setType(item.getType());
			existing.setImageUrl(item.getImageUrl());
			return repo.save(existing);
		}
		return null;
	}

	@Override
	public void deleteFoodItem(int id) 
	{
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

}
