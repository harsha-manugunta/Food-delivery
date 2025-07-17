package com.FoodDelivery.Model;

public class CartItem {
	
	private int itemId;
	private int restaurnatId;
	private String name;
	private int quantity;
	private double price;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurnatId() {
		return restaurnatId;
	}
	public void setRestaurnatId(int restaurnatId) {
		this.restaurnatId = restaurnatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartItem(int itemId, int restaurnatId, String name, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.restaurnatId = restaurnatId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public CartItem() {
		super();
	}

	

}
