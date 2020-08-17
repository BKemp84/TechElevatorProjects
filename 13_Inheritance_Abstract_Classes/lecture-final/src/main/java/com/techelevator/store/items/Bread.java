package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Bread extends Item implements Sellable {

	private String type;

	private double price;
	private boolean isOnSale;

	public Bread(String type) {
		super(.5, 1, type + " Bread");
		this.type = type;
	}
	
	@Override
	public double getPrice() {
		return price;
	}



	@Override
	public boolean isOnSale() {
		return isOnSale;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Override
	public boolean isDigital() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
