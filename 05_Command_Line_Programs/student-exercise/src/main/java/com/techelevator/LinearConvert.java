package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the length:");
		
		String lengthToBeConverted = in.nextLine();
		int lengthNum = Integer.parseInt(lengthToBeConverted);
		System.out.print("Is the measurement in (m) or (f)?");
				
		String measurementType = in.nextLine();
		
		if (measurementType.equals("m")) {

		 System.out.printf((lengthNum * 3.2808399) + "F is " + lengthNum +" meters");
	}else if (measurementType.equals("f")) {
		System.out.println((lengthNum * .3048) + "M is " + lengthNum + " feet");
	} 
	}
}
