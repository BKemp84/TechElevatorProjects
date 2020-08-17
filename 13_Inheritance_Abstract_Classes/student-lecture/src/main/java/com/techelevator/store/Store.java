package com.techelevator.store;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.store.items.Book;
import com.techelevator.store.items.Bread;
import com.techelevator.store.items.Hellicopter;
import com.techelevator.store.items.Milk;
import com.techelevator.store.items.NewKidsOnTheBlockCd;
import com.techelevator.store.items.interfaces.Sellable;

public class Store {

	public static void main(String[] args) {
		
		List<Sellable> shoppingCart = new ArrayList<Sellable>();
		
		Sellable book = new Book(9, "Harry Potter", "YA Fanasty", 700);
		shoppingCart.add(book);
		
		Bread bread = new Bread("Wheat");
		bread.setPrice(1.89);
		bread.setShippingCost(2);
		bread.setOnSale(true);
		
		shoppingCart.add(bread);
		
		shoppingCart.add(new Hellicopter());
		
		shoppingCart.add(new Milk(2.99, 4));
		
		shoppingCart.add( new NewKidsOnTheBlockCd("Hangin Tough", 11));
		
		shoppingCart.add(new Book(59.99, "Java for Dummies", "Programming", 200));
		
		
		System.out.println("Your cart contains...");
		double cartTotal = 0;
		for (Sellable item : shoppingCart) {
			System.out.println("Product: " + item.getName());
			System.out.println("Price: " + item.getPrice() + " " + (item.isOnSale() ? "ON SALE" : ""));
			System.out.println("Shipping: " + item.getShippingCost());
			double itemTotal = item.getPrice() + item.getShippingCost();
			System.out.println("Item Total: " + itemTotal);
			cartTotal += itemTotal;
			System.out.println();
		}
		
		System.out.println("Total Purhase: " + cartTotal);
		 

	}

}
