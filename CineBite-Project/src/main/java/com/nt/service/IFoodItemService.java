package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.FoodItem;

public interface IFoodItemService 
{
    FoodItem createFoodItem(FoodItem fooditem);
    Optional<FoodItem> getFoodItemById(int id);
    List<FoodItem> getListOfFoodItems();
    FoodItem UpdateFoodItem(int id,FoodItem item);
    void deleteFoodItem(int id);
   // mxkdjn;
}
