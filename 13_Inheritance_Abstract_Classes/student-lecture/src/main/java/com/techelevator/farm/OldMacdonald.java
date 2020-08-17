package com.techelevator.farm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] singables = new Singable[] {new CraftMusicBox(), new Dog(), new Tractor(), new Sheep(), new Cow(), new Chicken() };

		for (Singable singer : singables) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		
		
	
		System.out.println();
		
		Sellable[] sellables = new Sellable[] { new CraftMusicBox(), new Apple(), new Sheep(), new Cow(), new Chicken() };
		
		for (Sellable item : sellables) {
			System.out.println("The " + item.getName() + " costs " + item.getPrice());
			
		}
		
	}
}