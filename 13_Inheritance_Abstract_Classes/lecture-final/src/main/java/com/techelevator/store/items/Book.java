package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Book extends Item implements Sellable {

	private String genre;
	private int pageCount;
	private double price;
	
	public Book(double price, String name, String genre, int pageCount, int weight) {
		super(5, weight, name);
		this.price = price;
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
	public boolean isOnSale() {
		return false;
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
