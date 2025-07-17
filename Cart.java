package com.FoodDelivery.Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CartItem> items;
	
	public Cart() {
		this.items=new HashMap<>();
	}
	
	
	
	
	
	
	public void addItem(CartItem item) {
		int itemId=item.getItemId();
		if(items.containsKey(itemId)) {
			CartItem existingItem=items.get(itemId);
			int newQuantity = item.getItemId();
			int oldquantity = existingItem.getQuantity();
			int totalQuanty=oldquantity+newQuantity;
			existingItem.setQuantity(totalQuanty);
		}
		else {
			items.put(itemId, item);
		}
	}
}
