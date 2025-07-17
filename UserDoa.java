package com.FoodDelivery.Doa;

import java.util.List;

import com.FoodDelivery.Model.User;

public interface UserDoa {
	
	List<User> getAllUser();
	
	User getUser(int id);
	
	int  addUser(User user);
	
	
	void updateUser(User user);
	
	void deleteuser(int id);
	
	
	
	

}
