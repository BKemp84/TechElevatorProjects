package com.techelevator.items.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.items.Appetizer;
import com.techelevator.items.Beverage;
import com.techelevator.items.Dessert;
import com.techelevator.items.Entree;
import com.techelevator.items.Item;

public class Inventory {
	
	
	private static final int STARTING_QUANTITY = 50;
	
	
	
	public Map<String, InventoryItem> inventoryList(String fileName) {
		
		Map<String, InventoryItem> inventory = new LinkedHashMap<String, InventoryItem>();
		
		List<String> lines = eachLineOfFile(fileName); 
		
		
		for (String line : lines) {
			String[] parts = line.split("\\|");
			Item item = buildItemFromParts(parts);
			
			InventoryItem inventoryItem = new InventoryItem(STARTING_QUANTITY, item);
			inventory.put(parts[0], inventoryItem);
		}
		
		return inventory;
	}
	
	
	
	
	private Item buildItemFromParts(String[] parts) {
		
		String type = parts[3];
		Item item = null;
	
		if (type.equalsIgnoreCase("A")) {
			item = new Appetizer(parts[1], Double.parseDouble(parts[2]));
		} if (type.equalsIgnoreCase("B")) {
			item = new Beverage(parts[1], Double.parseDouble(parts[2]));
		
		} if (type.equalsIgnoreCase("E")) {
			item = new Entree(parts[1], Double.parseDouble(parts[2]));
		} if (type.equalsIgnoreCase("D")) {
			item = new Dessert(parts[1], Double.parseDouble(parts[2]));
		}
		
		return item;
	}
	
	
	
	
	private List<String> eachLineOfFile(String fileName) {
	
		File inventoryFile = new File(fileName);
		
		List<String> lines = new ArrayList<String>();
		
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			
			while (fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		return lines;
	}



}