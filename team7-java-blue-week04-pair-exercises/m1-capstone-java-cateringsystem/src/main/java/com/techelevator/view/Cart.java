package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	List<Transactions> display = new ArrayList<Transactions>();
	
//	public List<Transactions> addToCart(Transactions transaction) {
//		
//		 display.add(transaction);
//		
//		 return display;
//	}

	public List<Transactions> getDisplay() {
		return display;
	}

	public void addToCart(Transactions transaction) {
		
		 display.add(transaction);
		
	}
	

}
