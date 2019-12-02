package com.shop.model;


public class Item  {
	public Item ()
	{}
	
	public Item(int id, String title, String desc, int price) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.price = price;
	}
	
	private int id;
    private String title;
    private String desc;
    private int price;
    
    public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDesc() {
		return desc;
	}
	public int getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", desc=" + desc + ", price=" + price + "]";
	}

	
}