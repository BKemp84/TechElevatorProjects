package com.techelevator.view;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.items.inventory.InventoryItem;
import java.util.Map.Entry;



public class Menu {

	private Scanner input = new Scanner(System.in);
	
	double totalCart = 0;
	

	public int getUserMenuSelection(String[] menuOptions, Account account) {
		
		System.out.println();
		
		
		for (int i = 1; i < menuOptions.length + 1; i++ ) {
		System.out.println("(" + i + ") " + menuOptions[i-1]);
		}
		
		
		displayAccountBalance(account.getBalance());
		System.out.println();
		
		
		String userChoice = input.nextLine();
		int userIntChoice = Integer.parseInt(userChoice);
		
		
		if (userIntChoice != 1 && userIntChoice != 2 && userIntChoice != 3) {
			System.out.println("Please enter a valid menu item");
		}
		
		
		return userIntChoice;
		
	}
	
	// -------------------------------------------------------------------------
	
	public int getAmtToAdd() {
		
		System.out.println();
		System.out.println("Enter the whole dollar amount you wish to add: ");
		String moneyToAdd = input.nextLine();
		int moneyToAddInt = Integer.parseInt(moneyToAdd);
		
		System.out.println();
		System.out.println("Would you like to enter more money? Yes or No");
		String yesNo = input.nextLine();
		
		while (yesNo.equalsIgnoreCase("yes")) {
			System.out.println();
			System.out.println("Enter the whole dollar amount you wish to add: ");
			moneyToAddInt += Integer.parseInt(input.nextLine());
			System.out.println("Would you like to enter more money? Yes or No");
			yesNo = input.nextLine();
		}
		
		
		return moneyToAddInt;
	}
	
	
	// -------------------------------------------------------------------------
	
	public void displayAccountBalance(double balance) {
		
		 System.out.println("Current Account Balance: " + balance);
	
	}
	
	// -------------------------------------------------------------------------

	
	public void displayItems(Map<String, InventoryItem> items) {
		
//		File cateringSystem = new File("cateringsystem.csv");
		
		System.out.println();

					
			for (Entry<String, InventoryItem> entries : items.entrySet()) {
				
				System.out.print(entries.getKey() + " | " );
				System.out.print(entries.getValue().getItem().getName() + " | $");
				System.out.print(entries.getValue().getItem().getPrice()+ " | ");
				
				if (entries.getValue().getCount() == 0) {
					System.out.println("Sold Out");
				} else {
				System.out.println(entries.getValue().getCount() + " available");
				}
			}
		
		}
	
	
	// -------------------------------------------------------------------------
 
	
	public String selectItems() {
		
		System.out.println();
		System.out.println("Please make a selection");
		String productCode = input.nextLine();
		
		
		
		return productCode;
		
	}
	
	
	public int selectQuantity() {
		
		System.out.println();
		System.out.println("How many would you like?");
		int quantity = Integer.parseInt(input.nextLine());
		
		return quantity;
	}
	
	
	
	// -------------------------------------------------------------------------


	public void displayErrorMessage(String message) {
		System.out.println();
		System.out.println(message);
	}
	
	
	// ------------------------------------------------------------------------
	
		public void displayCart (List<Transactions> transactions) {
			
	 
			
			System.out.println();

			System.out.println("-----------------------------");		
			
			
				for (int i = 0; i < transactions.size(); i++) {
					
					System.out.print(transactions.get(i).getAmtOrdered() + "\t");
					System.out.print(transactions.get(i).getType() + "\t");
					System.out.print("$" + transactions.get(i).getCost() + "\t");
					System.out.print("$" + transactions.get(i).getOrderTotal() + "\t");
					System.out.println();
		
					totalCart += transactions.get(i).getOrderTotal();
					
				}
			
			System.out.println();
			System.out.println("Total: $" + totalCart);
			System.out.println("-----------------------------");
			
			}
		
		
		// ------------------------------------------------------------------------
		
		
		public void giveChange(Account account) {
			

			int remaining = (int) Math.round(account.getBalance() * 100);
			double change = remaining;
			
			System.out.println("The change due is: $" + (change/100));
			
			int twenties = (int) (change / 2000);
			
			if (twenties > 0) {
				change = change % 2000;
				System.out.println(twenties + (" $20 bill(s)"));
			}
		
			
			int tens = (int) (change / 1000);
			
			if (tens > 0) {
				change = change % 1000;
				System.out.println(tens + (" $20 bill(s)"));
			}
			
			int fives = (int) (change / 500);
			
			if (fives > 0) {
				
				change = change % 500;
				System.out.println(fives + " $5 bill(s)");
				
			}
			
			int ones = (int) change / 100;
			
			if (ones > 0) {
				
				change = change % 100;
				System.out.println(ones + " $1 bill(s)");
				
			}
			
			int quarters = (int) change / 25;
			
			if (quarters > 0) {
				
				change = change % 25;
				System.out.println(quarters + " quarter(s)");
				
			}
			
			int dimes = (int) change / 10;
			
			if (dimes > 0) {
				
				change = change % 10;
				System.out.println(dimes + " dime(s)");
				
			}
			
			int nickels = (int) change / 5;
			
			if (nickels > 0) {
				
				change = change % 5;
				System.out.println(nickels + " nickel(s)");
				
			}
			
			int pennies = (int) change;
		
				System.out.println(pennies + " pennies");
				
			}
				
		
		
}
		
		
	


