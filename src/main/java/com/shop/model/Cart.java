package com.shop.model;

import java.util.List;

public class Cart {
	private List<ItemAndQuantity> itemAndQuantities;

	public List<ItemAndQuantity> getItemAndQuantities() {
		return itemAndQuantities;
	}

	public void setCart(List<ItemAndQuantity> itemAndQuantities) {
		this.itemAndQuantities = itemAndQuantities;
	}

}
