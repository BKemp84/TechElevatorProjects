package com.techelevator.view;


public class Transactions {
	
	private int amtOrdered;
	private String type;
	private double cost;
	private double orderTotal;
	
	
	
	public Transactions(int amtOrdered, String type, double cost, double orderTotal) {
		
		this.amtOrdered = amtOrdered;
		this.type = type;
		this.cost = cost;
		this.orderTotal = orderTotal;
		
		
	}



	public int getAmtOrdered() {
		return amtOrdered;
	}



	public String getType() {
		return type;
	}



	public double getCost() {
		return cost;
	}




	public double getOrderTotal() {
		return orderTotal;
	}


	
	
	

}
