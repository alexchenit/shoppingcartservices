package com.shop.rest;


import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Cart;
import com.shop.model.Item;
import com.shop.model.ItemAndQuantity;
import com.shop.model.Store;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ShoppingCartController {

	private List<Item> products;
	private Cart cart;
	
	
	@PostConstruct
	private void prepareData() {
		products = Store.getStore().getProducts();
		cart = Store.getStore().getCart();
	}	
	

    @PostMapping("/products")
    public List<Item> getAllProducts() {
    	
        return this.products;
    }    
    
    @PostMapping("/cart")
    public Cart getCart() {
    	return this.cart;
    }
    
    @PostMapping(path="/addItem", consumes = "application/json")
    public void addItem(@RequestBody Item item) {
    	if (item == null ) return;
    	Item p = this.products.get(item.getId());
    	item.setTitle(p.getTitle());
    	item.setDesc(p.getDesc());
    	item.setPrice(p.getPrice());
    	List<ItemAndQuantity> list = this.cart.getItemAndQuantities();
    	ItemAndQuantity iq = new ItemAndQuantity(item, 1);
    	if (list.contains(iq)) {
    		list.stream().forEach(e->{
    			if (e.getItem().equals(item)) {
    				e.setQuantity(e.getQuantity()+1);
    			}
    		});
    	} else {
    		this.cart.getItemAndQuantities().add(iq);
    	}
    }
    
    
    @PostMapping(path="/decItem", consumes = "application/json")
    public void decItem(@RequestBody Item item) {
    	if (item == null ) return;
    	List<ItemAndQuantity> list = this.cart.getItemAndQuantities();
    	ItemAndQuantity iq = new ItemAndQuantity(item, 1);
    	if (list.contains(iq)) {
    		list.stream().forEach(e->{
    			if (e.getItem().equals(item)) {
    				if (e.getQuantity() > 1) {
    					e.setQuantity(e.getQuantity()-1);
    				} else {
    					list.remove(iq);
    				}
    			}
    		});
    	}
    }
    
    @PostMapping(path = "/removeItem", consumes = "application/json")
    public void removItem(@RequestBody Item item) {
    	if (item == null ) return;
    	List<ItemAndQuantity> list = this.cart.getItemAndQuantities();
    	ItemAndQuantity iq = new ItemAndQuantity(item, 1);
    	if (list.contains(iq)) {
    		list.stream().forEach(e->{
    			if (e.getItem().equals(item)) {
    				list.remove(iq);
    			}
    		});
    	}
    }
}