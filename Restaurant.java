package com.FoodDelivery.Model;

public class Restaurant {
	private int RestaurantId;
	private String Name;
	private String Address;
	private String PhoneNumber;
	private String CuisineType;
	private String DeliveryTime;
	private int AdminUserId;
	private String Rating;
	private String IsActive;
	private String ImagePath;
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getCuisineType() {
		return CuisineType;
	}
	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}
	public String getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public int getAdminUserId() {
		return AdminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		AdminUserId = adminUserId;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	public String getIsActive() {
		return IsActive;
	}
	public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime, int adminUserId, String rating, String isActive, String imagePath) {
		super();
		RestaurantId = restaurantId;
		Name = name;
		Address = address;
		PhoneNumber = phoneNumber;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		AdminUserId = adminUserId;
		Rating = rating;
		IsActive = isActive;
		ImagePath = imagePath;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant ["+ RestaurantId + "  "+ Name +"  " +PhoneNumber+" ]";
	}
	
	public Restaurant() {
	}
	
	
	
}
