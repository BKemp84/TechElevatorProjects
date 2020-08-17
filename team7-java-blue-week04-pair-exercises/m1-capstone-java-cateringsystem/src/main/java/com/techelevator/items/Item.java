package com.techelevator.items;


public abstract class Item {
	
	private String name;
	private double price;

	
	public Item(String name, double price) {
		
		this.name = name;
		this.price = price;
	//	this.quantity = quantity;
		
	}
	
	public String getName() {
		return this.name;
		
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public abstract String getType();
	
	
}
