package com.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private static Store store = null;

	private static List<Item> products = new ArrayList<Item>();
	private static Cart cart = new Cart();
	private static List<ItemAndQuantity> itemAndQuantityList = new ArrayList<ItemAndQuantity>();

	
	public static Store getStore() {
		if (store == null) {
			store = new Store();
			
			Item ipad = new Item(0, "ipad", "ipad", 450);
			Item iphone = new Item(1, "iphone", "iphone", 650);
			Item iwatch = new Item(2, "iwatch", "iwatch", 250);
			Item macbook = new Item(3, "macbook", "macbook", 2450);
			products.add(ipad);
			products.add(iphone);
			products.add(iwatch);
			products.add(macbook);
			cart.setCart(itemAndQuantityList);
			
		}
		return store;
	}
	
	public List<Item> getProducts() {
		return products;
	}
	
	public Cart getCart() {
		return cart;
	}
}
