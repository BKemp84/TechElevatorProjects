package com.techelevator.company;

public class Company {
	
	private String name = "Virtual Coffee";
	private int numberOfEmployees = 25;
	private double  revenue = 1000000.00;
	private double expenses = 250000;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	 public String getCompanySize() {
	    	if (numberOfEmployees <=50 ) {
	    		return "small";
	    	} else if (numberOfEmployees <= 250 && numberOfEmployees >50) {
	    		return "medium";
	    	}
	    	return "large";
	    	}
	public double getProfit() {
		return revenue - expenses;
	}
	
	
	
	
	//
	// Write code here
	//
	
}
