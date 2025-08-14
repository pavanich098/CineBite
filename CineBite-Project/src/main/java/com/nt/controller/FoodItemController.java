package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.FoodItem;
import com.nt.service.IFoodItemService;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemController 
{
	@Autowired
    private IFoodItemService service;
	@PostMapping("/create")
	public FoodItem Create(@RequestBody FoodItem item)
	{
		return service.createFoodItem(item);
	}
	
	@GetMapping("/{id}")
	
	public Optional<FoodItem> getFoodItembyId(@PathVariable int id)
	{
		return service.getFoodItemById(id);
	}
	
	@GetMapping("/all")
	public List<FoodItem> listOfAllItems()
	{
		return service.getListOfFoodItems();
	}
	
	@PutMapping("/update/{id}")
	public FoodItem updateFoodItem(@PathVariable int id,@RequestBody FoodItem item)
	{
		return service.UpdateFoodItem(id, item);
	}
	
	@DeleteMapping("/delete/{id}")
	
	public void deleteFoodItem(@PathVariable int id)
	{
		service.deleteFoodItem(id);
	}
}
