package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Book implements Sellable {

	private String genre;
	private int pageCount;
	private String name;
	private double price;
	
	public Book(double price, String name, String genre, int pageCount) {
		this.price = price;
		this.name = name;
		this.genre = genre;
		this.pageCount = pageCount;
	}
	
	public void read() {
		
	}
	public String getTextfromPage(int PageNumber) {
		return null;
	}
	
	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean isOnSale() {
		return false;
	}
	
	@Override
	public double getShippingCost() {
		return 5;
	}
	
}
