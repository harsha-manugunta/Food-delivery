package com.FoodDelivery.Model;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String itemname;
	private String description;
	private double price;
	private String isavailable;
	private String rating;
	private String imagepath;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public Menu() {
		
	}
	public Menu(int menuId, int restaurantId, String itemname, String description, double price, String isavailable,
			String rating, String imagepath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.rating = rating;
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "Menu ["+menuId+" "+" "+restaurantId+" "+ price + "]";
	}
	
	
	

}
