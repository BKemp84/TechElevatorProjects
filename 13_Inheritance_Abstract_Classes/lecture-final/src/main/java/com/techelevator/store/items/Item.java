package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Describable;

public abstract class Item implements Describable {

	private double baseShippingCost;
	private int weight;
	private String name;
	
	public Item(double baseShippingCost, int weight, String name) {
		this.baseShippingCost = baseShippingCost;
		this.weight = weight;
		this.name = name;
	}
	
	public double getShippingCost() {
		return baseShippingCost * weight;
	}
	
	public String getName() {
		return name;
	}
	
	protected double getBaseShippingCost() {
		return baseShippingCost;
	}
	
	public abstract boolean isDigital();

}
