package com.FoodDelivery.Doa;

import java.util.List;

import com.FoodDelivery.Model.Restaurant;
import com.FoodDelivery.Model.User;

public interface RestaurantDoa {
List<Restaurant> getAllRestaurant();
	
	Restaurant getRestaurant(int id);
	
	void addRestaurant(Restaurant restaurant);
	
	
	void updateRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(int id);
	

}
