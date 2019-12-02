package com.shop.model;

public class ItemAndQuantity {
	private Item item;
	private int quantity;
	public Item getItem() {
		return item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemAndQuantity other = (ItemAndQuantity) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	public ItemAndQuantity(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
}
