package com.techelevator.tv;

import java.util.Scanner;

import com.techelevator.Television;

public class TelevisionApp {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		Television tv = new Television();
		
		while (true) {
			showTelevisionStatus(tv);
		
			System.out.print("(T)urn On, (O)ff, (C)hange Channel >>>");
			
			String userInput = input.nextLine();
			if (userInput.equalsIgnoreCase("T")) {
				tv.turnOn();
			} else if (userInput.equalsIgnoreCase("O")) {
				tv.turnOff();
				break;
			} else if (userInput.equalsIgnoreCase("C")) {
				System.out.print("What channel? >>>");
				int newChannel = input.nextInt();
				input.nextLine();
				tv.changeChannel(newChannel);
			}
		}
		
	}
	
	private static void showTelevisionStatus(Television tv) {
		System.out.println("The Television is " + (tv.isOn() ? "On" : "Off"));
		System.out.println("Current Channel is: " + tv.getCurrentChannel());
		System.out.println("Current Volume is: " + tv.getCurrentVolume());
	}

}
