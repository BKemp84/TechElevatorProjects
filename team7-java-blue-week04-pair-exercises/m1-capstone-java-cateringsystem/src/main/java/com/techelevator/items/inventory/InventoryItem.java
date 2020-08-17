package com.techelevator.items.inventory;

import com.techelevator.items.Item;

public class InventoryItem {
	
	private int availableInv;
	private Item item;
	
	public InventoryItem(int count, Item item) {
		this.availableInv = count;
		this.item = item;
	}

	public int getCount() {
		return availableInv;
	}



	public Item getItem() {
		return item;
	}


	public boolean removeItems(int itemsToRemove) {
		
		if (availableInv - itemsToRemove < 0) {
			return false;
		}
		
		availableInv -= itemsToRemove;
		return true;
	}
	
	

}
