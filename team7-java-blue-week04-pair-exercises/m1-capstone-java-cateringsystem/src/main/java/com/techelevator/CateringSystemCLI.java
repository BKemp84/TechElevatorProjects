package com.techelevator;

import java.util.Map;

import com.techelevator.items.inventory.Inventory;
import com.techelevator.items.inventory.InventoryItem;
import com.techelevator.items.inventory.LogWriter;
import com.techelevator.view.Account;
import com.techelevator.view.Cart;
import com.techelevator.view.Menu;
import com.techelevator.view.Transactions;

public class CateringSystemCLI {

	
	private Menu menu = new Menu();
	private Inventory inventory = new Inventory();
	private Account account = new Account();
	private LogWriter logWriter = new LogWriter();
	private Cart cart = new Cart();
	private boolean sameCustomer = true;
	
	private String[] mainMenu = {"Display Catering Items", "Order", "Quit"};
	private String[] purchaseMenu = {"Add Money", "Select Products", "Complete Transaction"};

	
	
	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	
	
	public void run() {
		
		Map<String, InventoryItem> items = inventory.inventoryList("cateringsystem.csv");
		
		
		while (sameCustomer) {

			int userIntChoice = menu.getUserMenuSelection(mainMenu, account);
			
			
			
				if (userIntChoice == 1) {
					
					menu.displayItems(items);

					continue;
					
					
				} else if (userIntChoice == 2) {
				
					int userPurchaseMenuChoice = menu.getUserMenuSelection(purchaseMenu, account);

					
					if (userPurchaseMenuChoice == 1) {
						
					int amount = menu.getAmtToAdd();
					
						if (account.getBalance() + amount > 5000) {
							
							menu.displayErrorMessage("Account balance cannot exceed $5000!");
							amount = menu.getAmtToAdd();
						
						} else {
					
							account.updateBalance(amount);
							logWriter.writeToLog("ADD MONEY", amount, account.getBalance());
							
						}
			
					} else if (userPurchaseMenuChoice == 2) {
					
					
						menu.displayItems(items);
					
						String productCode = menu.selectItems();
					
						if (!items.containsKey(productCode)) {
						
							menu.displayErrorMessage("This product code does not exist!");
							menu.displayItems(items);
						}
					
					
						if (items.get(productCode).getCount() == 0) {
							menu.displayErrorMessage("Sold Out");
							menu.displayItems(items);
						}
					
					
						int amtRequested = menu.selectQuantity();
					
					
					// pass these variables into new method that does this! 
						
						if ((items.get(productCode).getItem().getPrice() * amtRequested) > account.getBalance()) {
							menu.displayErrorMessage("You do not have enough funds to make this purchase, please add money to continue");
							continue;
						}
					
						if (amtRequested <= items.get(productCode).getCount()) {
					
							items.get(productCode).removeItems(amtRequested);
							account.updateBalance(-(items.get(productCode).getItem().getPrice() * amtRequested));
							logWriter.writeToLog(amtRequested + " " + items.get(productCode).getItem().getName(), (items.get(productCode).getItem().getPrice() * amtRequested), account.getBalance());
						
							Transactions newTransaction = new Transactions(amtRequested, items.get(productCode).getItem().getName(),items.get(productCode).getItem().getPrice() ,(items.get(productCode).getItem().getPrice() * amtRequested));
							cart.addToCart(newTransaction);
						//	menu.getUserMenuSelection(purchaseMenu, account);
							continue;
								
						} else if  (items.get(productCode).getCount() < amtRequested) {
							menu.displayErrorMessage("Insufficient Stock");
							menu.displayItems(items);
						}
					
					
						menu.displayItems(items);
					
					
					} else if (userPurchaseMenuChoice == 3) { 
					
						menu.displayCart(cart.getDisplay());
						menu.giveChange(account);
						logWriter.writeToLog("GIVE CHANGE:", account.getBalance(), 0.00);
						account.updateBalance(-account.getBalance());
						continue;
					
					}
					
				} else {	
					
					logWriter.clearLog();
					sameCustomer = false;
	
				}
			
			
		}

	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
