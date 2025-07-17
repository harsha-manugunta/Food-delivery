package com.FoodDelivery.Doa;

import java.util.List;

import com.FoodDelivery.Model.Menu;
import com.FoodDelivery.Model.Restaurant;

public interface MenuDoa {
List<Menu> getAllMenuDetails();
	
	Menu getMenuDetails(int id);
	
	void addMenu(Menu menu);
	
	
	void updateMenu(Menu menu);
	
	void deleteMenu(int id);

}
