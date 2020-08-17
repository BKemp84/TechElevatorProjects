package com.techelevator.shoppingcart;

public class ShoppingCart {
	
	private int totalNumberOfItems;
	private  double totalAmountOwed;
	
	
	
	 public double getAveragePricePerItem() {
		 return totalAmountOwed/totalNumberOfItems;
	 }
	
	
	
	// public void addItems(int numberOfItems, double pricePerItem) {
		// return 
	 //}
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	
	
	
	

	
	
}
